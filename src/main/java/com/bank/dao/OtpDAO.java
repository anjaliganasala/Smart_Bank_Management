package com.bank.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.model.OTP;

@Repository
public class OtpDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	
	//saveOTP
	public void saveOTP(OTP otp) {
		Session session = getSession();
		session.persist(otp);
	}
	
	//get OTP details
	public OTP getOTPByCustomerId(long customerId) {
		Session session = getSession();
		OTP otp = session.createNativeQuery("select * from otps where customer_id=?1",OTP.class)
		.setParameter(1, customerId)
		.uniqueResult();
		return otp;
	}
	

	public void deleteOtpByCustomerId(OTP otp) {
		getSession().remove(otp);
	}
	

}
