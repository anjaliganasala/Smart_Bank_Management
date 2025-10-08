package com.bank.service;

import java.util.List;
import com.bank.model.Admin;
import com.bank.model.Customer;

public interface AdminService {

	public Admin getAdmin(String email,String password);
	

	public List<Customer> getAllCustomers();
	

	public void saveAdmin(String fullName,String email,String password,String secretCode);

	
}
