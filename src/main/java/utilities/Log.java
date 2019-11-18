package utilities;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	private static Logger logger = Logger.getLogger(Log.class);

	public static Logger getLogger() throws FileNotFoundException {
		
		PropertyConfigurator.configure(PropertyFile.getProperty("log4j"));
		if (logger == null) {
			logger = org.apache.log4j.LogManager.getRootLogger();
		}
		return logger;
	}
	private Log() {

	}



	public static void inDebugAdd(String message) {
		logger.debug(message);
	}

	public static void inInfoAdd(String message) {
		logger.info(message);
	}

	public static void inErrorAdd(String message) {
		logger.error(message);
	}

	public static void inWarnAdd(String message) {
		logger.warn(message);
	}

	public static void inFatalAdd(String message) {
		logger.fatal(message);
	}
}
