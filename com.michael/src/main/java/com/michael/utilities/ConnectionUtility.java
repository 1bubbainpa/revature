package com.michael.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility 
{
	public static Connection getConnection() throws SQLException
	{
		//Takes a string value for:
		//Database URL
		//Database Username
		//Database Password
		//User and Pass based on user created with DDL and DCL
		//jdbc:postgresql://host:port/database
		String url = "jdbc:postgresql://database-18.clwpqhrjzrww.us-east-1.rds.amazonaws.com:5432/postgres";
		String username = "postgresMe";
		String passcode = "password";
		return DriverManager.getConnection(url, username, passcode);
	}
}
