package com.bank.service;

import java.util.List;

import com.bank.model.BankTransactions;

public interface TransactionService {
	
	public void saveTransaction(BankTransactions transaction);

	public List<BankTransactions> getTransactions();

}
