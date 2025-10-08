package com.bank.service;

import java.util.List;

import com.bank.model.Customer;
import com.bank.model.Loan;

public interface LoanService {

	public void saveLoanApplication(String loanType, double loanAmount, long tenureMonths,Customer customer);
	
	public  long generateLoanAccountNumber(int length);

	public List<Loan> getLoans(long customerId);
	
	public Loan getLoanById(long loanId);
	
	public List<Loan> getAllLoans();
	
	public void saveLoan(Loan loan);
}
