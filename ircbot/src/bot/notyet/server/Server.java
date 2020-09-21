package bot.notyet.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Server {
	String serverAlias;
	Socket connection;
	OutputStream output;
	BufferedInputStream input;
	
	public Server(String hostname, int port) {
		try {
			connection = new Socket(hostname, port);
			output = connection.getOutputStream();
			input = new BufferedInputStream(connection.getInputStream());
		} catch (IOException e) {
			//TODO:  Handle this!
		}
	}
	
	public BufferedOutputStream getOutputStream() {
		return new BufferedOutputStream(this.output);
	}
	
	public BufferedInputStream getInputStream() {
		return this.input;
		
	}
}
