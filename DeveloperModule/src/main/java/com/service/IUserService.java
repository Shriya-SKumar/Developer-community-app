package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.UserNotFoundException;
import com.model.User;
import com.repository.IUserRepository;
@Service
public class IUserService {
	 @Autowired 
	  IUserRepository repo;
	 public User login(User users) throws UserNotFoundException
	 {
		int id=users.getUserId();
		User c=repo.findByUserId(id);
		String x=Integer.toString(id);
		if (c == null) {
            throw new UserNotFoundException(x);
        }
 
		return users;
		 
	 }
	 public User logOut(User users)
	 {
		return users;		 
	 }

}
