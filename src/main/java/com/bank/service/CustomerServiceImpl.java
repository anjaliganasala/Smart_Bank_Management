package com.bank.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bank.dao.AccountDAO;
import com.bank.dao.CustomerDAO;
import com.bank.dao.OtpDAO;
import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.model.OTP;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	AccountDAO accountDAO;
	@Autowired
	OtpDAO otpDAO;
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	@Override
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
		
	}

	//Validating login details and send back OTP for customer mail to reset password
	@Override
	public Account validateCustomerAndSendOTP(long accountNumber, String password) {
		Account account = accountDAO.getAccountByNumber(accountNumber);
		if(account!=null) {
			return account;
		}
		else {
			return null;
		}
	}
	
	
	@Override
	public void sendOtpToMail(String emailId) {
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setFrom("raj6gadasena@gmail.com");
		mail.setTo(emailId);
		mail.setSubject("OTP for Reset Password!!");
		Random random=new Random();
		int otp=random.nextInt(900000) + 100000;
		mail.setText("User below OTP to Reset your password:\n Your OTP is:"+otp);
		mailSender.send(mail);
		
		Customer customer = customerDAO.getCustomerByEmail(emailId);
		OTP savedOtp=new OTP(otp,customer);
		otpDAO.saveOTP(savedOtp);
	}


	@Override
	public OTP getOtpByCustomerId(long customerId) {
		OTP otp = otpDAO.getOTPByCustomerId(customerId);
		return otp;
	}

	@Override
	public void updatePassword(String password,boolean isReset,long customerId) {

		Customer customer = customerDAO.getCustomerById(customerId);
		if(customer!=null) {
			customer.setPassword(password);
			customer.setResetDone(isReset);
			customerDAO.updateCustomer(customer);
			OTP otp = otpDAO.getOTPByCustomerId(customerId);
			otpDAO.deleteOtpByCustomerId(otp);
		}
		else {
			System.out.println("Customer is null");
		}
		
		
	}

	

}
