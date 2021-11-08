package com.revatureMichael.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revatureMichael.banking.models.Account;
import com.revatureMichael.banking.models.Customer;
import com.revatureMichael.banking.utilities.ConnectionUtility;


public class CustomerDAOImpl implements CustomerDAO
{
	private static Logger logger = LogManager.getLogger();
	
	@Override
	public boolean insertIntoCustomer(Customer cus) 
	{
		return false;
	}

	@Override
	public Customer selectCustomerById(Integer id) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer cus = null;
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "SELECT * FROM myschema.Account WHERE customerid=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			/**
			 * 
			 */
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				cus = new Customer();
				cus = new Customer();
				cus.setCustomerid(rs.getInt(1));
				cus.setFirstname(rs.getString(2));
				cus.setLastname(rs.getString(3));
				cus.setCity(rs.getString(4));
				cus.setState(rs.getString(5));
				cus.setZipcode(rs.getInt(6));
				cus.setEmail(rs.getString(7));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			logger.warn("Error under CustomerDAOImpl selectCustomerById");
		}
		return cus;
	}

	@Override
	public List<Customer> selectAllCustomers() 
	{
		return null;
	}

	@Override
	public boolean updateCustomer(Customer cus) 
	{
		return false;
	}

	@Override
	public boolean deleteCustomer(Customer cus) 
	{
		return false;
	}

	@Override
	public Customer selectCustomerByCredentials(String fname, String lname) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer cus = null;
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			/*
			 * '?' represents a marker for a parameter within our sql query.
			 */
			String query = "SELECT * FROM myschema.Customer WHERE (firstname = ? AND lastname = ?);";
			
			/*
			 * prepareStatement method will convert a string to a PreparedStatement object
			 */
			ps = conn.prepareStatement(query);
			
			/**
			 * The preparedStatement object supplies methods to set values for the marker indexes
			 * within the String query that was created above
			 */
			ps.setString(1, fname);
			ps.setString(2, lname);
			/**
			 * 
			 */
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				cus = new Customer();
				cus.setCustomerid(rs.getInt(1));
				cus.setFirstname(rs.getString(2));
				cus.setLastname(rs.getString(3));
				cus.setCity(rs.getString(4));
				cus.setState(rs.getString(5));
				cus.setZipcode(rs.getInt(6));
				cus.setEmail(rs.getString(7));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			logger.warn("Error under CustomerDAOImpl selectCustomerByCredentials");
		}
		return cus;
	}
	
}
