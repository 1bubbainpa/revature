package com.revatureMichael.banking.models;

import java.util.Objects;

public class Account 
{
	private int accountid;
	private int balance;
	private boolean approved;
	
	public Account() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountid, int balance, boolean approved) 
	{
		super();
		this.accountid = accountid;
		this.balance = balance;
		this.approved = approved;
	}

	public int getAccountid() 
	{
		return accountid;
	}

	public void setAccountid(int accountid) 
	{
		this.accountid = accountid;
	}

	public int getBalance() 
	{
		return balance;
	}

	public void setBalance(int balance) 
	{
		this.balance = balance;
	}

	public boolean isApproved() 
	{
		return approved;
	}

	public void setApproved(boolean approved) 
	{
		this.approved = approved;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(accountid, approved, balance);
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
		
		Account other = (Account) obj;
		return accountid == other.accountid && approved == other.approved && balance == other.balance;
		
	}

	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", balance=" + balance + ", approved=" + approved + "]";
	}
	
}
