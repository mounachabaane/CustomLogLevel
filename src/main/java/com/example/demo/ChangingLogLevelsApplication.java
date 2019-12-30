package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Level;

@SpringBootApplication
public class ChangingLogLevelsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChangingLogLevelsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ChangingLogLevelsApplication.class, args);

		LOGGER.trace("Hello World!");

		String name = "Alice";
		LOGGER.debug("Hi, {}", name);
		LOGGER.info("Welcome to the example of Logback.");
		LOGGER.warn("Dummy warning message.");
		LOGGER.error("Dummy error message.");

		String level = null;
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-I")  || args[i].equals("-D")|| args[i].equals("-T")  )

			{
				level = args[i];
				break;
			}

		}

		if (level != null) {
			System.out.println("log level : "+level);
			setLevelLog(LOGGER, level);
		} else {
			((ch.qos.logback.classic.Logger) LOGGER).setLevel(Level.OFF);
		}

		LOGGER.trace("Hello World!");
		
		LOGGER.debug("Hi, {}", name);
		LOGGER.info("Welcome to the custom level log example.");
		LOGGER.warn("Dummy warning message.");
		LOGGER.error("Dummy error message.");

	}

	/**
	 * this method allows to set the level log -I :INFO, -D : DEBUG, -T : TRACE.
	 * 
	 * @author mouna.chabaane
	 * @param logger
	 * @param level
	 */
	public static void setLevelLog(Logger logger, String level) {

		if (level.contains("")) {

			((ch.qos.logback.classic.Logger) logger).setLevel(Level.INFO);

		}

		if (level.contains("-D")) {

			((ch.qos.logback.classic.Logger) logger).setLevel(Level.DEBUG);

		}

		if (level.contains("-T")) {

			((ch.qos.logback.classic.Logger) logger).setLevel(Level.TRACE);
		}

	}

}
