package com.michael.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.michael.logging.LogSimulator;
import com.michael.models.Account;
import com.michael.models.Admin;
import com.michael.utilities.ConnectionUtility;

/**
 * Database Methods relating to Admins
 * @author Michael Ord
 *
 */
public class AdminImplementation implements AdminInterface 
{

	/**
	 * Selects an Admin by its ID.
	 */
	public Admin selectAdminID(Integer id) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin ad = null;
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "SELECT * FROM admin WHERE adminid = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next())
			{	
				ad = new Admin();
				ad.setAdminid(rs.getInt(1));
				ad.setFk_account(rs.getInt(2));
				ad.setUsername(rs.getString(3));
				ad.setPassword(rs.getString(4));
			}
			LogSimulator.getLogger().trace("Admin found.");
			return ad;
		}
		catch (SQLException e)
		{
			LogSimulator.getLogger().trace("SQL Error encountered in selectAdminID");
			e.printStackTrace();
		}
		catch (NullPointerException e)
		{
			LogSimulator.getLogger().trace("NullPointer encountered in checkAllUsernames");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Creates a new admin given ID, Username, and Password.
	 * Not used in the program, is used manually instead when needed.
	 */
	public boolean createNewAdmin(Integer id, String username, String passcode)
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "INSERT INTO admin(adminid, fk_account, username, passcode) VALUES(?,1,?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, username);
			ps.setString(3, passcode);
			
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Checks the login credentials for a potential admin login
	 * Compares username and password to all admin values.
	 */
	public Admin adminLogin(String user, String pass) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin ad = null;
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "SELECT * FROM admin WHERE username = ? AND passcode = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				ad = new Admin();
				ad.setAdminid(rs.getInt(1));
				ad.setFk_account(rs.getInt(2));
				ad.setUsername(rs.getString(3));
				ad.setPassword(rs.getString(4));
			}
		}
		catch (SQLException e)
		{
			LogSimulator.getLogger().trace("SQL Error encountered in adminLogin");
			e.printStackTrace();
			return null;
		}
		LogSimulator.getLogger().trace("Admin login acknowledged");
		return ad;
	}
}
