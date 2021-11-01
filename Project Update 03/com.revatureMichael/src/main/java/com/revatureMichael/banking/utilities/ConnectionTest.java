package com.revatureMichael.banking.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Tests my Connection Class
 * @author Michael Ord
 *
 */
public class ConnectionTest {

	public static void main(String[] args) 
	{
//		try (Connection conn = ConnectionUtility.getConnection();)
//		{
//			ConnectionUtility.getConnection();
//			System.out.println("Connection Successful");
//		} 
//		catch (SQLException e) 
//		{
//			// TODO Auto-generated catch block
//			System.out.println("Connection Unsuccessful");
//			e.printStackTrace();
//		}

		try (Connection conn = ConnectionUtility.getConnection_Props();)
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
		catch (IOException e)
		{
			System.out.println("An IO error has occured!");
			e.printStackTrace();
		}
	}

}
