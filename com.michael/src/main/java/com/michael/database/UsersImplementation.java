package com.michael.database;

import java.sql.Connection;
//import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.michael.logging.LogSimulator;
import com.michael.models.Users;
//import com.michael.utilities.ConnectionUtility;
import com.michael.utilities.ConnectionUtility;

public class UsersImplementation implements UsersInterface
{

	public Users selectUserID(Integer id) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users us = null;
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "SELECT * FROM users WHERE userid = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
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
			LogSimulator.getLogger().trace("User " + id + " selected.");
			return us;
		}
		catch (SQLException e)
		{
			LogSimulator.getLogger().trace("SQL Error encountered in SelectUserID");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean createNewUser(Integer id, String firstname, String lastname, String email) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "INSERT INTO users(userid, firstname, lastname, email) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setString(4, email);
			
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			LogSimulator.getLogger().trace("SQL Error encountered in createnewuser");
			e.printStackTrace();
			return false;
		}
		LogSimulator.getLogger().trace("User created: " + firstname);
		return true;
	}

	/**
	 * Returns the highest integer id from userid plus one.
	 */
	public int FindMaxInt()
	{
		int output = 0;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			PreparedStatement ps = null;
			ResultSet rs = null;
			String query = "SELECT MAX(userid)\r\n"
						 + "FROM users;";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next())
			{
				output = rs.getInt(1);
			}
		} catch (SQLException e) 
		{
			LogSimulator.getLogger().trace("SQL Error encountered in FindMaxInt(User)");
			e.printStackTrace();
			return -1;
		}
		LogSimulator.getLogger().trace("Returning " + "1");
		return output+1;
	}

	@Override
	public boolean checkAllEmails(String email) 
	{
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			Statement stat = null;
			ResultSet rs = null;
			
			List<String> elist = new ArrayList<String>();  
			String query = "SELECT email\r\n"
						 + "FROM users\r\n";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(query);
			while(rs.next())
			{
				String output = rs.getString(1);
				elist.add(output);
			}
			
			for(String s:elist)
			{
				if(s.equals(email))
				{
					LogSimulator.getLogger().trace(email + " is not unique");
					System.out.println("Error: That email is already in use.");
					return false;
				}
			}
		} 
		catch (SQLException e) 
		{
			LogSimulator.getLogger().trace("SQL Error encountered in checkAllEmails");
			e.printStackTrace();
			return false;
		}
		LogSimulator.getLogger().trace("Email is unique");
		return true;
	}

	@Override
	public boolean deleteUser(Integer id) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "DELETE FROM users WHERE userid = ?;";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) 
		{
			LogSimulator.getLogger().trace("SQL Error encountered in deleteUser");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LogSimulator.getLogger().trace("User Deleted.");
		return false;
	}

	@Override
	public boolean ChangeEmail(String email, Users us) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "UPDATE users SET email = REPLACE (email, ?, ?);";
			ps = conn.prepareStatement(query);
			ps.setString(1, us.getEmail());
			ps.setString(2, email);
			ps.executeUpdate();
			
		} catch (SQLException e) 
		{
			LogSimulator.getLogger().trace("SQL Error encountered in Change Email");
			e.printStackTrace();
		}
		LogSimulator.getLogger().trace("Email Changed");
		return false;
	}

	@Override
	public String GetFullName(Integer id) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuilder output = new StringBuilder();
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "SELECT firstname, lastname FROM users WHERE userid = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				output.append(rs.getString(1));
				output.append(" ");
				output.append(rs.getString(2));
				//acc.setBalance(rs.getInt(2));
				//acc.setApproved(rs.getBoolean(3));
			}
			String fullname = output.toString();
			LogSimulator.getLogger().trace("Returning full name: " + fullname);
			return fullname;
		}
		catch (SQLException e)
		{
			LogSimulator.getLogger().trace("SQL Error encountered in GetFullName");
			e.printStackTrace();
		}
		return null;
	}
}
