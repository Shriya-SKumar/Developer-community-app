package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.advices.UserNotFoundException;
import com.model.User;
import com.repository.IUserRepository;

@SpringBootTest
class IUserServiceTest {
	@Autowired
	IUserService userservice;
	
	@MockBean
	IUserRepository repo;

	@Test
	void testLogin() throws UserNotFoundException {
		User u1= new User();
		u1.setUserId(1);
		u1.setUsername("nikki");
		u1.setPassword("xyz@123");
		u1.setRole("kaali");
		//User c2=(u1);
		Mockito.when(repo.findByUserId(1)).thenReturn(u1);
		assertThat(userservice.login(u1)).isEqualTo(u1);
	}

	
	  @Test 
	  void testLogOut() 
	  {   
		  User u1= new User();
			u1.setUserId(1);
			u1.setUsername("nikki");
			u1.setPassword("xyz@123");
			u1.setRole("kaali");
			//System.out.println(u1);
			//User c2=(u1);
			//Mockito.when(repo.findByUserId(1)).thenReturn(c2);
			//assertThat(userservice.login(u1)).isEqualTo(u1);
			//Mockito.when(repo.l).thenReturn(d);
			assertThat(userservice.logOut(u1)).isEqualTo(u1);
	  }
	 
}
