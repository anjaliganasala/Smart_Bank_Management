package com.bank.model;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
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
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customerId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false,unique=true)
	private String email;
	
	@Column(nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@Column(nullable=false,unique=true)
	private String phoneNumber;
	
	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false)
	private String password;
	
	@ColumnDefault("false")
	private boolean isResetDone;

	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Account> accounts;
	
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Loan> loans;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<OTP> otps;
	
	
	@ManyToOne
	@JoinColumn(name="admin_Id")
	private Admin admin;
	
	public Customer() {}

	public Customer(String name, String email, LocalDate dob, String phoneNumber, String address, String password,
			boolean isResetDone) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.password = password;
		this.isResetDone = isResetDone;
	}



	public Customer(String name, String email, LocalDate dob, String phoneNumber, String address, String password,
			boolean isResetDone, Admin admin) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.password = password;
		this.isResetDone = isResetDone;
		this.admin = admin;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isResetDone() {
		return isResetDone;
	}
	public void setResetDone(boolean isResetDone) {
		this.isResetDone = isResetDone;
	}


	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	

	public Admin getAdmin() {
		return admin;
	}



	public void setAdmin(Admin admin) {
		this.admin = admin;
	}



	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public List<OTP> getOtps() {
		return otps;
	}

	public void setOtps(List<OTP> otps) {
		this.otps = otps;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", dob=" + dob
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", password=" + password + ", isResetDone="
				+ isResetDone + "]";
	}
	
	
	
}
