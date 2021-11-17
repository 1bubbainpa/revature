package com.michael.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.michael.models.Users;
import com.michael.utilities.ConnectionUtility;

public class Setup 
{
	public static void main(String args[])
	{		
		CreateTables();
		SeeData();
	}
	
	public static void CreateTables()
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users us = null;
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "CREATE TABLE IF NOT EXISTS users (\r\n"
				+ "	userid SERIAL PRIMARY KEY NOT NULL,\r\n"
				+ "	firstname VARCHAR NOT NULL,\r\n"
				+ "	lastname VARCHAR NOT NULL,\r\n"
				+ "	email VARCHAR UNIQUE NOT NULL\r\n"
				+ ");";
		ps = conn.prepareStatement(query);
		ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void SeeData()
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users us = null;
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "SELECT * FROM users WHERE userid = 1";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				us = new Users();
				us.setUserid(rs.getInt(1));
				us.setFirstname(rs.getString(2));
				us.setLastname(rs.getString(3));
				us.setEmail(rs.getString(4));
				//acc.setBalance(rs.getInt(2));
				//acc.setApproved(rs.getBoolean(3));
			}
			System.out.println(us.toString());
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
