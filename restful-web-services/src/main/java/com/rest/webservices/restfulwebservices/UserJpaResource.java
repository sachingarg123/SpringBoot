package com.rest.webservices.restfulwebservices;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.restfulwebservices.bean.Post;
import com.rest.webservices.restfulwebservices.bean.User;
import com.rest.webservices.restfulwebservices.dao.PostJpaRepository;
import com.rest.webservices.restfulwebservices.dao.UserJpaRepository;
import com.rest.webservices.restwebservices.exception.UserNotFoundException;

@RestController
public class UserJpaResource {
 
	
	@Autowired
	UserJpaRepository userRepository;
	
	@Autowired
	PostJpaRepository postRepository;
	
	
	
	//Retrieve all users
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	
	}
	
	//Retrieve single User
	@GetMapping("/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
				throw new UserNotFoundException("id- " + id);
		}
		
		Resource<User> resource = new Resource<User>(user.get());
			
			resource.add(linkTo(methodOn(this.getClass()).retrieveAllUsers()).withRel("all-users"));
			return resource;
	
	}
	
	
	
	
	
	//Create User
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//Create User
		@DeleteMapping("/jpa//users/{id}")
		public void deleteUser(@PathVariable int id) {
			userRepository.deleteById(id);
			
		}
	
	 //Get All Post of a User
		@GetMapping("/jpa/users/{id}/posts")
		public List<Post> retrieveAllUsers(@PathVariable int id){
			Optional<User> user  = userRepository.findById(id);
			if(!user.isPresent()) {
				throw new UserNotFoundException("id- " + id);
			}
			
			return user.get().getPosts();
			
		
		}
		
		//Create Post
		@PostMapping("/jpa/users/{id}/posts")
		public ResponseEntity<Object> createUser(@PathVariable int id, @RequestBody Post post) {
			Optional<User> userOptional  = userRepository.findById(id);
			if(!userOptional.isPresent()) {
				throw new UserNotFoundException("id- " + id);
			}
			User user = userOptional.get();
			post.setUser(user);
			postRepository.save(post);
			URI location =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
			return ResponseEntity.created(location).build();
		}
	
}
