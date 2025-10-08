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
@Table(name="otps")
public class OTP {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long otp_id;
	
	
	@Column(nullable = false)
	private long otp;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
	public OTP() {}


	public OTP(long otp, Customer customer) {
		super();
		this.otp = otp;
		this.customer = customer;
	}


	public long getOtp_id() {
		return otp_id;
	}


	public void setOtp_id(long otp_id) {
		this.otp_id = otp_id;
	}


	public long getOpt() {
		return otp;
	}


	public void setOpt(long opt) {
		this.otp = opt;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "OTP [otp_id=" + otp_id + ", otp=" + otp + "]";
	}
	
	
}
