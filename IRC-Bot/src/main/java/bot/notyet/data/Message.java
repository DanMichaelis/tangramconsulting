package bot.notyet.data;

import java.util.Date;

import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Message {
	private String origin;
	private String nickname;
	private String command;
	private String target;
	private String message;
	private Date timestamp;

	public Message(String origin, String nickname, String command, String target, String message, Date timestamp) {
		this.origin = origin;
		this.nickname = nickname;
		this.command = command;
		this.target = target;
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getOrigin() {
		return origin;
	}

	public Message setOrigin(String origin) {
		this.origin = origin;
		return this;
	}

	public String getNickname() {
		return nickname;
	}

	public Message setNickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	public String getCommand() {
		return command;
	}

	public Message setCommand(String command) {
		this.command = command;
		return this;
	}

	public String getTarget() {
		return target;
	}

	public Message setTarget(String target) {
		this.target = target;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Message setMessage(String message) {
		this.message = message;
		return this;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public Message setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
		return this;
	}
}
