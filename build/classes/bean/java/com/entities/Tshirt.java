package com.entities;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tshirt ")
public class Tshirt {

	@Id
	String id;

	@Column(name = "NAME")
	String name;

	@Column(name = "COLOR")
	String color;

	@Column(name = "GENDER_RECOMMENDATION")
	String genderRecom;

	@Column(name = "SIZE")
	String size;

	@Column(name = "PRICE")
	float price;

	@Column(name = "RATING")
	float rating;

	@Column(name = "AVAILABILITY")
	String availability;

	public Tshirt() {

	}

	Tshirt(String id, String name, String color, String genderRecom, String size, float price, float rating,
			String availability) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.genderRecom = genderRecom;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
	}

	public String getID() {

		return id;
	}

	public void setID(String ID) {
		this.id = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGenderRecom() {
		return genderRecom;
	}

	public void setGenderRecom(String genderRecom) {
		this.genderRecom = genderRecom;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Tshirt [id=" + id + ", name=" + name + ", color=" + color + ", genderRecom=" + genderRecom + ", size="
				+ size + ", price=" + price + ", rating=" + rating + ", availability=" + availability + "]";
	}

}
