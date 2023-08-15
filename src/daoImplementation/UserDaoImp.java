package daoImplementation;

import org.hibernate.Query;
import org.hibernate.Session;

import configuration.HibernateConfiguration;
import constants.HqlQueries;
import dao.UserDao;
import model.User;


public class UserDaoImp implements UserDao {

	
public void saveUser(User user) {
		// TODO Auto-generated method stub

		Session session = HibernateConfiguration.getUserSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

	}


	public User getUser(String username) {
		// TODO Auto-generated method stub

		Session session = HibernateConfiguration.getUserSession();
		session.beginTransaction();

		Query query = session.createQuery(HqlQueries.QUERY_USER);
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();
		session.getTransaction().commit();
		session.close();

		return user;
	}


	public User registeredUser(String userName) {
		Session session = HibernateConfiguration.getUserSession();
		session.beginTransaction();
		Query query = session.createQuery(HqlQueries.QUERY_USER);
		query.setParameter("username", userName);
		User user = (User) query.uniqueResult();

		return user;
	}
}