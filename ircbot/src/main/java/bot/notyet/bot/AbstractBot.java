package bot.notyet.bot;

import java.util.ArrayList;
import java.util.Properties;

import bot.notyet.server.Channel;
import bot.notyet.server.Server;

public class AbstractBot {
	private ArrayList<Server> servers;
	private ArrayList<Channel> channels;
	private String botName;
	private String botRealName;
	private String nickName;
	
	public AbstractBot(String name, String realName, String nickName) {
		this.botName = name;
		this.botRealName = realName;
		this.nickName = nickName;
	}
	
	void initialize() {
//		getDefaultServers();
//		connectToServers(servers);
		
	}
	
	private ArrayList<Server> initializeDefaultServers(String botName) {
		Properties props = new Properties();
		return null;
	}
	
	
	
	
}
