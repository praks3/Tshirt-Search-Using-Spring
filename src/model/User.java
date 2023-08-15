package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue()
	int userId;
	@Column(name = "FullName")
	String fullname;
	@Column(name = "Username", unique = true)
	String username;
	@Column(name = "Password")
	String password;
	@Column(name = "EmailAddress")
	String email;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String fullname, String username, String password, String email) {
		// TODO Auto-generated constructor stub
		super();
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}