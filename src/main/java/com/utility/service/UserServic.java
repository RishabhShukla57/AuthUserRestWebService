package com.utility.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utility.bean.User;



@Service
public class UserServic{

	@Autowired
	User user;
	HashMap<Integer, User> users = new HashMap<>();
	HashMap<Integer,List<User>> authorisedUsers = new HashMap<>();
	
	public void addResource(User user){
		int id =users.size()+1;
		users.put(id,user);
	}
	
	public void removeResource(int id){
		users.remove(id);
	}
	
	public User retrieveResource(int id){
			return users.get(id);
	}
	
	public List<User> retrieveAuthorisedUser(int id ){
		return authorisedUsers.get(id);
	}
	
	public void addAuthorisedUsers(int id,User user){
		if(authorisedUsers.containsKey(id)){
			List<User> aUser = authorisedUsers.get(id);
			aUser.add(user);
			authorisedUsers.put(id,aUser);
		}else{
			List<User> authUser = new ArrayList<>();
			authUser.add(user);
			authorisedUsers.put(id, authUser);
		}
	}
	
}
