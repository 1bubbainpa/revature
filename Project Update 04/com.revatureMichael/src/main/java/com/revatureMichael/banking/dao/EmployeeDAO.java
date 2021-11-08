package com.revatureMichael.banking.dao;

import java.util.List;

import com.revatureMichael.banking.models.*;
/*
 * DAO interface defines the methods which perform basic operations on our
 * database based on a particular table and model class
 */
public interface EmployeeDAO 
{
	public boolean insertIntoEmployees(Employee emp);
	public Employee selectEmployeeById(Integer id);
	public List<Employee> selectAllEmployees();
	public boolean updateEmployee(Employee emp);
	public boolean deleteEmployee(Integer id);
}
