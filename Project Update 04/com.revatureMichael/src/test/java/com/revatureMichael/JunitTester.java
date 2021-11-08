package com.revatureMichael;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

import com.revatureMichael.banking.app.BankDatabaser;
import com.revatureMichael.banking.models.Customer;
import com.revatureMichael.banking.utilities.ConnectionUtility;

public class JunitTester {

	//Test proper size for something like a zipcode
	@Test
	public void checkProperSize() 
	{
		int expectedSize = 5;
		String zipcode = "19678";
		assertEquals(expectedSize, zipcode.length());
	}
	
	//Test connection to database is successful
	@Test
	public void checkDatabaseConnection() 
	{
		boolean connected;
		try (Connection conn = ConnectionUtility.getConnection_Props();)
		{
			ConnectionUtility.getConnection();
			connected = true;
		} 
		catch (SQLException e) 
		{
			connected = false;
		}
		catch (IOException e)
		{
			connected = false;
		}
		assertTrue(connected);
	}
	
	//Test two objects of the same BankDatabaser are different when given unique constructors
	@Test
	public void checkDifferentConstructors()
	{
		BankDatabaser a = new BankDatabaser('C');
		BankDatabaser b = new BankDatabaser("first", "last", "city", "state", "11111", "email");
		assertNotEquals(a, b);
	}
}
