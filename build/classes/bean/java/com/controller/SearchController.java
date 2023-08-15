package com.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Tshirt;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.service.DataTshirt;

@Controller
public class SearchController extends Thread {

	@Autowired
	DataTshirt dataTshirt;
	
	
	static List<String> fileNames;
	static File folder = new File("C:\\Users\\mrinalkushwaha\\Documents\\AdvJ_Assignment4\\src\\\\main\\resources");
	long lastModified;

	public void run() {
		fileNames = new LinkedList<String>();
		
		for (final File fileEntry : folder.listFiles()) {
			
			if (fileEntry.getName().contains(".csv"))

				fileNames.add("C:\\Users\\mrinalkushwaha\\Documents\\AdvJ_Assignment4\\src\\main\\resources\\" + fileEntry.getName());

		}

		try {
			//dataTshirt.insertCSVinDB(fileNames); 
				
				// building session for inserting data in database
			SessionFactory factory = new Configuration().configure("hibernateC.cfg.xml").addAnnotatedClass(Tshirt.class)
					.buildSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();

			for (String fileName : fileNames) {
				FileReader filereader = new FileReader(fileName);

				CSVParser parser = new CSVParserBuilder().withSeparator('|').build();

				CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).withCSVParser(parser).build();

				List<String[]> allData = csvReader.readAll();

				for (String[] row : allData) {
					if (row.length > 7 ) {

						Tshirt tshirt = new Tshirt();
						tshirt.setID(row[0].toUpperCase()); 			// id
						tshirt.setName(row[1].toUpperCase()); 			// name
						tshirt.setColor(row[2].toUpperCase()); 			// color
						tshirt.setGenderRecom(row[3].toUpperCase()); 	// gender
						tshirt.setSize(row[4].toUpperCase()); 			// size
						tshirt.setPrice(Float.parseFloat(row[5])); 		// price
						tshirt.setRating(Float.parseFloat(row[6])); 	// rating
						tshirt.setAvailability(row[7].toUpperCase()); 	// availability

						session.save(tshirt);
					}
				}

			}

			session.getTransaction().commit();
			session.close();
			// feeding csv files data in database
		} catch (IOException e) {
			e.printStackTrace();
			}

	}

	@PostMapping("/Product")
	public ModelAndView doSearch(HttpServletRequest request, HttpServletResponse response) throws InterruptedException, IOException {

		 ModelAndView mv=new ModelAndView();

		String color = request.getParameter("COLOR");
		String size = request.getParameter("SIZE");
		String gender = request.getParameter("GENDER");
		String outputPreference = request.getParameter("OUTPUTPREFERENCE");

		// making thread to read all filename in folder
		SearchController fileReadThread = new SearchController();
		fileReadThread.start();

		// saving last modified for the csv folder
		
		lastModified = folder.lastModified();
		
		fileReadThread.join();
		fileReadThread.interrupt();
		
		
		List<Tshirt> tshirts=dataTshirt.searchDataDB(color, gender, size, outputPreference);

		// running thread again if files added/removed/changed in folder
		if (lastModified != folder.lastModified()) {
			lastModified = folder.lastModified();
			fileReadThread.run();
			fileReadThread.join();
			fileReadThread.interrupt();
			tshirts=dataTshirt.searchDataDB(color, gender, size, outputPreference);
		}
		mv.addObject("searchResult", tshirts);
		mv.setViewName("Product");
		return mv;
	}
}
