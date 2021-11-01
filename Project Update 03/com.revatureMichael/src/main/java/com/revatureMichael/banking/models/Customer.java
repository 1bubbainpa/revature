package com.revatureMichael.banking.models;

import java.util.Objects;

public class Customer 
{
	private int customerid;
	private int accountid;
	private String username;
	private String passcode;
	
	public Customer() 
	{
		super();
	}

	public Customer(int customerid, int accountid, String username, String passcode) 
	{
		super();
		this.customerid = customerid;
		this.accountid = accountid;
		this.username = username;
		this.passcode = passcode;
	}

	public int getCustomerid() 
	{
		return customerid;
	}

	public void setCustomerid(int customerid) 
	{
		this.customerid = customerid;
	}

	public int getAccountid() 
	{
		return accountid;
	}

	public void setAccountid(int accountid) 
	{
		this.accountid = accountid;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPasscode() 
	{
		return passcode;
	}

	public void setPasscode(String passcode) 
	{
		this.passcode = passcode;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(accountid, customerid, passcode, username);
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
		
		Customer other = (Customer) obj;
		return accountid == other.accountid && customerid == other.customerid
				&& Objects.equals(passcode, other.passcode) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", accountid=" + accountid + ", username=" + username
				+ ", passcode=" + passcode + "]";
	}
	
}
