package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.model.Developer;
import com.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User,String> {
	
	User findByUserId(int id);

}
