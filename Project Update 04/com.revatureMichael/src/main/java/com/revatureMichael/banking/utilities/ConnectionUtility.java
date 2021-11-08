package com.revatureMichael.banking.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Creates an Connection which establishes a link to my database
 * @author Michael Ord
 *
 */
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
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "customers";
		String passcode = "password";
		return DriverManager.getConnection(url, username, passcode);
	}
	
	public static Connection getConnection_Props() throws SQLException, IOException
	{
		FileInputStream stream = new FileInputStream("db_resources/db-props.properties");
		Properties props = new Properties();
		props.load(stream);
		String url = props.getProperty("CONN_URL");
		String user = props.getProperty("CONN_USER");
		String pass = props.getProperty("CONN_PASS");
		return DriverManager.getConnection(url, user, pass);
	}
}
