package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.model.Loan;
import com.bank.model.OTP;
import com.bank.service.AccountService;
import com.bank.service.CustomerService;
import com.bank.service.LoanService;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
@Transactional
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	LoanService loanService;
	
	@Autowired
	HttpSession session;
	
	//This Endpoint call when user clicks on login and login pages will view
	@GetMapping("/login")
	public String showLogin() {
		return "customerLogin";
	}
	
	
	//when Customer Submits login details then this end point calls
	@PostMapping("/login")
	public String validateCustomerAndSendOTP(@RequestParam("accountNumber") long accountNumber,
									@RequestParam("pass") String password,Model model) {
		
		//this method validates customer details move to reset or dashboard pages based on verification
		Account account = customerService.validateCustomerAndSendOTP(accountNumber, password);
		session.setAttribute("account", account);
		//if customer entered details valid and not registered means it goes to reset page
		session.setAttribute("customer", account.getCustomer()); 
		if(account.getCustomer().getPassword().equals(password) && account.getCustomer().isResetDone()==false) {
			
			customerService.sendOtpToMail(account.getCustomer().getEmail());
			return "redirect:/customer/reset";
		}
		
		//if customer entered details valid and is already a registered used means, it goes to dashBoard
		else if(account.getCustomer().getPassword().equals(password) && account.getCustomer().isResetDone()==true) {
			return "redirect:/customer/dashboard";
		}
		
		//if details are Invalid
		else {
			model.addAttribute("error", "Invalid Details!! Please enter correct details");
			return "customerLogin";
		}	
	}
	
	
	//endPoint to show reset page
	@GetMapping("/reset")
	public String showResetPage() {
		return "resetPage";
	}
	
	
	//endPoint to implement reset details
	@PostMapping("/reset")
	public String validateResetPassword(@RequestParam("otp") long otp,@RequestParam("newPass") String password,Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		OTP otp1 = customerService.getOtpByCustomerId(customer.getCustomerId());
		if(otp1.getOpt()==otp ) {
			boolean isReset=true;
			customerService.updatePassword(password,isReset,customer.getCustomerId());
			return "redirect:/customer/login";
		}
		else {
			model.addAttribute("error", "Invalid OTP Entered!!");
			return "resetPage";
		}
		
	}
	
	@GetMapping("/dashboard")
	public String customerDashboard(Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		if(customer==null) {
			return "redirect:/customer/login";
		}
		else {
//			model.addAttribute("loginCustomer", customer);
			return "customerDashboard";
		}
		
	}
	
	@GetMapping("/tranferAmount")
	public String transferAmountForm(Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
//		System.out.println("customer"+customer);
		if(customer!=null) {
			Account account =accountService.getAccountByCustomerId(customer.getCustomerId());
			model.addAttribute("account", account);
			return "tranferAmountForm";
		}
		else {
			return "redirect:/customer/dashboard";
		}
		
	}
	
	@PostMapping("/transferAmount")
	public String transferAmount(@RequestParam(name="senderNo") long senderNo,
								@RequestParam(name="availableBalance") double availableBalance,
								@RequestParam(name="receiverNo") long receiverNo,
								@RequestParam(name="transferAmount") double amountToTransfer,
								Model model) {
		
		String status = accountService.transferAmount(senderNo,availableBalance,receiverNo,amountToTransfer);
		model.addAttribute("status", status);
		return "redirect:/customer/tranferAmount";
	}
	
	@GetMapping("/applyLoan")
	public String applyLoanForm(Model model) {
		Customer customer =(Customer) session.getAttribute("customer");
		model.addAttribute("customer",customer);
		return "loanApplication";
	}
	
	@PostMapping("/applyLoan")
	public String applyLoan(@RequestParam(name="loanType") String loanType,@RequestParam(name="amount") double loanAmount,@RequestParam(name="tenure") long tenureMonths,Model model) {
		Customer customer =(Customer) session.getAttribute("customer");
		loanService.saveLoanApplication(loanType,loanAmount,tenureMonths,customer);
		model.addAttribute("status","Loan Applied Successfully");
		return "redirect:/customer/dashboard";
	}
	
	@GetMapping("/viewLoans")
	public String viewLoans(Model model) {
		Customer customer =(Customer) session.getAttribute("customer");
		List<Loan> loans = loanService.getLoans(customer.getCustomerId());
		model.addAttribute("loans",loans);
		return "viewLoans";
		
	}
	
	@GetMapping("/transactions")
	public String viewTransactions(Model model) {
		Account account =(Account)session.getAttribute("account");
		model.addAttribute("transactions", account.getTransactions());
		return "viewCustomerTransactions";
		
	}
	
}
