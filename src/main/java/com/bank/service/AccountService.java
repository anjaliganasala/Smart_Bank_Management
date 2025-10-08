package com.bank.service;

import com.bank.model.Account;
import com.bank.model.Customer;

public interface AccountService {
	
	
	public void createAccount(Customer customer,Account account);
	
	public  String generatePassword(int length);
	
	public  long generateAccountNumber(int length);
	
	public void sendAccountDetailsToCustomer(String emailId,long accountNumber,String password);
	
	public void updateAccount(Account account);
	
	public Account getAccountByCustomerId(long customerId);
	
	public String transferAmount(long senderNo, double availableBalance, long receiverNo, double amountToTransfer);

}
