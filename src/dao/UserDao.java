package dao;

import model.User;

public interface UserDao {

	public void saveUser(User user);

	public User getUser(String username);

	public User registeredUser(String username);

}