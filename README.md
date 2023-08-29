**README.md**

# Tshirt Search Web Application using Spring and Hibernate

This repository contains a Spring-based web application designed to help users find T-shirts based on various criteria. The application reads T-shirt data from CSV files for different companies (Puma, Nike, Adidas), persists the data in a database using Hibernate, and provides matching product listings. Users can search for T-shirts by specifying color, size, gender, and output preference.

## Problem Statement

The objective of this project is to implement a T-shirt product search web application using Spring and Hibernate. The application enables users to search for T-shirts based on specific criteria and provides the matching results.

### CSV Fields Details

The CSV files contain the following fields for each T-shirt:

- **ID**: Unique product ID, starting with a 2-digit company code.
- **NAME**: Model name.
- **COLOUR**: T-shirt color.
- **GENDER_RECOMMENDATION**: Gender for which this T-shirt is recommended (M - Male, F - Female, U - Unisex).
- **SIZE**: T-shirt size (S, M, L, XL, XXL).
- **PRICE**: Price of the T-shirt per piece in INR.
- **RATING**: Rating of the T-shirt from 1 to 5 (1 being lowest and 5 being highest).
- **AVAILABILITY**: Availability of the T-shirt (Y or N).

## Web Application using Spring and Hibernate

- The web application allows users to input search criteria (color, size, gender, and output preference) through a user-friendly interface.
- Users can access the application by logging in through the login page.
- Upon successful login, the Product Search Screen displays, allowing users to specify search parameters and trigger a search.
- The program displays search results from the database using Hibernate.

## Note

- The application aims to provide an efficient and user-friendly way to search for T-shirt products using a web-based interface.
- You can customize and extend this project to suit your requirements.

For any further assistance or inquiries, please contact Prakhar Srivastava at sprakhar275@gmail.com.
