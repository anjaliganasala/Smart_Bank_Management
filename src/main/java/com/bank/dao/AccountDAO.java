package com.bank.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.model.Account;

@Repository
public class AccountDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	
	public void saveAccount(Account account) {
		Session session=getSession();
		session.persist(account);
	}
	
	public Account getAccountByCustomerId(long customerId) {
		Session session = getSession();
		Account account = session.createNativeQuery("select * from accounts where customer_id=?1",Account.class)
				.setParameter(1, customerId)
				.uniqueResult();
		return account;
	}
	
	//getCustomerByAccount
		public Account getAccountByNumber(long accountNumber) {
			Session session = getSession();
			Account account = session.createSelectionQuery("select u from Account u where accountNumber=:accountNumber",Account.class)
			.setParameter("accountNumber", accountNumber)
			.uniqueResult();
			
			return account;
			
		}
	
	public void updateAccount(Account account) {
		Session session = getSession();
		session.merge(account);
	
	}
}
