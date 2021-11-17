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
import com.michael.models.Classes;
import com.michael.utilities.ConnectionUtility;

public class ClassImplementation implements ClassesInterface {

	@Override
	public Classes selectClassID(Integer id) 
	{
		return null;
	}

	@Override
	public List<Classes> selectAll() 
	{
		List<Classes> ls = new ArrayList<Classes>();
		Classes cl = null;
		
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "SELECT * FROM classes";
			Statement stat = null;
			ResultSet rs = null;
			
			stat = conn.createStatement();
			rs = stat.executeQuery(query);
			while(rs.next())
			{
				cl = new Classes();
				cl.setClassid(rs.getInt(1));
				cl.setFk_account(rs.getInt(2));
				cl.setClassname(rs.getString(3));
				cl.setClassdate(rs.getDate(4));
				cl.setTimestart(rs.getTime(5));
				cl.setCategory(rs.getString(6));
				cl.setDescription(rs.getString(7));
				cl.setNotes(rs.getString(8));
				ls.add(cl);
			}
			LogSimulator.getLogger().trace("Returning All Classes...");
			return ls;
		}
		catch (SQLException e)
		{
			LogSimulator.getLogger().trace("SQL Error encountered in SelectAll(Classes)");
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public int findMaxInt() 
	{
			int output = 0;
			try(Connection conn = ConnectionUtility.getConnection();)
			{
				PreparedStatement ps = null;
				ResultSet rs = null;
				String query = "SELECT MAX(classid)\r\n"
							 + "FROM classes;";
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				while(rs.next())
				{
					output = rs.getInt(1);
				}
			} catch (SQLException e) 
			{
				LogSimulator.getLogger().trace("SQL Error encountered in findMaxInt(Classes)");
				e.printStackTrace();
				return -1;
			}
			LogSimulator.getLogger().trace("Returning " + output + " 1");
			return output+1;
	}

	@Override
	public boolean createClass(Integer id, Integer fk_account, String classname, String classdate, String timestart,
			String category, String description, String notes) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection();)
		{
			String query = "INSERT INTO classes(classid, fk_account, classname, classdate, timestart, category, description, notes) VALUES(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, fk_account);
			ps.setString(3, classname);
			ps.setString(4, classdate);
			ps.setString(5, timestart);
			ps.setString(6, category);
			ps.setString(7, description);
			ps.setString(8, notes);
			
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			LogSimulator.getLogger().trace("SQL Error encountered in CreateClass");
			e.printStackTrace();
			return false;
		}
		LogSimulator.getLogger().trace("A new class has been created with classid " + id);
		return true;
	}
}

