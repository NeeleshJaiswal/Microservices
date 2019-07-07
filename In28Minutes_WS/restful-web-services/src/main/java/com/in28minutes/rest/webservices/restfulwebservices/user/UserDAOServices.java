package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOServices {
	
	private static List<User> users=new ArrayList<User>();
	
	private static int usersCount=3;
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}
	
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return users;
	}
	
	public User save(User user) {
		// TODO Auto-generated method stub
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findUser(int id) {
		// TODO Auto-generated method stub
		
		for(User user:users) {
			if (user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		// TODO Auto-generated method stub
		Iterator<User> iterator=users.iterator();
		while(iterator.hasNext()) {
			User user=iterator.next();
			if (user.getId()==id) {
				iterator.remove();
			}
		}
		return null;
	}
}
