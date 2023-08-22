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
import com.repository.IResponseRepository;

@SpringBootTest
class IReposnseServiceTest 
{
	@Autowired
	IReposnseService responseservice;
	
	@MockBean
	IResponseRepository repo;
	
	@Test
	void testAddResponse() {
		Response r = new Response();
		r.setRespId(1);
		r.setRespTime(null);
		r.setRespDate(null);
		r.setAnswer("hello");
		r.setAccuracy(3);
		Developer d= new Developer();
		Feeds f= new Feeds();
		r.setDev(d);
		r.setFeed(f);
		Mockito.when(repo.save(r)).thenReturn(r);	
		assertThat(responseservice.addResponse(r)).isEqualTo(r);
	}

	@Test
	void testEditResponse() throws Throwable 
	{
		Response r = new Response();
		r.setRespId(1);
		r.setRespTime(null);
		r.setRespDate(null);
		r.setAnswer("hello");
		r.setAccuracy(3);
		Developer d= new Developer();
		Feeds f= new Feeds();
		r.setDev(d);
		r.setFeed(f);
		Optional<Response> c2=Optional.of(r);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		Mockito.when(repo.save(r)).thenReturn(r);
		r.setAccuracy(2);
		r.setAnswer("hii");
		assertThat(responseservice.editResponse(r)).isEqualTo(r);
		
	}	  
	@Test
	void testDeleteResponseById() 
	{
		Response r=new Response();
		r.setRespId(1);
		r.setRespTime(null);
		r.setRespDate(null);
		r.setAnswer(null);
		r.setAccuracy(3);
		Developer d=new Developer();
		Feeds f=new Feeds();
		r.setDev(d);
		r.setFeed(f);
		Optional<Response>c2=Optional.of(r);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		Mockito.when(repo.existsById(r.getRespId())).thenReturn(false);
		r.setAccuracy(2);
		r.setAnswer("hii");
		assertFalse(repo.existsById(r.getRespId()));
	}
	@Test
	void testGetDeveloper() 
	{
		Response r = new Response();
		r.setRespId(1);
		r.setRespTime(null);
		r.setRespDate(null);
		r.setAnswer("hello");
		r.setAccuracy(3);
		Developer d= new Developer();
		Feeds f= new Feeds();
		r.setDev(d);
		r.setFeed(f);
		List<Response> r2= new ArrayList<>();
		r2.add(r);
		int id=d.getDevId();
		Optional<Response> c2=Optional.of(r);
		Mockito.when(repo.findById(id)).thenReturn(c2);
		Mockito.when(repo.saveAll(r2)).thenReturn(r2);
		assertThat(responseservice.getDeveloper(id)).isEqualTo(r2);
	}
	@Test 
	void testGetFeed() 
	{ 
		Response r = new Response();
		r.setRespId(1);
		r.setRespTime(null);
		r.setRespDate(null);
		r.setAnswer("hello");
		r.setAccuracy(3);
		Developer d= new Developer();
		Feeds f= new Feeds();
		r.setDev(d);
		r.setFeed(f);
		List<Response> r2= new ArrayList<>();
		r2.add(r);
		int id=f.getFeedId();
		Optional<Response> c2=Optional.of(r);
		Mockito.when(repo.findById(id)).thenReturn(c2);
		Mockito.when(repo.saveAll(r2)).thenReturn(r2);
		assertThat(responseservice.getDeveloper(id)).isEqualTo(r2);
	} 
}
