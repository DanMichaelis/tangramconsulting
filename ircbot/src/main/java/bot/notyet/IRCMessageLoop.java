package bot.notyet;

import java.io.*;
import java.net.*;
import java.util.*;

public abstract class IRCMessageLoop implements Runnable {
    Socket server;
    OutputStream out;
    List<String> channelList;
    boolean initial_setup_status;
    boolean keepRunning = true;
    
    IRCMessageLoop(String serverName, int port) {
        channelList = new ArrayList<String>();
        try
        {
            server = new Socket(serverName, port);
            out = server.getOutputStream();
        }
        catch (IOException info)
        {}
    }

    void send(String text) {
        byte[] bytes = (text + "\r\n").getBytes();
        
        try {
            out.write(bytes);
        }
        catch (IOException info)
        {}
    }
    
    void nick(String nickname) {
        String msg = "NICK " + nickname;
        send(msg);
    }
    
    void user(String username, String hostname, String servername, String realname) {
        String msg = "USER " + username + " " + hostname + " " + servername +  " :" + realname;
        send(msg);
    }

    void join(String channel) {
        if (!initial_setup_status) {
            channelList.add(channel);
            return;
        }
        String msg = "JOIN " + channel;
        send(msg);
    }
    
    void part(String channel) {
        String msg = "PART " + channel;
        send(msg);
    }
    
    void privmsg(String to, String text) {
        String msg = "PRIVMSG " + to + " :" + text;
        send(msg);
    }
    
    void pong(String server) {
        String msg = "PONG " + server;
        send(msg);
    }
    
    void quit(String reason) {
        String msg = "QUIT :Quit: " + reason;
        send(msg);
        keepRunning = false;
    }
    
    abstract void raw(Message msg);
    
    void initial_setup() {
    
        initial_setup_status = true;
    
        // now join the channels. you need to wait for message 001 before you join a channel.
        for (String channel: channelList) {
            join(channel);
        }
        
        
    }
    
    void processMessage(String ircMessage) {
    	System.out.println("Completely raw message:  " + ircMessage);
        Message msg = MessageParser.message(ircMessage);
            
        if (msg.command.equals("privmsg")) {
            
            if (msg.getMessage().equals("\001VERSION\001")) {
                privmsg(msg.nickname, "Prototype IRC Client (Built to learn)");
                return;
            }
            raw(msg);
            System.out.println("PRIVMSG: " + msg.nickname + ": " + msg.getMessage());
        }
        else if (msg.command.equals("001")) {
            initial_setup();
            return;
        }
        else if (msg.command.equals("ping")) {
            pong(msg.getMessage());
        }
    }
    
    public void run() {
        InputStream stream = null;
        
        try
        {
            stream = server.getInputStream();
            MessageBuffer messageBuffer = new MessageBuffer();
            byte[] buffer = new byte[512];
            int count;
            
            while (keepRunning) {
                count = stream.read(buffer);
                if (count == -1)
                    break;
                messageBuffer.append(Arrays.copyOfRange(buffer, 0, count));
                while (messageBuffer.hasCompleteMessage()) {
                    String ircMessage = messageBuffer.getNextMessage();

                    System.out.println("\"" + ircMessage + "\"");
                    processMessage(ircMessage);
                }
            }
        }
        catch (IOException info)
        {
            quit("error in messageLoop");
            info.printStackTrace();
        }
    }
}
