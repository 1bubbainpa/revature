package com.michael.utilities;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest 
{
	public static void main(String args[])
	{
		try (Connection conn = ConnectionUtility.getConnection();)
		{
			ConnectionUtility.getConnection();
			System.out.println("[Properties File] Connection Successful");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("A SQL error has occured!");
			e.printStackTrace();
		}
	}
}
