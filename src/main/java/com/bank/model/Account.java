package com.bank.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long accountId;
	
	
	@ManyToOne
	@JoinColumn(name="customer_id" )
	private Customer customer;
	
	@Column(nullable=false,unique=true)
	private long accountNumber;
	
	@Column(nullable=false)
	private String ifscCode;
	
	@Column(nullable=false)
	private String accountType;
	
	@Column(nullable=false)
	private double balance;
	
	@Column(nullable=false,columnDefinition = "TIMESTAMP")
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy="account",fetch = FetchType.EAGER)
	private List<BankTransactions> transactions;
	
	
	public Account() {
		
	}
	
	public Account(long accountNumber, String ifscCode, String accountType,
			double balance, LocalDateTime createdAt) {
		super();
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.accountType = accountType;
		this.balance = balance;
		this.createdAt = createdAt;
	}








	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<BankTransactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<BankTransactions> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", ifscCode=" + ifscCode
				+ ", accountType=" + accountType + ", balance=" + balance + ", createdAt=" + createdAt + "]";
	}

	
	
	
	

	
}
