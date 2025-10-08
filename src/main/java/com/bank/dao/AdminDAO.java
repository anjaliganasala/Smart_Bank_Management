package com.bank.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bank.model.Admin;



@Repository
public class AdminDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Admin getAdmin(String email,String password) {
		Session session = getSession();
		Admin admin = session.createSelectionQuery("select u from Admin u where u.email=:email and u.password=:password",Admin.class)
		.setParameter("email", email)
		.setParameter("password", password).uniqueResult();
		return admin;
		
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	public void saveAdmin(String fullName, String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		Admin admin=new Admin(fullName,email,password);
		session.persist(admin);
		
	}



	

	
}
