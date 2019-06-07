package com.rest.webservices.restfulwebservices;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rest.webservices.restfulwebservices.bean.User;
import com.rest.webservices.restfulwebservices.dao.UserDaoService;
import com.rest.webservices.restwebservices.exception.UserNotFoundException;

@RestController
public class UserResource {
 
	
	@Autowired
	UserDaoService userService;
	
	
	
	//Retrieve all users
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userService.findAll();
	
	}
	
	//Retrieve single User
	@GetMapping("/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		User user = userService.findOne(id);
		if(user==null) {
				throw new UserNotFoundException("id- " + id);
		}
		
		Resource<User> resource = new Resource<User>(user);
			
			resource.add(linkTo(methodOn(this.getClass()).retrieveAllUsers()).withRel("all-users"));
			return resource;
	
	}
	
	
	
	
	
	//Create User
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		URI location =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//Create User
		@DeleteMapping("/users/{id}")
		public void deleteUser(@PathVariable int id) {
			User deleteUser = userService.deleteById(id);
			if(deleteUser==null) {
				throw new UserNotFoundException("id- " + id);
			
		}
		}
	
	
	
}
