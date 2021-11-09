
  package com.service;
  
  import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service;

import com.advices.UnknownDeveloperException;
import com.model.Developer; import com.repository.IDeveloperRepository;
  
  @Service 
  public class IDeveloperService {
  
  @Autowired 
  IDeveloperRepository repo; 
  public Developer addDeveloper(Developer dev) 
  { 
	  repo.save(dev);
	  return dev;
  } 
  public Developer updateDeveloper(Developer dev) throws Throwable
  { 
  int id=dev.getDevId(); 
  Supplier s1= ()->new UnknownDeveloperException("Developer Does not exist in the database");
  Developer d=repo.findById(id).orElseThrow(s1);
 //Developer d= repo.updateDeveloper(id);
	
	  d.setName(dev.getName()); d.setEmail(dev.getEmail());
	  d.setSkillLevel(dev.getSkillLevel());
	  
	  d.setMemberSince(dev.getMemberSince()); d.setReputation(dev.getReputation());
	 // d.setTotalFeeds(dev.getTotalFeeds()); d.setFeeds(dev.getFeeds());
	  //d.setUser(dev.getUser()); 
	  d.setIsblocked(dev.isIsblocked());
	  d.setIsverified(dev.isIsverified());
	 
  repo.save(d); 
  return d; 
  } 
  public Developer getDeveloper(int devId) 
  { 
	  Developer c=repo.findById(devId).orElseThrow(); 
	  return c;
  
  } 
  public List<Developer> getAllDevelopers() 
  { 
	  List<Developer> lc1=repo.fetchAllDevelopers();
  return lc1; 
  }
  
  
  
  }
 