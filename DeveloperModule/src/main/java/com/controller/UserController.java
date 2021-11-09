package com.controller;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping; 
//import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.advices.UserNotFoundException;
//import com.model.Developer;
import com.model.User;
import com.service.IUserService; 
 @RestController
 @RequestMapping(path="/api") 
public class UserController {
	 @Autowired 
	  IUserService userservice;
	 @PostMapping("/login") 
	  public ResponseEntity login(@RequestBody User user) throws UserNotFoundException 
	     { 
		  User c1=userservice.login(user);
		  ResponseEntity re=new ResponseEntity<User>(c1,HttpStatus.OK); 
		  return re; 
		  }
	 @PostMapping("/logout")
	 public ResponseEntity logout(@RequestBody User user)
	 {
		 User c1=userservice.logOut(user);
		 ResponseEntity re=new ResponseEntity<User>(c1,HttpStatus.OK); 
		  return re; 
	 }

}
