package com.michael.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogSimulator
{
	private static Logger logger = LogManager.getLogger();

	public static void main(String[] args) 
	{
		logMethod();
	}
	
	public static Logger getLogger()
	{
		return logger;
	}

	public static void logMethod()
	{
		//logger.trace("Trace");
		//logger.trace("Debug");
		//logger.trace("Info");
		//logger.trace("Warn");
		//logger.trace("Error");
		//logger.trace("Fatal");
	}
}
