package com.bank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="loans")
public class Loan {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loan_id;
	
	@Column(nullable=false)
	private long loanAccountNumber;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@Column(nullable=false)
	private String loan_type;
	
	
	@Column(nullable=false)
	private double amount;
	
	@Column(nullable=false)
	private long tenureMonths;
	
	@Column(nullable=false)
	private String status;

	public Loan() {}


	public Loan(long loanAccountNumber, Customer customer, String loan_type, double amount, long tenureMonths) {
		super();
		this.loanAccountNumber = loanAccountNumber;
		this.customer = customer;
		this.loan_type = loan_type;
		this.amount = amount;
		this.tenureMonths = tenureMonths;
	}

	public long getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(long loan_id) {
		this.loan_id = loan_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public long getLoanAccountNumber() {
		return loanAccountNumber;
	}



	public void setLoanAccountNumber(long loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}



	public long getTenureMonths() {
		return tenureMonths;
	}


	public void setTenureMonths(long tenureMonths) {
		this.tenureMonths = tenureMonths;
	}


	@Override
	public String toString() {
		return "Loan [loan_id=" + loan_id + ", loanAccountNumber=" + loanAccountNumber + ", loan_type=" + loan_type
				+ ", amount=" + amount + ", tenureMonths=" + tenureMonths + ", status=" + status + "]";
	}
	
	
	
	
}
