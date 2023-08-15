package daoImplementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import configuration.HibernateConfiguration;
import constants.Constants;
import constants.HqlQueries;
import dao.TshirtDao;
import model.Tshirt;
import service.ReadFilesService;


public class TshirtDaoImp implements TshirtDao {
	
	@Autowired
	private ReadFilesService readFilesDirectory;
	

	public void saveData(List<Tshirt> tshirtList) {
		// TODO Auto-generated method stub
		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();
		try {
			for (Tshirt tshirtData : tshirtList) {
				session.saveOrUpdate(tshirtData);
			}

			session.getTransaction().commit();

		} catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		session.close();

	}

	
	@SuppressWarnings("unchecked")
	public List<Tshirt> getData(String color, String size, String gender, String outputPreference) {

		List<Tshirt> sortedTshirtList = new ArrayList<>();
		String hqlQuery;
		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();
		readFilesDirectory.readDirectory();
		if (outputPreference.equalsIgnoreCase(Constants.RATING)) {
			hqlQuery = HqlQueries.QUERY_ORDERBY_RATING;
		}

		else if (outputPreference.equalsIgnoreCase(Constants.PRICE)) {
			hqlQuery = HqlQueries.QUERY_ORDERBY_PRICE;
		}

		else {
			hqlQuery = HqlQueries.QUERY_ORDERBY_BOTH;
		}

		Query query = session.createQuery(hqlQuery);
		query.setParameter("color", color);
		query.setParameter("size", size);
		query.setParameter("gender", gender);
		sortedTshirtList = query.list();
		session.getTransaction().commit();
		session.close();

		return sortedTshirtList;

	}
}