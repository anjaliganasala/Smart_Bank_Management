package com.bank.service;

import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.model.OTP;

public interface CustomerService {
	
	public void saveCustomer(Customer customer);
	

	public Account validateCustomerAndSendOTP(long accountNumber,String password);
	

	public void sendOtpToMail(String emailId);
	
	
	public OTP getOtpByCustomerId(long customerId);


	public void updatePassword(String password,boolean isReset, long customerId);


	

}
