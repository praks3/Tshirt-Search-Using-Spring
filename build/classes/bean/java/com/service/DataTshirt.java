package com.service;


import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.entities.Tshirt;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Controller
public class DataTshirt {
	
	// function to search tshirt 
	public List<Tshirt> searchDataDB(String color, String genderRecom, String size, String outputPrefrence) throws IOException {

		
		try {
			
			// session for searching tshirts
			SessionFactory factory = new Configuration().configure("hibernateV.cfg.xml").addAnnotatedClass(Tshirt.class)
					.buildSessionFactory();
			Session session = factory.openSession();
	
			session.beginTransaction();
	
			Query searchQuery;
	
			if (outputPrefrence.equals("1")) {								// sorting by price
				searchQuery = session.createQuery(
						"from Tshirt where COLOR= :color and SIZE= :size and GENDER_RECOMMENDATION= :gender order by PRICE");
			} else if (outputPrefrence.equals("2")) {						// sorting by rating
				searchQuery = session.createQuery(
						"from Tshirt where COLOR= :color and SIZE= :size and GENDER_RECOMMENDATION= :gender order by RATING DESC");
			} else {
				searchQuery = session.createQuery(							// sorting by price/rating both
						"from Tshirt where COLOR= :color and SIZE= :size and GENDER_RECOMMENDATION= :gender order by PRICE,RATING DESC");
			}
			
			searchQuery.setParameter("color", color);
			searchQuery.setParameter("size", size);
			searchQuery.setParameter("gender", genderRecom);
			
			List<Tshirt> shirtList = searchQuery.list();
			session.getTransaction().commit();
			session.close();
			
			return shirtList;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}