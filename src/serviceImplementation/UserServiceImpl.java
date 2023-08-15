package serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import dao.UserDao;
import model.User;


public class UserServiceImpl {

	@Autowired
	private UserDao userdao;

	
	public boolean validateUser(String username, String password) {

		User user = userdao.getUser(username);

		return user != null && user.getPassword().equals(password);
	}

	
	public boolean isRegisteredUser(String userName) {
		String username = userName;
		boolean isValid = false;

		User user = userdao.registeredUser(username);

		if (user != null) {
			isValid = false;
		} else {
			isValid = true;

		}

		return isValid;
	}

	public void saveUser(String username, String fullname, String password, String email) {

		User user = new User();
		user.setEmail(email);
		user.setFullname(fullname);
		user.setPassword(password);
		user.setUsername(username);
		userdao.saveUser(user);

	}

}