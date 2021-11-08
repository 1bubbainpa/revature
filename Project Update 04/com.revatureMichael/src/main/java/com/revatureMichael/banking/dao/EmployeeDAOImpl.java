package com.revatureMichael.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revatureMichael.banking.models.Employee;
import com.revatureMichael.banking.utilities.ConnectionUtility;

/*
 * Implementation classes for the DAO interface provide a way
 * to detail different implementation details for methods, for example,
 * communicating with different databases or SQL dialects
 * 
 * !!!THIS CLASS IS A WIP!!!
 */
public class EmployeeDAOImpl implements EmployeeDAO
{

	@Override
	public boolean insertIntoEmployees(Employee emp) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "INSERT INTO myschema.Employee VALUES(?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, emp.getEmp_id());
			ps.setInt(2, emp.getAccount_id());
			
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
	public Employee selectEmployeeById(Integer id) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			/*
			 * '?' represents a marker for a parameter within our sql query.
			 */
			String query = "SELECT * FROM myschema.Employee WHERE EmployeeID=?";
			
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
				emp = new Employee();
				emp.setEmp_id(rs.getInt(1));
				emp.setAccount_id(rs.getInt(2));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return emp;
		
	}

	@Override
	public List<Employee> selectAllEmployees() 
	{
		Statement stat = null;
		ResultSet rs = null;
		List<Employee> eList = null;
		
		try (Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "SELECT * FROM myschema.Employee";
			stat = conn.createStatement();
			rs = stat.executeQuery(query);
			eList = new ArrayList<Employee>();
			
			while(rs.next())
			{
				Employee emp = new Employee();
				emp = new Employee();
				emp.setEmp_id(rs.getInt(1));
				emp.setAccount_id(rs.getInt(2));
				
				eList.add(emp);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateEmployee(Employee emp) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(Integer id) 
	{
		return false;
	}
	
}
