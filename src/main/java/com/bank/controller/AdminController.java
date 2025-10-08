package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bank.model.Account;
import com.bank.model.Admin;
import com.bank.model.BankTransactions;
import com.bank.model.Customer;
import com.bank.model.Loan;
import com.bank.service.AccountService;
import com.bank.service.AdminService;
import com.bank.service.CustomerService;
import com.bank.service.LoanService;
import com.bank.service.TransactionService;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
@Transactional
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	LoanService loanService;
	
	@Autowired
	HttpSession session;
	
	
	//signUp
	@GetMapping("/signUp")
	public String showSignUp() {
		return "adminSignUp";
	}
	
	@PostMapping("/signUp")
	public String signUp(@RequestParam("fullName") String fullName,@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("secretCode") String secretCode) {
		
		adminService.saveAdmin(fullName,email,password,secretCode);
		
		return "redirect:/admin/login";
		
	}
	
	
	
	//redirecting to Admin login
	@GetMapping("/login")
	public String showLogin() {
		return "adminLogin";
	}
		
	//validating Admin
	@PostMapping("/login")
	public String validateAdmin(@RequestParam("email") String email,@RequestParam("password") String password,Model model) {
		Admin admin = adminService.getAdmin(email, password);
		if(admin==null) {	
			model.addAttribute("error", "user and password are invalid");
			return "adminLogin";
		}
		else {
			model.addAttribute("admin",admin); 
			session.setAttribute("admin", admin);
			return "redirect:/admin/dashboard";
		}	
		
	}
	
	//going to admin dashboad
	@GetMapping("/dashboard")
	public String dashBoard() {
		if(session.getAttribute("admin")==null) {
			return "redirect:/admin/login";
		}
		else {
			return "adminDashboard";
		}
	}
	
	@GetMapping("/registerCustomer")
	public String showAccountForm() {
		return "createAccount";
	}
	
	//Account creation for Customer
	
	@PostMapping("/createAccount")
	public String saveCustomer(@ModelAttribute Customer customer,@ModelAttribute Account account) {
		Admin admin = (Admin)session.getAttribute("admin");
		customer.setAdmin(admin);
		accountService.createAccount(customer,account);
		return "redirect:/admin/dashboard";
	}
	
	//view All Customers
	
	@GetMapping("/customers")
	public String viewAllCustomers(Model model) {
		List<Customer> allCustomers = adminService.getAllCustomers();
		model.addAttribute("customers", allCustomers);
		return "viewCustomers";
	}
	
	//view Account details
	@GetMapping("/account/{id}")
	public String viewAccount(@PathVariable(name="id") long customerId) {
		Account account = accountService.getAccountByCustomerId(customerId);
		session.setAttribute("account", account);
		return "viewAccount";
	}
	
	//Manage balance
	@PostMapping("/account/{id}")
	public String updateBalance(@PathVariable(name="id") long CustomerId,  @RequestParam(name="transactionType") String transactionType,@RequestParam(name="amount") double amount,RedirectAttributes redirectAttributes) {
		Account account = accountService.getAccountByCustomerId(CustomerId);
		BankTransactions transaction;
		if("Credit".equalsIgnoreCase(transactionType)) {
			account.setBalance(account.getBalance()+amount);
			transaction=new BankTransactions(account,transactionType,amount,"success");
			accountService.updateAccount(account);
			transactionService.saveTransaction(transaction);
			redirectAttributes.addFlashAttribute("success", "Credited Successfully!!");
		}
		else if("Debit".equalsIgnoreCase(transactionType)) {
			if(account.getBalance()>=amount) {
				account.setBalance(account.getBalance()-amount);
				transaction=new BankTransactions(account,transactionType,amount,"success");
				accountService.updateAccount(account);
				transactionService.saveTransaction(transaction);
				redirectAttributes.addFlashAttribute("success", "Debit Successfully!!");
			}
			else {
				 redirectAttributes.addFlashAttribute("error", "Insufficient Balance");
				 return "redirect:/admin/account/"+account.getCustomer().getCustomerId();
			}
		}
		return "redirect:/admin/account/"+account.getCustomer().getCustomerId();
	}
	
	@GetMapping("/transactions")
	public String viewTransactions(Model model) {
		List<BankTransactions> transactions = transactionService.getTransactions();
		model.addAttribute("transactions",transactions);
		return "viewTransactions";
	}
	
	
	@GetMapping("/reviewLoans")
	public String reviewAndUpdateLoans(Model model) {
		List<Loan> allLoans = loanService.getAllLoans();
		model.addAttribute("loans", allLoans);
		return "reviewLoans";
	}
	
	@GetMapping("/reviewLoans/manageLoan/{id}")
	public String manageLoans(@PathVariable(name="id") long loanId,Model model) {
		Loan loan = loanService.getLoanById(loanId);
		session.setAttribute("loan", loan);
		System.out.println(loan);
		model.addAttribute("loan", loan);
		return "manageLoanForm";
	}
	
	@PostMapping("/reviewLoans")
	public String updateLoanStatus(@RequestParam(name="action") String action,Model model) {
		Loan sessionLoan = (Loan)session.getAttribute("loan");
		Loan loan = loanService.getLoanById(sessionLoan.getLoan_id());
		System.out.println(loan);
		if("approve".equals(action) && "PENDING".equalsIgnoreCase(loan.getStatus())) {
			loan.setStatus("APPROVED");
			loanService.saveLoan(loan);
		}
		else if("reject".equals(action)&& "PENDING".equalsIgnoreCase(loan.getStatus())) {
			loan.setStatus("REJECTED");
			loanService.saveLoan(loan);
		}
		return "redirect:/admin/reviewLoans";
		
	}
	

}
