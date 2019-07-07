package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private UserDAOServices services;
	
	
	@GetMapping(path = "/users")
	private List<User> retriveAllUsers() {
		// TODO Auto-generated method stub
		return services.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	private User retriveUser(@PathVariable int id) {
		// TODO Auto-generated method stub
		User user=services.findUser(id);
		
		if (user==null) {
			throw new UserNotFoundException("Id "+id);
		}
		
		//HATEOAS
		//Retrieve All user
		//"all-users", SERVER_PATH + "/users"
		
		return user;
	}
	
	@DeleteMapping(path = "/users/{id}")
	private void deleteUser(@PathVariable int id) {
		// TODO Auto-generated method stub
		User user=services.deleteById(id);
		
		if (user==null) {
			throw new UserNotFoundException("Id "+id);
		}
		
	}
	
	
	@PostMapping(path = "/users")
	private ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		// TODO Auto-generated method stub
		User saveUser=services.save(user);
		
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/").buildAndExpand(saveUser.getId()).toUri();
		
		return  (ResponseEntity<Object>) ResponseEntity.created(location);
	}
}
