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
import com.model.User;
import com.repository.IDeveloperRepository;

@SpringBootTest
class IDeveloperServiceTest 
{
	@Autowired
	IDeveloperService developerservice;
	@MockBean
	IDeveloperRepository repo;
	
	@Test
	void testGetAllDevelopers()
	{
		Developer d1=new Developer();
		Feeds f1=new Feeds();
		Feeds f2= new Feeds();
		List<Feeds> f= new ArrayList<>();
		f.add(f2);
		f.add(f1);
		User u1=new User();
		d1.setDevId(1);
		d1.setName("mikki");
		d1.setEmail("cba@gmail.com");
		d1.setFeeds(f);
		d1.setIsblocked(false);
		d1.setIsverified(true);
		d1.setMemberSince(null);
		d1.setReputation(0);
		d1.setSkillLevel("0");
		d1.setTotalFeeds(0);
		d1.setUsers(u1);
		Developer d2=new Developer();
		d2.setDevId(7);
		d2.setName("chikki");
		d2.setEmail("bcaa@gmail.com");
		d2.setFeeds(f);
		d2.setIsblocked(false);
		d2.setIsverified(true);
		d2.setMemberSince(null);
		d2.setReputation(0);
		d2.setSkillLevel("0");
		d2.setTotalFeeds(0);
		d2.setUsers(u1);
		List<Developer> d= new ArrayList<>();
		d.add(d2);
		d.add(d1);
		Mockito.when(repo.fetchAllDevelopers()).thenReturn(d);
		assertThat(developerservice.getAllDevelopers()).isEqualTo(d);
	}
	@Test
	void testGetDeveloper() throws Throwable {
		Developer d1=new Developer();
		Feeds f1=new Feeds();
		Feeds f2= new Feeds();
		List<Feeds> f= new ArrayList<>();
		f.add(f2);
		f.add(f1);
		User u1=new User();
		d1.setDevId(1);
		d1.setName("mikki");
		d1.setEmail("cba@gmail.com");
		d1.setFeeds(f);
		d1.setIsblocked(false);
		d1.setIsverified(true);
		d1.setMemberSince(null);
		d1.setReputation(0);
		d1.setSkillLevel("0");
		d1.setTotalFeeds(0);
		d1.setUsers(u1);
		
		Optional<Developer> c2=Optional.of(d1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		assertThat(developerservice.getDeveloper(1)).isEqualTo(d1);
	}
	@Test
	void testAddDeveloper() {
		Developer d1=new Developer();
		Feeds f1=new Feeds();
		Feeds f2= new Feeds();
		List<Feeds> f= new ArrayList<>();
		f.add(f2);
		f.add(f1);
		User u1=new User();
		d1.setDevId(1);
		d1.setName("mikki");
		d1.setEmail("cba@gmail.com");
		d1.setFeeds(f);
		d1.setIsblocked(false);
		d1.setIsverified(true);
		d1.setMemberSince(null);
		d1.setReputation(0);
		d1.setSkillLevel("0");
		d1.setTotalFeeds(0);
		d1.setUsers(u1);
		Mockito.when(repo.save(d1)).thenReturn(d1);
		
		assertThat(developerservice.addDeveloper(d1)).isEqualTo(d1);
	}

	@Test
	void testUpdateDeveloper() throws Throwable {
		
		Developer d1=new Developer();
		Feeds f1=new Feeds();
		Feeds f2= new Feeds();
		List<Feeds> f= new ArrayList<>();
		f.add(f2);
		f.add(f1);
		User u1=new User();
		d1.setDevId(1);
		d1.setName("mikki");
		d1.setEmail("cba@gmail.com");
		d1.setFeeds(f);
		d1.setIsblocked(false);
		d1.setIsverified(true);
		d1.setMemberSince(null);
		d1.setReputation(0);
		d1.setSkillLevel("0");
		d1.setTotalFeeds(0);
		d1.setUsers(u1);
		
		Optional<Developer> c2=Optional.of(d1);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		Mockito.when(repo.save(d1)).thenReturn(d1);
		d1.setName("ooha");
		d1.setEmail("xyz@gmail.com");
		
		assertThat(developerservice.addDeveloper(d1)).isEqualTo(d1);
	}	
}
