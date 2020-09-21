package bot.notyet;

import java.util.Date;

class Message {
    public String origin;
    public String nickname;
    public String command;
    public String target;
    public String message;
    private Date timestamp;
    
    public Message() {
    	this.timestamp = new Date(System.currentTimeMillis());
    }
    
    public Message (String origin, String nickname, String command, String target, String message) {
    	this.timestamp = new Date(System.currentTimeMillis());
    	this.origin = origin;
    	this.nickname = nickname;
    	this.command = command;
    	this.target = target;
    	this.message = message;
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
		return this.timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((command == null) ? 0 : command.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (command == null) {
			if (other.command != null)
				return false;
		} else if (!command.equals(other.command))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [origin=" + origin + ", nickname=" + nickname + ", command=" + command + ", target=" + target
				+ ", message=" + message + ", timestamp=" + timestamp + "]";
	}	
}
