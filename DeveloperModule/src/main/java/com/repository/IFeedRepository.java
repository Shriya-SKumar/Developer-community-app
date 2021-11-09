package com.repository;


	import java.util.List;

	  import org.springframework.data.jpa.repository.JpaRepository;
	  import org.springframework.data.jpa.repository.Query;
	  import org.springframework.stereotype.Repository;

import com.model.Feeds;
	  @Repository
	  public interface IFeedRepository extends JpaRepository<Feeds,Integer>{

		List<Feeds> findByTopic(String topic);

		List<Feeds> findByKeyword(String keyword);

		//List<Feeds> search(String keyword);
	  	
}
