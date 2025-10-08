package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.BankTransactionsDAO;
import com.bank.model.BankTransactions;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	BankTransactionsDAO bankTransactionsDAO;

	@Override
	public void saveTransaction(BankTransactions transaction) {
		bankTransactionsDAO.saveTransaction(transaction);
		
	}

	@Override
	public List<BankTransactions> getTransactions() {
		List<BankTransactions> transactions = bankTransactionsDAO.getTransactions();
		return transactions;
		
		
	}

}
