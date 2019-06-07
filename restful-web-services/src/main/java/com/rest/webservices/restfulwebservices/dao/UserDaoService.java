package com.rest.webservices.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rest.webservices.restfulwebservices.bean.User;

@Repository
public class UserDaoService {
	
	private static List<User> 	users = new ArrayList<>();
	private static int userCount = 3;
	
	static {
		users.add(new User(1,"sachin",new Date()));
		users.add(new User(2,"John",new Date()));
		users.add(new User(3,"megha",new Date()));
		users.add(new User(4,"vivaan",new Date()));
	}

	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user:users) {
		if(user.getId()==id) {
			return user;
		}
		}
		return null;
		
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = (User)iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		return null;
		
	}
	
}
