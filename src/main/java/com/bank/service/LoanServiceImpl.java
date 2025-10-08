package com.bank.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.LoanDAO;
import com.bank.model.Customer;
import com.bank.model.Loan;


@Service
public class LoanServiceImpl implements LoanService{
	
	@Autowired
	LoanDAO loanDAO;

	@Override
	public void saveLoanApplication(String loanType, double loanAmount, long tenureMonths,Customer customer) {
		long loanAccountNumber = generateLoanAccountNumber(10);
		
		Loan loan=new Loan(loanAccountNumber,customer,loanType,loanAmount,tenureMonths);
		loan.setStatus("PENDING");
		loanDAO.saveLoan(loan);
	}

	//Generating Loan account number
	@Override
	public  long generateLoanAccountNumber(int length) {
		Random random=new Random();
		StringBuilder sb=new StringBuilder();
		sb.append(random.nextInt(9)+1);
		
		for(int i=0;i<length;i++) {
			sb.append(random.nextInt(10));
		}
		
		long accountNumber=Long.parseLong(sb.toString());
		return accountNumber;
		
	}

	@Override
	public List<Loan> getLoans(long customerId) {
		List<Loan> loans = loanDAO.getLoans(customerId);
		return loans;
	}

	@Override
	public List<Loan> getAllLoans() {
		List<Loan> allLoans = loanDAO.getAllLoans();
		return allLoans;
	}

	@Override
	public Loan getLoanById(long loanId) {
		Loan loan = loanDAO.getLoanById(loanId);
		return loan;
	}

	@Override
	public void saveLoan(Loan loan) {
		loanDAO.saveLoan(loan);
		
	}
}
