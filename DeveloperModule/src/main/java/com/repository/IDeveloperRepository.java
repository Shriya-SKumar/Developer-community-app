package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Developer;

@Repository
public interface IDeveloperRepository extends JpaRepository<Developer,Integer>{
	 
	 
	@Query("Select d from Developer d where d.devId=:devid")
	Developer fectchDeveloper(int devid);
 	@Query("Select d from Developer d ")
	List<Developer> fetchAllDevelopers();
	//void search();
}
