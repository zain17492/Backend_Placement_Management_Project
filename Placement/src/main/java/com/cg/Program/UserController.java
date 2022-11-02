
	package com.cg.Program;

	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

	
	@RestController
	@CrossOrigin("http://localhost:3000")
public class UserController {
	
	
		
		@Autowired
		 private UserRepository userRepository;
		
		@PostMapping("/user")
		 User newuser(@RequestBody User newuser) {
		 return userRepository .save(newuser);
		 
		 }
		 
		 //RESTful API methods for Retrieval operations
		 @GetMapping("/users")
		 List<User> getAllUsers() {
		    return userRepository.findAll();
		 }
		 
		 @GetMapping("/user/{id}")
		  User getUserById(@PathVariable Long id) {
			 
		 
		 return userRepository.findById(id)
				 .orElseThrow(()-> new UserNotFoundException(id));
		 
		 }
		 //RESTful API method for Create operation
		 
		 //RESTful API method for Update operation
		 @PutMapping("/user/{id}")
		 User updateUser(@RequestBody User newuser, @PathVariable Long id) { 
		 
		 return userRepository.findById(id)
				 .map(user-> {
					 user.setUsername(newuser.getUsername());
					 user.setUsertype(newuser.getUsertype());
					 user.setPassword(newuser.getPassword());
			    
			     return userRepository.save(user);
		 }).orElseThrow(() -> new UserNotFoundException(id));
		 
		 }
		 //RESTful API method for Delete operation
		 @DeleteMapping("/user/{id}")
		 String deleteUser(@PathVariable Long id) {
			 if(!userRepository.existsById(id)) {
				 throw new UserNotFoundException(id);
			 }
			 userRepository.deleteById(id);
			 return "User with id "  + id + " has been deleted successfully";
			 
		 }

	
}



