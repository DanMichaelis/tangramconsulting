package bot.notyet;

public class Bot extends IRCMessageLoop {

	Bot(String serverName, int port) {
		super(serverName, port);
	}

	public static void main(String[] args) {
		Bot bot = new Bot("irc.xxxchatters.com", 6667);

		bot.nick("TestBot");
		bot.user("TestBot", "null", "null", "Test Bot Name");
		bot.join("#EdgeHerToTears");
		bot.run();
	}

	@Override
	void raw(Message msg) {
		// when someone sends "hello" we'll respond with "Hiya!"
		if (msg.getMessage().equals("hello")) {
			// is this a channel the message was sent to?
			if (msg.target.startsWith("#")) {
				privmsg(msg.target, "Hiya!");
			} else {
				// no it's a private message. let's send this message back to the nickname.
				privmsg(msg.nickname, "Hiya");
			}
			// this is weird, yep, but this is how irc is.
			// the target of a message is the person or group (channel) receiving the
			// message so
			// if the bot is receiving the message the target would be
			// the bot's nickname.
		}

		if (msg.getMessage().equals("!news")) {
			privmsg(msg.target, "In keeping with Channel 40's policy of bringing you the latest in "
					+ "blood and guts and in living color, you are going to see another first - an attempted suicide.");
		}
		
		if (msg.getMessage().toLowerCase().equals("!forcequit")) {
			quit("Forced to quit by " + msg.getNickname());
		}

	}
}
