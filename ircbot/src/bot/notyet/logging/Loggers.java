package bot.notyet.logging;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

public class Loggers {
	private static final Logger commandLogger = LogManager.getLogger("command");
	private static final Logger parsingLogger = LogManager.getLogger("parse-errors");
	private static final Logger debugLogger = LogManager.getLogger("debug");
	private static final ConfigurationBuilder<BuiltConfiguration> builder
	 = ConfigurationBuilderFactory.newConfigurationBuilder();

	
	public static Logger getCommandlogger() {
		return commandLogger;
	}
	public static Logger getParsinglogger() {
		return parsingLogger;
	}
	public static Logger getDebuglogger() {
		return debugLogger;
	}
	
	public static Logger getChannelLogger(String botName, String serverName, String channel) {
		AppenderComponentBuilder appender = builder.newAppender(botName + "." + channel + "." + serverName, "RandomAccessFileAppender");
		
		builder.add(appender);
		
		appender.addAttribute("fileName", File.separator +  appender.getName());
		
		return LogManager.getLogger(channel);
	}
}
