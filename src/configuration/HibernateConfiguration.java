package configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Tshirt;
import model.User;


public class HibernateConfiguration {

	public static Session getSession() {
		@SuppressWarnings("deprecation")
		SessionFactory factory = new Configuration().configure("hibernate.cfgTshirt.xml").addAnnotatedClass(Tshirt.class).buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	public static Session getUserSession() {
		@SuppressWarnings("deprecation")
		SessionFactory factory = new Configuration().configure("hibernate.cfgUser.xml").addAnnotatedClass(User.class).buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}
}