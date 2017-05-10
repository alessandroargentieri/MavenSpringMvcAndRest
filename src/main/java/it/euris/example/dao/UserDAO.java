package it.euris.example.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import it.euris.example.models.User;

@Component
public class UserDAO {
	

	private static List<User> userslist = new ArrayList<User>();
	
	
	/**COSTRUTTORE**/
	public UserDAO(){
		userslist.add(new User("Mino", "Faita"));
		userslist.add(new User("Francesco", "Giannotta"));
		userslist.add(new User("Luciana", "Pellizzati"));
	}
	
	
	/*-----------------------------------------------------*/
	
	
	public List list() {
		return userslist;
	}

	
	/*-----------------------------------------------------*/
	
	
	public User get(String name) {
		for (User u : userslist) {
			if (u.getName().equals(name)) {
				return u;
			}
		}
		return null;
	}

	
	/*-----------------------------------------------------*/
	
	
	public User create(User user) {
		userslist.add(user);
		return user;
	}

	
	/*-----------------------------------------------------*/
	
	
	public String delete(String name) {
		for (User u : userslist) {
			if (u.getName().equals(name)) {
				userslist.remove(u);
				return name;
			}
		}
		return null;
	}

	
	/*-----------------------------------------------------*/
	
	
	public User update(String name, User user) {
		for (User u : userslist) {
			if (u.getName().equals(name)) {
				user.setName(u.getName());
				userslist.remove(u);
				userslist.add(user);
				return user;
			}
		}
		return null;
	}

	
	/*-----------------------------------------------------*/
	
}