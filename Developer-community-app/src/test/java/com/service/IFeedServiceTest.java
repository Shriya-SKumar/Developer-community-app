package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Developer;
import com.model.Feeds;
import com.model.Response;
//import com.model.User;
import com.repository.IFeedRepository;
@SpringBootTest
class IFeedServiceTest 
{
	@Autowired
	IFeedService feedservice;
	
	@MockBean
	IFeedRepository repo;
	
	@Test
	void testAddFeed() 
	{
		//Feeds f0=new Feeds();
		Feeds f1=new Feeds();
		Feeds f2= new Feeds();
		Developer d1=new Developer();
		Response r1=new Response();
		List<Feeds> f= new ArrayList<>();
		List<Response> r= new ArrayList<>();
		Response r2=new Response();
		r.add(r2);
		r.add(r1);
		f.add(f2);
		f.add(f1);
		//User u1=new User();
		f1.setFeedId(0);
		f1.setFeedDate(null);
		f1.setFeedTime(null);
		f1.setTotalComments(0);
		f1.setQuery("abc");
		f1.setTopic("cloud");
		f1.setRelevance(0);
		f1.setResponses(r);
		f1.setDev(d1);	
		Mockito.when(repo.save(f1)).thenReturn(f1);
		assertThat(feedservice.addFeed(f1)).isEqualTo(f1);
	}

		
	@Test
	void testEditFeed() throws Throwable
	{
		Feeds f1=new Feeds();
		Feeds f2= new Feeds();	
		Response r1=new Response();
		List<Feeds> f= new ArrayList<>();
		List<Response> r= new ArrayList<>();
		Response r2=new Response();
		r.add(r2);
		r.add(r1);
		f.add(f2);
		f.add(f1);
		//User u1=new User();
		f1.setFeedId(0);
		f1.setFeedDate(null);
		f1.setFeedTime(null);
		f1.setTotalComments(0);
		f1.setQuery("abc");
		f1.setTopic("cloud");
		f1.setRelevance(0);
		f1.setResponses(r);
		Optional<Feeds> c2=Optional.of(f1);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		Mockito.when(repo.save(f1)).thenReturn(f1);
		f1.setTopic("react");
		f1.setQuery("select");
		
		assertThat(feedservice.addFeed(f1)).isEqualTo(f1);
	} 
	  @Test 
	  void testGetFeed() throws Throwable 
	  { 
			Feeds f1=new Feeds();
			Feeds f2= new Feeds();
			Response r1=new Response();
			List<Feeds> f= new ArrayList<>();
			List<Response> r= new ArrayList<>();
			Response r2=new Response();
			r.add(r2);
			r.add(r1);
			f.add(f2);
			f.add(f1);
			f1.setFeedId(1);
			f1.setFeedDate(null);
			f1.setFeedTime(null);
			f1.setTotalComments(0);
			f1.setQuery("abc");
			f1.setTopic("cloud");
			f1.setRelevance(1);
			f1.setResponses(r);
			Mockito.when(repo.getById(1)).thenReturn(f1);
			assertThat(feedservice.getFeed(1)).isEqualTo(f1);
	  }
	  @Test void testRemoveFeed() 
	  {
			Feeds f1=new Feeds();
			Feeds f2= new Feeds();
			Response r1=new Response();
			List<Feeds> f= new ArrayList<>();
			List<Response> r= new ArrayList<>();
			Response r2=new Response();
			r.add(r2);
			r.add(r1);
			f.add(f2);
			f.add(f1);
			f1.setFeedId(1);
			f1.setFeedDate(null);
			f1.setFeedTime(null);
			f1.setTotalComments(0);
			f1.setQuery("abc");
			f1.setTopic("cloud");
			f1.setRelevance(0);
			f1.setResponses(r);
			Optional<Feeds> c2=Optional.of(f1);
			
			Mockito.when(repo.findById(1)).thenReturn(c2);
			Mockito.when(repo.existsById(f1.getFeedId())).thenReturn(false);
			assertFalse(repo.existsById(f1.getFeedId()));
		}
	  
	  
	  
	  @Test 
	  void testDeleteFeed() 
	  {
			Feeds f1=new Feeds();
			Feeds f2= new Feeds();
			Response r1=new Response();
			List<Feeds> f= new ArrayList<>();
			List<Response> r= new ArrayList<>();
			Response r2=new Response();
			r.add(r2);
			r.add(r1);
			f.add(f2);
			f.add(f1);
			//User u1=new User();
			f1.setFeedId(1);
			f1.setFeedDate(null);
			f1.setFeedTime(null);
			f1.setTotalComments(0);
			f1.setQuery("abc");
			f1.setTopic("cloud");
			f1.setRelevance(0);
			f1.setResponses(r);
			Optional<Feeds> c2=Optional.of(f1);
			
			Mockito.when(repo.findById(1)).thenReturn(c2);
			Mockito.when(repo.existsById(f1.getFeedId())).thenReturn(false);
			assertFalse(repo.existsById(f1.getFeedId()));
		}
	  @Test 
	  void testGetFeedsByDeveloper()   throws Throwable 
	  {
			Feeds f1=new Feeds();
			Response r1=new Response();
			List<Feeds> f= new ArrayList<>();
			List<Response> r= new ArrayList<>();
			Response r2=new Response();
			r.add(r2);
			r.add(r1);

			//User u1=new User();
			f1.setFeedId(1);
			f1.setFeedDate(null);
			f1.setFeedTime(null);
			f1.setTotalComments(0);
			f1.setQuery("abc");
			f1.setTopic("cloud");
			f1.setRelevance(0);
			f1.setResponses(r);
			f.add(f1);
			Optional<Feeds> c2 = Optional.of(f1);
			Mockito.when(repo.findById(1)).thenReturn(c2);
			assertThat(feedservice.getFeedsByDeveloper(1)).isEqualTo(f);
		}
	  @Test 
	  void testGetFeedsByKeyword() 
	  { 
			Feeds f1=new Feeds();
			Response r1=new Response();
			List<Feeds> f= new ArrayList<>();
			List<Response> r= new ArrayList<>();
			Response r2=new Response();
			r.add(r2);
			r.add(r1);
			f1.setFeedId(1);
			f1.setFeedDate(null);
			f1.setFeedTime(null);
			f1.setTotalComments(0);
			f1.setQuery("abc");
			f1.setTopic("cloud");
			f1.setRelevance(0);
			f1.setResponses(r);
			f1.setKeyword("project");
			f.add(f1);
			Mockito.when(repo.findByKeyword("project")).thenReturn(f);
			assertThat(feedservice.getFeedsByKeyword("project")).isEqualTo(f); 
	  }
	  
	  
	  @Test 
	  void testGetFeedsByTopic() 
	  { 
			Feeds f1=new Feeds();
			//Feeds f2= new Feeds();
			//Developer d1=new Developer();
			Response r1=new Response();
			List<Feeds> f= new ArrayList<>();
			List<Response> r= new ArrayList<>();
			Response r2=new Response();
			r.add(r2);
			r.add(r1);
			f1.setFeedId(1);
			f1.setFeedDate(null);
			f1.setFeedTime(null);
			f1.setTotalComments(0);
			f1.setQuery("abc");
			f1.setTopic("cloud");
			f1.setRelevance(0);
			f1.setResponses(r);			
			f.add(f1);
			Mockito.when(repo.findByTopic("cloud")).thenReturn(f);
			assertThat(feedservice.getFeedsByTopic("cloud")).isEqualTo(f);  
	  }
}
	   


