
  package com.controller;
  
  import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
import com.model.Developer; 
import com.service.IDeveloperService; 
  @RestController
  @RequestMapping(path="/api") 
  public class DeveloperController {
  @Autowired 
  IDeveloperService developerservice;
  
  @PostMapping("/addDeveloper") 
  public Developer addDeveloper(@RequestBody Developer dev) 
     { 
	  Developer c1=developerservice.addDeveloper(dev);
	  //ResponseEntity re=new ResponseEntity<Developer>(c1,HttpStatus.OK); 
	  return c1; 
	  }
  
  @PutMapping(path="/updateDeveloper") 
  public ResponseEntity<Developer> updateDeveloper(@RequestBody Developer e) throws Throwable 
  { 
  Developer e1=developerservice.updateDeveloper(e); 
  ResponseEntity re=new ResponseEntity<Developer>(e1,HttpStatus.OK);
  return re;
  }
 
  @PostMapping(path="/getDeveloper")
  public Developer getdeveloper(@RequestBody int id)
  {
	  Developer d= developerservice.getDeveloper(id);
	  return d;
  }
  @GetMapping(path="/getAllDevelopers")
  public List<Developer> getalldevelopers()
  {
	  List<Developer> d= developerservice.getAllDevelopers();
	  return d;
  }
  
  
  }
 