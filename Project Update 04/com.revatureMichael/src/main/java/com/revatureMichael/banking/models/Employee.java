package com.revatureMichael.banking.models;

public class Employee {
	private int emp_id;
	private int account_id;
	
	//No args constructor
	public Employee() 
	{
		super();
	}

	//Optional constructor for all field values
	public Employee(int emp_id, int account_id) 
	{
		super();
		this.emp_id = emp_id;
		this.account_id = account_id;
	}

	//Getters and Setters
	public int getEmp_id() 
	{
		return emp_id;
	}

	public void setEmp_id(int emp_id) 
	{
		this.emp_id = emp_id;
	}

	public int getAccount_id() 
	{
		return account_id;
	}

	public void setAccount_id(int account_id) 
	{
		this.account_id = account_id;
	}

	@Override
	public String toString() 
	{
		return "Employee [emp_id=" + emp_id + ", account_id=" + account_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_id;
		result = prime * result + emp_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Employee other = (Employee) obj;
		if (account_id != other.account_id)
			return false;
		
		if (emp_id != other.emp_id)
			return false;
		return true;
	}
	
	
}
