package com.dao;

import com.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public class LoginDAO {

	@RequestMapping("/users")
	public boolean checkUser(String uname,String pass) {
		
		SessionFactory factory = new Configuration().configure("hibernateV.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Query searchQuery = session.createQuery(
				"from Users where username=:uname AND password=:pass");
		searchQuery.setParameter("uname", uname);
		searchQuery.setParameter("pass", pass);
		Users user=(Users) searchQuery.uniqueResult();
		if(user!=null) {
			session.getTransaction().commit();
			session.close();
			return true;
		}
		session.getTransaction().commit();
		session.close();
		return false;
	}

}
