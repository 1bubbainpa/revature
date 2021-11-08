package com.revatureMichael.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogSimulator 
{
	private static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args)
	{
		logMethod();
	}
	
	public static void logMethod()
	{
		logger.trace("TRACE LOG!");
		logger.debug("DEBUG LOG");
		logger.info("INFO LOG");
		logger.warn("WARN LOG");
		logger.error("ERROR LOG");
		logger.fatal("FATAL LOG");
	}
}
