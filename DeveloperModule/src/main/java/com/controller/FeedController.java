package com.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.advices.UnknownFeedException;
import com.model.Feeds;
import com.service.IFeedService;

	@RestController
	@RequestMapping(path="/api")

	public class FeedController {
		@Autowired
		IFeedService feedservice;
	@PostMapping("/addFeed")	
	public ResponseEntity<Feeds>addFeed(@RequestBody Feeds feed)
	{
	  Feeds feed1=feedservice.addFeed(feed);
	  ResponseEntity re=new ResponseEntity<Feeds>(feed1,HttpStatus.OK);
	  
	return re;
	}
	@PostMapping("/editFeed")
	public ResponseEntity<Feeds>editFeed(@RequestBody Feeds feed)
	{
		Feeds feed1=(Feeds) feedservice.editFeed(feed);
		ResponseEntity re=new
				ResponseEntity<Feeds>(feed1,HttpStatus.OK);
		return re;
		
	}

	@PostMapping("/getFeedsBykeyword") 
	public ResponseEntity<List<Feeds>>getFeedsBykeyword(String keyword) 
	{ 
		List<Feeds>lfeed1=feedservice.getFeedsByKeyword(keyword);
	  ResponseEntity re=new ResponseEntity<List<Feeds>>(lfeed1,HttpStatus.OK);
	  return re;
	  
	  }
	  @PostMapping("/likefeed") 
	  public ResponseEntity<List<Feeds>> likeFeed(int respId) throws UnknownFeedException { 
		  int id=respId;
	  Feeds lfeed1=feedservice.likeFeed(id);
	  ResponseEntity re=new ResponseEntity(lfeed1,HttpStatus.OK);
	  return re;
	  
	  }
	  @PostMapping("/getFeedsByTopic") public
	  ResponseEntity<List<Feeds>>getFeedsByTopic(String topic) { 
		  String top=topic;
	  List<Feeds>lfeed1=feedservice.getFeedsByTopic(top); ResponseEntity re=new
	  ResponseEntity<List<Feeds>>(lfeed1,HttpStatus.OK); return re; }
	  
	 	
	}


