package com.michael.models;

/**
 * Baseline reference for the admin table in database
 * @author Michael Ord
 *
 */
public class Admin 
{
	private int adminid;
	private int fk_account;
	private String username;
	private String password;
	
	public Admin() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminid, int fk_account, String username, String password) 
	{
		super();
		this.adminid = adminid;
		this.fk_account = fk_account;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() 
	{
		return "Admin [adminid=" + adminid + ", fk_account=" + fk_account + ", username=" + username + "]";
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + adminid;
		result = prime * result + fk_account;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Admin other = (Admin) obj;
		if (adminid != other.adminid)
			return false;
		if (fk_account != other.fk_account)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public int getFk_account() {
		return fk_account;
	}

	public void setFk_account(int fk_account) {
		this.fk_account = fk_account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

