package bot.notyet.config;

import java.util.List;

import bot.notyet.server.Server;

public class BotServerDefaults {
	private String botName;
	private List<Server> defaultServers;

	public String getBotName() {
		return botName;
	}

	public List<Server> getDefaultServers() {
		return defaultServers;
	}

	public void setBotName(String botName) {
		this.botName = botName;
	}

	public void setDefaultServers(List<Server> defaultServers) {
		this.defaultServers = defaultServers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((botName == null) ? 0 : botName.hashCode());
		result = prime * result + ((defaultServers == null) ? 0 : defaultServers.hashCode());
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
		BotServerDefaults other = (BotServerDefaults) obj;
		if (botName == null) {
			if (other.botName != null)
				return false;
		} else if (!botName.equals(other.botName))
			return false;
		if (defaultServers == null) {
			if (other.defaultServers != null)
				return false;
		} else if (!defaultServers.equals(other.defaultServers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("BotServerDefaults [botname = ");
		sb.append(botName);
		sb.append(System.lineSeparator());
		sb.append("[servers = {");
		sb.append(System.lineSeparator());
		for (Server s : defaultServers) {
			sb.append("   " + s.getServerName() + System.lineSeparator());
		}
		sb.append("}");		
		return sb.toString();
	}

}
