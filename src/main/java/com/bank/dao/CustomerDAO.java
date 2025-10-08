package com.bank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bank.model.Customer;



@Repository
public class CustomerDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	
	//saveCustomer
	public void saveCustomer(Customer customer) {
		Session session = getSession();
		session.persist(customer);
	}
	
	public List<Customer> getAllCustomers() {
		Session session = getSession();
		SelectionQuery<Customer> selectionQuery = session.createSelectionQuery("From Customer",Customer.class);
		List<Customer> customersList = selectionQuery.list();
		
		return customersList;
		
	}
	
	
	public Customer getCustomerById(long customerId) {
		return getSession().createSelectionQuery("From Customer where customerId=?1",Customer.class)
		.setParameter(1,customerId )
		.uniqueResult();
		
	}
	
	public Customer getCustomerByEmail(String email) {
		return getSession().createSelectionQuery("From Customer where email=?1",Customer.class)
		.setParameter(1,email)
		.uniqueResult();
		
	}
	public void updateCustomer(Customer customer) {
		getSession().merge(customer);
	}


}
