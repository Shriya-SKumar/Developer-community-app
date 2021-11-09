package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.UnknownDeveloperException;
import com.advices.UnknownFeedException;
import com.model.Feeds;
import com.model.Response;
import com.repository.IFeedRepository;

	

	@Service
	public class IFeedService {
		@Autowired
		IFeedRepository repo;
		
	public  Feeds addFeed(Feeds feed)
	{
		 repo.save(feed);
		 return feed;

	}
	public Feeds editFeed(Feeds feed)
	{
		int id=feed.getFeedId();
		//Supplier s1= ()->new ResourceNotFoundException("Feed Does not exist in the database");
	Feeds r1=repo.findById(id).orElseThrow();
	r1.setDev(r1.getDev());
	r1.setFeedDate(r1.getFeedDate());
	r1.setFeedTime(r1.getFeedTime());
	r1.setKeyword(r1.getKeyword());
	r1.setQuery(r1.getQuery());
	r1.setTopic(r1.getTopic());
	r1.setRelevance(r1.getRelevance());
	r1.setResponses(r1.getResponses());
	r1.setTotalComments(r1.getTotalComments());
		repo.save(r1);
		return r1;
	}


	 public Feeds likeFeed(int feedId) throws UnknownFeedException { 
		 Feeds feed=repo.getById(feedId);
		 int c=feed.getRelevance();
		 //System.out.println(c);
		 feed.setRelevance(c+1);
		 
		 //System.out.println(feed.getRelevance());
		 return feed; 
		  } 
	  
	public  Feeds getFeed(int feedId) throws UnknownFeedException {
		Feeds feed=repo.getById(feedId);
		return feed ;
		
		  
	  
	  }
	 
	 public Feeds removeFeed(int feedId) throws UnknownFeedException {
	Feeds feed=repo.getById(feedId);
			repo.deleteById(feedId);
			return feed;
			
	 }
	 public Feeds deleteFeed(Feeds feed) {
		 int id=feed.getFeedId();
		 Feeds feed1=repo.getById(id);	
			repo.delete(feed);
			return feed1;
		}

		 public List<Feeds>getFeedsByDeveloper(int devId)throws UnknownDeveloperException {
			 Feeds f=repo.findById(devId).orElseThrow();
			 List<Feeds>feed= new ArrayList<>() ;
			 feed.add(f);
			return feed;
			 
		 }

			
			  public List<Feeds>getFeedsByKeyword(String keyword)
			  { 
				  if(keyword!=null)
				  {
			  return repo.findByKeyword(keyword); 
			  } 
				  return repo.findAll(); 
				  }
			 
		  public List<Feeds>getFeedsByTopic(String topic) {
		  List<Feeds>lfeed1=repo.findByTopic(topic); 
		  return lfeed1; 
		  }
		 
	}


