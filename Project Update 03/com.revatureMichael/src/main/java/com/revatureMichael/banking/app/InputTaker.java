package com.revatureMichael.banking.app;

public class InputTaker 
{
	StringBuilder username;
	StringBuilder password;
	public InputTaker(StringBuilder user, StringBuilder pass) 
	{
		username = user;
		password = pass;
	}

	public boolean validateCredentials()
	{
		//Implementation in the future to confirm user and pass from database
		return true;
	}

	public boolean deposit(long deposit) 
	{
		//Add Funds, if successful, return true
		return true;
	}
	
	public boolean withdraw(long withdraw) 
	{
		//Return Funds, if successful, return true
		return true;
	}
}
