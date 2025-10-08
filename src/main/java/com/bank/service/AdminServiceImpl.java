package com.bank.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bank.dao.AdminDAO;
import com.bank.dao.CustomerDAO;
import com.bank.model.Admin;
import com.bank.model.Customer;

import jakarta.transaction.Transactional;
@Transactional
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDAO adminDAO;
	
	@Autowired
	CustomerDAO customerDAO;
	
	
	@Override
	public Admin getAdmin(String email,String password) {
		return adminDAO.getAdmin(email, password);
	}


	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers = customerDAO.getAllCustomers();
		return allCustomers;
	}
	

	@Override
	public void saveAdmin(String fullName,String email,String password,String secretCode) {
		if("Bank@123".equals(secretCode)){
			adminDAO.saveAdmin(fullName,email,password);
		}
		
	}

	

}
