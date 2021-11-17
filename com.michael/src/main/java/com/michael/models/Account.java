package com.michael.models;
/**
 * Baseline reference for the account table in database
 * @author Michael Ord
 *
 */
public class Account 
{
	private int accountid;
	private int fk_users;
	private String username;
	private String passcode;
	private boolean activated;
	private int reputation;
	
	public Account() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(int accountid, int fk_users, String username, String passcode, boolean activated, int reputation) {
		super();
		this.accountid = accountid;
		this.fk_users = fk_users;
		this.username = username;
		this.passcode = passcode;
		this.activated = activated;
		this.reputation = reputation;
	}
	
	@Override
	public String toString() 
	{
		return "Account [accountid=" + accountid + ", fk_users=" + fk_users + ", username=" + username
				+ ", activated=" + activated + ", reputation=" + reputation + "]";
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + accountid;
		result = prime * result + (activated ? 1231 : 1237);
		result = prime * result + fk_users;
		result = prime * result + ((passcode == null) ? 0 : passcode.hashCode());
		result = prime * result + reputation;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountid != other.accountid)
			return false;
		if (activated != other.activated)
			return false;
		if (fk_users != other.fk_users)
			return false;
		if (passcode == null) {
			if (other.passcode != null)
				return false;
		} else if (!passcode.equals(other.passcode))
			return false;
		if (reputation != other.reputation)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
		
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public int getFk_users() {
		return fk_users;
	}
	public void setFk_users(int fk_users) {
		this.fk_users = fk_users;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public int getReputation() {
		return reputation;
	}
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}
	
	
}
