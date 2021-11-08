package com.revatureMichael.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revatureMichael.banking.models.Account;
import com.revatureMichael.banking.utilities.ConnectionUtility;

public class AccountDAOImpl implements AccountDAO
{
	private static Logger logger = LogManager.getLogger();
	@Override
	public boolean insertIntoAccount(Account act) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "INSERT INTO myschema.Account VALUES(?,?,?)";
			ps = conn.prepareStatement(query);
			//ps.setInt(1, act.getAccountid());
			//ps.setInt(2, act.getBalance());
			//ps.setBoolean(3, act.isApproved());
			
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	@Override
	public Account selectAccountById(Integer id) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account acc = null;
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			/*
			 * '?' represents a marker for a parameter within our sql query.
			 */
			String query = "SELECT * FROM myschema.Account WHERE AccountID=?";
			
			/*
			 * prepareStatement method will convert a string to a PreparedStatement object
			 */
			ps = conn.prepareStatement(query);
			
			/**
			 * The preparedStatement object supplies methods to set values for the marker indexes
			 * within the String query that was created above
			 */
			ps.setInt(1, id);
			/**
			 * 
			 */
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				acc = new Account();
				//acc.setAccountid(rs.getInt(1));
				//acc.setBalance(rs.getInt(2));
				//acc.setApproved(rs.getBoolean(3));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			logger.warn("Error under AccountDAOImpl selectAccountById");
		}
		return acc;
		
	}

	@Override
	public List<Account> selectAllAccounts() 
	{
		return null; //TBI
	}

	@Override
	public boolean updateAccount(Account acc) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "UPDATE myschema.Account SET "
					+ "Balance=?,"
					+ "Approved=?"
					+ "WHERE AccountID=?";
			ps = conn.prepareStatement(query);
			
			//ps.setInt(1, acc.getBalance());
			//ps.setBoolean(2, acc.isApproved());
			//ps.setInt(3, acc.getAccountid());
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			logger.warn("Error under AccountDAOImpl updateAccount");
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteAccount(Account acc) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "DELETE FROM myschema.Account WHERE AccountID=?;";
			ps = conn.prepareStatement(query);
			//ps.setInt(1, acc.getAccountid());
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			logger.warn("Error under AccountDAOImpl deleteAccount");
			return false;
		}
		return true;
		
	}

}
