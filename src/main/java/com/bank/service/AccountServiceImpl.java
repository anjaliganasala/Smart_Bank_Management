package com.bank.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bank.dao.AccountDAO;
import com.bank.dao.BankTransactionsDAO;
import com.bank.dao.CustomerDAO;
import com.bank.model.Account;
import com.bank.model.BankTransactions;
import com.bank.model.Customer;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDAO accountDAO;
	
	@Autowired
	BankTransactionsDAO bankTransactionsDAO;
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	JavaMailSender mailSender;

	@Override
	public void updateAccount(Account account) {
		accountDAO.updateAccount(account);
		
	}
	
	@Override
	public void createAccount(Customer customer,Account account) {
		
		String password=generatePassword(5);
		customer.setPassword(password);
		customerDAO.saveCustomer(customer);
		long accountNumber=0;
		try {
			accountNumber = generateAccountNumber(11);
		} catch (Exception e) {
			e.printStackTrace();
		}
		account.setAccountNumber(accountNumber);
		LocalDateTime dateAndTime=LocalDateTime.now();
		account.setCreatedAt(dateAndTime);
		account.setCustomer(customer);
		sendAccountDetailsToCustomer(customer.getEmail(),accountNumber,customer.getPassword());
		accountDAO.saveAccount(account);
		
	}
	//Generating account number
		@Override
		public  long generateAccountNumber(int length) {
			Random random=new Random();
			StringBuilder sb=new StringBuilder();
			sb.append(random.nextInt(9)+1);
			
			for(int i=0;i<length;i++) {
				sb.append(random.nextInt(10));
			}
			
			long accountNumber=Long.parseLong(sb.toString());
			return accountNumber;
			
		}
		
		//Generating account number
				@Override
				public  String generatePassword(int length) {
					Random random=new Random();
					StringBuilder sb=new StringBuilder();
					sb.append(random.nextInt(9)+1);
					
					for(int i=0;i<length;i++) {
						sb.append(random.nextInt(10));
					}
					
					String password = sb.toString();
					return password;
					
				}
		
		@Override
		public void sendAccountDetailsToCustomer(String emailId,long accountNumber,String password) {
			SimpleMailMessage mail=new SimpleMailMessage();
			mail.setFrom("raj6gadasena@gmail.com");
			mail.setTo(emailId);
			mail.setSubject("Account Details!!!!!");
			mail.setText("Your savings Bank Account Created Successfully at XYZ Bank!! \n"
					+ "Please Use Below Details to Login for further Activity \n"
					+ "Your Account Number :"+accountNumber+"\n"+"Your Password :"+password);
			mailSender.send(mail);
		}
	
	@Override
	public Account getAccountByCustomerId(long customerId) {
		Account account = accountDAO.getAccountByCustomerId(customerId);
		return account;
	}
	
	@Override
	public String transferAmount(long senderNo, double availableBalance, long receiverNo, double amountToTransfer) {
		
		Account receiverAccount = accountDAO.getAccountByNumber(receiverNo);
		Account senderAccount = accountDAO.getAccountByNumber(senderNo);
		if(receiverAccount!=null) {
			if(amountToTransfer<=availableBalance) {
				
				receiverAccount.setBalance(receiverAccount.getBalance()+amountToTransfer);
				accountDAO.updateAccount(receiverAccount);
				BankTransactions receiverBankTransaction=new BankTransactions(receiverAccount,"credit",amountToTransfer,"success");
				bankTransactionsDAO.saveTransaction(receiverBankTransaction);
				
				senderAccount.setBalance(senderAccount.getBalance()-amountToTransfer);
				accountDAO.updateAccount(senderAccount);
				BankTransactions senderBankTransaction=new BankTransactions(senderAccount,"debit",amountToTransfer,"success");
				bankTransactionsDAO.saveTransaction(senderBankTransaction);
				return "Amount Tranfer Success!!";
			}
			else {
				BankTransactions senderBankTransaction=new BankTransactions(receiverAccount,"debit",amountToTransfer,"failed");
				bankTransactionsDAO.saveTransaction(senderBankTransaction);
				return "Insufficient Balance";
			}
		}
		else {
			return "No Receiver Account Found!!";
		}
	}

}
