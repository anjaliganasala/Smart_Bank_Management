package com.bank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.model.BankTransactions;


@Repository
public class BankTransactionsDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public void saveTransaction(BankTransactions transaction) {
		Session session = getSession();
		session.persist(transaction);
	}

	public List<BankTransactions> getTransactions() {
		Session session = getSession();
		SelectionQuery<BankTransactions> query = session.createSelectionQuery("From BankTransactions", BankTransactions.class);
		List<BankTransactions> list = query.list();
		return list;
		
		
	}

}
