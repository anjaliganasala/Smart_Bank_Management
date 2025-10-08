package com.bank.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity

@Table(name="Transactions")
public class BankTransactions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long transactionId;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	
	@Column(nullable=false)
	private String transactionType;
	
	@Column(nullable=false)
	private double amount;
	
	
	@Column(nullable=false)
	private LocalDate date;
	
	@Column(nullable=false)
	private LocalTime time;
	
	@Column(nullable=false)
	private String status;

	public BankTransactions() {}
	
	 @PrePersist
	    public void onCreate() {
	        date = LocalDate.now();   // current date only
	        time = LocalTime.now();   // current time only
	    }

	public BankTransactions(String transactionType, double amount, LocalDate date, LocalTime time, String status) {
		super();
		this.transactionType = transactionType;
		this.amount = amount;
		this.date = date;
		this.time = time;
		this.status = status;
	}

	
	
	
	public BankTransactions(Account account, String transactionType, double amount,
			String status) {
		super();
		this.account = account;
		this.transactionType = transactionType;
		this.amount = amount;
		this.status = status;
	}




	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}




	@Override
	public String toString() {
		return "BankTransactions [transactionId=" + transactionId + ", transactionType=" + transactionType + ", amount="
				+ amount + ", date=" + date + ", time=" + time + ", status=" + status + "]";
	}

	
	
	
	
		
}
