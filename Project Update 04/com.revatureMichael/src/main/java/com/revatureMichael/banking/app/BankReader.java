package com.revatureMichael.banking.app;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankReader 
{
	private static Logger logger = LogManager.getLogger();
	public int ReadInt(Scanner scan)
	{
		int x = 0;
		try
		{
			x = scan.nextInt();
		}
		catch(Exception e)
		{
			scan.next();
			logger.warn("Bad Input Detected under *BankReader ReadInt()*");
			x = 0;
		}
		return x;
	}
	
	public String ReadString(Scanner scan)
	{
		try
		{
			String x = scan.next();
			return x;
		}
		catch (Exception e)
		{
			scan.next();
		}
		return null;
	}
}
