package com.michael.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.michael.logging.LogSimulator;
import com.michael.models.Account;
import com.michael.models.Users;
import com.michael.utilities.ConnectionUtility;

/**
 * Database Methods relating to Accounts
 * @author Michael Ord
 *
 */
public class AccountImplementation implements AccountInterface
{

	/**
	 * Selects an Account by its ID.
	 */
	public Account selectAccountID(Integer id) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account acc = null;
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "SELECT * FROM account WHERE accountid = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				acc = new Account();
				acc.setAccountid(rs.getInt(1));
				acc.setFk_users(rs.getInt(2));
				acc.setUsername(rs.getString(3));
				acc.setPasscode(rs.getString(4));
				acc.setActivated(rs.getBoolean(5));
				acc.setReputation(rs.getInt(6));
			}
			LogSimulator.getLogger().trace("Successfully returned" + acc);
			return acc;
		}
		catch (SQLException e)
		{
			LogSimulator.getLogger().trace("SQL Error encountered in selectAccountID");
			e.printStackTrace();
		}
		catch (NullPointerException e)
		{
			LogSimulator.getLogger().trace("Null Pointer encountered in selectAccountID");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Compares a given username to see if there is a similar one in the table.
	 */
	public boolean checkAllUsernames(String username) 
	{
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			Statement stat = null;
			ResultSet rs = null;
			
			List<String> ulist = new ArrayList<String>();  
			String query = "SELECT username\r\n"
						 + "FROM account\r\n";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(query);
			while(rs.next())
			{
				String output = rs.getString(1);
				ulist.add(output);
			}
			
			for(String s:ulist)
			{
				if(s.equals(username))
				{
					LogSimulator.getLogger().trace("Duplicate Username Found");
					System.out.println("Error: That username is already in use.");
					return false;
				}
			}
		} 
		catch (SQLException e) 
		{
			LogSimulator.getLogger().trace("SQL Error encountered in checkAllUsernames");
			e.printStackTrace();
			return false;
		}
		catch (NullPointerException e)
		{
			LogSimulator.getLogger().trace("Null Pointer encountered in checkAllUsernames");
			e.printStackTrace();
		}
		LogSimulator.getLogger().trace("No Duplicate Usernames found for" + username);
		return true;
	}

	/**
	 * Creates a new account given an id, foreign user id, username, and password.
	 */
	public boolean createNewAccount(Integer id, Integer fk_user, String username, String passcode) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "INSERT INTO account(accountid, fk_users, username, passcode, activated, reputation) VALUES(?,?,?,?,FALSE,0)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, fk_user);
			ps.setString(3, username);
			ps.setString(4, passcode);
			
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			LogSimulator.getLogger().trace("Insert Account Failed");
			e.printStackTrace();
			return false;
		}
		catch (NullPointerException e)
		{
			LogSimulator.getLogger().trace("Null Pointer encountered in checkAllUsernames");
			e.printStackTrace();
		}
		LogSimulator.getLogger().trace("Account Successfully Created with user-input values: " + id + " " + fk_user + " " + username);
		return true;
	}

	/**
	 * Returns the maximum account_id plus one. Used for generating primary keys.
	 */
	public int FindMaxInt() 
	{
		int output = 0;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			PreparedStatement ps = null;
			ResultSet rs = null;
			String query = "SELECT MAX(accountid)\r\n"
						 + "FROM account;";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next())
			{
				output = rs.getInt(1);
			}
			
		} catch (SQLException e) 
		{
			LogSimulator.getLogger().trace("SQL Error encountered in FindMaxInt(Account)");
			e.printStackTrace();
			return 0;
		}
		LogSimulator.getLogger().trace("FindMaxInt(Account) returns " + output + " +1");
		return output+1;
	}


	/**
	 * Returns an account with matching given username and password
	 */
	public Account StandardLogin(String username, String password) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account acc = null;
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "SELECT * FROM account WHERE username = ? AND passcode = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				acc = new Account();
				acc.setAccountid(rs.getInt(1));
				acc.setFk_users(rs.getInt(2));
				acc.setUsername(rs.getString(3));
				acc.setPasscode(rs.getString(4));
				acc.setActivated(rs.getBoolean(5));
				acc.setReputation(rs.getInt(6));
			}
		}
		catch (SQLException e)
		{
			LogSimulator.getLogger().trace("SQL Error encountered in StandardLogin");
			e.printStackTrace();
			return null;
		}
		catch (NullPointerException e)
		{
			LogSimulator.getLogger().trace("NullPointer encountered in checkAllUsernames");
			e.printStackTrace();
		}
		LogSimulator.getLogger().trace("Found Login Account under " + username);
		return acc;
	}

	/**
	 * Deletes an account given the account_id
	 */
	public boolean DeleteAccount(Integer id) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "DELETE FROM account WHERE accountid = ?;";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) 
		{
			LogSimulator.getLogger().trace("SQL Error encountered in DeleteAccount");
			e.printStackTrace();
		}
		catch (NullPointerException e)
		{
			LogSimulator.getLogger().trace("NullPointer encountered in DeleteAccount");
			e.printStackTrace();
		}
		LogSimulator.getLogger().trace("Account " + id + " deleted.");
		return false;
	}

	/**
	 * Changes the Username of the given account and username.
	 */
	public boolean ChangeUsername(String username, Account acc) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "UPDATE account SET username = REPLACE (username, ?, ?);";
			ps = conn.prepareStatement(query);
			ps.setString(1, acc.getUsername());
			ps.setString(2, username);
			ps.executeUpdate();
			
		} catch (SQLException e) 
		{
			LogSimulator.getLogger().trace("SQL Error encountered in ChangeUsername");
			e.printStackTrace();
		}
		catch (NullPointerException e)
		{
			LogSimulator.getLogger().trace("NullPointer encountered in ChangeUsername");
			e.printStackTrace();
		}
		LogSimulator.getLogger().trace("Username Changed");
		return false;
	}

	/**
	 * Returns everything from the Account table into an ArrayList.
	 */
	public List<Account> SelectAll() 
	{
		List<Account> ls = new ArrayList<Account>();
		Account acc = null;
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "SELECT * FROM account";
			Statement stat = null;
			ResultSet rs = null;
			
			stat = conn.createStatement();
			rs = stat.executeQuery(query);
			while(rs.next())
			{
				acc = new Account();
				acc.setAccountid(rs.getInt(1));
				acc.setFk_users(rs.getInt(2));
				acc.setUsername(rs.getString(3));
				acc.setPasscode(rs.getString(4));
				acc.setActivated(rs.getBoolean(5));
				acc.setReputation(rs.getInt(6));
				ls.add(acc);
			}
			ls.size();
			LogSimulator.getLogger().trace("Selected All from Accounting Table");
			return ls;
		}
		catch (SQLException e)
		{
			LogSimulator.getLogger().trace("SQL Error encountered in SelectAll (Account)");
			e.printStackTrace();
			return null;
		}
		catch (NullPointerException e)
		{
			LogSimulator.getLogger().trace("Null Pointer encountered in SelectAll (Account)");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Returns a list of all unapproved account ids.
	 */
	public List<Integer> SelectAllUnapproved() 
	{
		List<Integer> ls = new ArrayList<Integer>();
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "SELECT accountid FROM account WHERE activated = FALSE";
			Statement stat = null;
			ResultSet rs = null;
			
			stat = conn.createStatement();
			rs = stat.executeQuery(query);
			while(rs.next())
			{
				ls.add(rs.getInt(1));
			}
			LogSimulator.getLogger().trace("Unapproved Accounts Obtained");
			return ls;
		}
		catch (SQLException e)
		{
			LogSimulator.getLogger().trace("SQL Error encountered in SelectAllUnapproved");
			e.printStackTrace();
			return null;
		}
		catch (NullPointerException e)
		{
			LogSimulator.getLogger().trace("NullPointer encountered in SelectAllUnapproved");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Updates an account's approval to the database.
	 */
	public boolean ApproveAccount(Integer id) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "UPDATE account SET activated = TRUE WHERE accountid = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) 
		{
			LogSimulator.getLogger().trace("SQL Error encountered in ApproveAccount");
			e.printStackTrace();
		}
		LogSimulator.getLogger().trace(id + " approved.");
		return false;
	}

}
