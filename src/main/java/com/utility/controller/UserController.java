package com.utility.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utility.bean.User;
import com.utility.service.UserServic;




@RestController
@RequestMapping(value ="/user")
public class UserController {

	@Autowired
	UserServic userServices;
	
	@RequestMapping(value = "/{name}",method = RequestMethod.GET)
	String checkResource(@PathVariable("name") String name){
		return "Hello "+name; 
	}
	
	
	@RequestMapping(value="/retrieveUser/{user}",method =RequestMethod.GET)
	ResponseEntity<User> getUserResource(@PathVariable("user") int id){
		
		User user = userServices.retrieveResource(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@RequestMapping(value="/addUser",method = RequestMethod.POST)
	ResponseEntity<String> addUserRsource(@RequestBody(required=true) User user){
		userServices.addResource(user);
		return new ResponseEntity<>("User is added",HttpStatus.OK);
	}
	@RequestMapping(value="/deleteUser/{userId}",method = RequestMethod.DELETE)
	ResponseEntity<String> deleteResource(@PathVariable("userId") int id){
		userServices.removeResource(id);
		return new ResponseEntity<>("The user is deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value="/retrieveListUser/{user}",method=RequestMethod.GET)
	ResponseEntity<List<User>> getUserList(@PathVariable("user") int id){
		return new ResponseEntity<List<User>>(userServices.retrieveAuthorisedUser(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/addUser/{userId}",method = RequestMethod.PUT)
	ResponseEntity<String> addAuthUser(@RequestBody(required=true) User user,@RequestParam("id") int id){
		userServices.addAuthorisedUsers(id, user);
		return new ResponseEntity<>("Users are added in List",HttpStatus.OK);
	}
	
	
	
	
}
