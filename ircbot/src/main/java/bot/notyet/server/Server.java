package bot.notyet.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Server {
	private String serverName;
	private String serverUrl;
	private int serverPort;
	private Boolean ssl;
	private Socket connection;
	private BufferedOutputStream output;
	private BufferedInputStream input;

	private Server() {
		
	}
	
	public Server(String serverName, String serverUrl, int serverPort, Boolean ssl) {
		this.serverName = serverName;
		this.serverPort = serverPort;
		this.serverUrl = serverUrl;
		this.ssl = ssl;

//		if (!this.ssl) {
//			try {
//				connection = new Socket(serverName, serverPort);
//				output = new BufferedOutputStream(connection.getOutputStream());
//				input = new BufferedInputStream(connection.getInputStream());
//			} catch (IOException e) {
//				// TODO: Handle this!
//			}
//		} else {
//			//TODO:  Implement SSL connectivity
//			try {
//				connection = new Socket(serverName, serverPort);
//				output = new BufferedOutputStream(connection.getOutputStream());
//				input = new BufferedInputStream(connection.getInputStream());
//			} catch (IOException e) {
//				// TODO: Handle this!
//			}
//		}
	}
	
	public Server setServerName(String serverName) {
		this.serverName = serverName;
		return this;
	}
	
	public String getServerName() {
		return serverName;
	}
	
	public Server setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
		return this;
	}
	
	public Server setServerPort(int serverPort) {
		this.serverPort = serverPort;
		return this;
	}
	
	public Server setSsl(Boolean ssl) {
		this.ssl = ssl;
		return this;
	}
	
	public String getServerUrl() {
		return serverUrl;
	}

	public int getServerPort() {
		return serverPort;
	}

	public Boolean getSsl() {
		return ssl;
	}

	@JsonIgnore
	private Socket getConnection() {
		if (null == connection) {
			try {
				connection = new Socket(serverUrl, serverPort);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	@JsonIgnore
	public BufferedOutputStream getOutput() {
		if (null == output) {
			try {
				output = new BufferedOutputStream(getConnection().getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return output;
	}
	
	@JsonIgnore
	public BufferedInputStream getInput() {
		if (null == input) {
			try {
				input = new BufferedInputStream(getConnection().getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return input;
	}
}
