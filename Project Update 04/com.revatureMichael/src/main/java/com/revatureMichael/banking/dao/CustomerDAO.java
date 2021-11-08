package com.revatureMichael.banking.dao;

import java.util.List;

import com.revatureMichael.banking.models.*;

public interface CustomerDAO
{
	public boolean insertIntoCustomer(Customer cus);
	public Customer selectCustomerById(Integer id);
	public List<Customer> selectAllCustomers();
	public boolean updateCustomer(Customer cus);
	public boolean deleteCustomer(Customer cus);
	public Customer selectCustomerByCredentials(String username, String password);
}
