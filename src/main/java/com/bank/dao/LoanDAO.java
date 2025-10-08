package com.bank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.SelectionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.model.Loan;

@Repository
public class LoanDAO {

	
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public void saveLoan(Loan loan) {
		Session session = getSession();
		session.persist(loan);
	}
	
	public Loan getLoanById(long loanId) {
		Session session = getSession();
		Loan loan = session.createNativeQuery("select * from loans where loan_id=?1", Loan.class)
		.setParameter(1, loanId)
		.uniqueResult();
		return loan;
	}

	public List<Loan> getLoans(long customerId) {
		Session session = getSession();
		SelectionQuery<Loan> query = session.createNativeQuery("select * from loans where customer_id=?1", Loan.class);
		query.setParameter(1, customerId);
		List<Loan> list = query.list();
		
		return list;
	}
	
	public List<Loan> getAllLoans(){
		Session session = getSession();
		NativeQuery<Loan> query = session.createNativeQuery("select * from loans", Loan.class);
		List<Loan> loanList = query.list();
		return loanList;
		
	}

}
