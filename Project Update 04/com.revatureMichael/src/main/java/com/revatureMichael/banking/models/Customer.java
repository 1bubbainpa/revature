package com.revatureMichael.banking.models;

import java.util.Objects;

public class Customer 
{
	private int customerid;
	private String firstname;
	private String lastname;
	private String city;
	private String state;
	private int zipcode;
	private String email;
	
	public Customer() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerid, String firstname, String lastname, String city, String state, int zipcode,
			String email) 
	{
		super();
		this.customerid = customerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
	}

	public int getCustomerid() 
	{
		return customerid;
	}

	public void setCustomerid(int customerid) 
	{
		this.customerid = customerid;
	}

	public String getFirstname() 
	{
		return firstname;
	}

	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}

	public String getLastname() 
	{
		return lastname;
	}

	public void setLastname(String lastname) 
	{
		this.lastname = lastname;
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getState() 
	{
		return state;
	}

	public void setState(String state) 
	{
		this.state = state;
	}

	public int getZipcode() 
	{
		return zipcode;
	}

	public void setZipcode(int zipcode) 
	{
		this.zipcode = zipcode;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(city, customerid, email, firstname, lastname, state, zipcode);
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
		return Objects.equals(city, other.city) && customerid == other.customerid && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(state, other.state) && zipcode == other.zipcode;
	}

	@Override
	public String toString() 
	{
		return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname + ", city="
				+ city + ", state=" + state + ", zipcode=" + zipcode + ", email=" + email + "]";
	}
	
	
	
	
}
