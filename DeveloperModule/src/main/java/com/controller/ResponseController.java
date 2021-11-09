package com.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.*;
import com.service.*;
@RestController
@RequestMapping(path="/api")
public class ResponseController {
			@Autowired
			IReposnseService responseservice;
		@PostMapping("/addResponse")	
		public ResponseEntity<Response>addResponse(@RequestBody Response r1)
		{
		  Response feed1=responseservice.addResponse(r1);
		  ResponseEntity re=new
		  ResponseEntity<Response>(feed1,HttpStatus.OK);
		  
		return re;
		}
		@PutMapping("/editresponse")
		public ResponseEntity<Response>editResponse(@RequestBody Response r1) throws Throwable
		{
			Response r2=(Response) responseservice.editResponse(r1);
			ResponseEntity re=new
					ResponseEntity<Response>(r2,HttpStatus.OK);
			return re;
			
		}
		@DeleteMapping("/Deleteresponse")
		public ResponseEntity<Response> deleteResponse(@RequestBody int respid) 
		{
			Response r2=(Response) responseservice.deleteResponseById(respid);
			ResponseEntity re=new
					ResponseEntity<Response>(r2,HttpStatus.OK);
			return re;
			
		}
		@PostMapping("/GetFeed")
		public ResponseEntity<Response> getFeed(@RequestBody int feedid) 
		{
			List<Response> r2= responseservice.getFeed(feedid);
			ResponseEntity re=new
					ResponseEntity<Response>(HttpStatus.OK);
			return re;
			
		}
		@PostMapping("/GetDeveloper")
		public ResponseEntity<Response> getDeveloper(@RequestBody int devid) 
		{
			List<Response> r2= responseservice.getDeveloper(devid);
			ResponseEntity re=new
					ResponseEntity<Response>(HttpStatus.OK);
			return re;
			
		}
		/*
		 * @PostMapping("/GetDeveloper") public
		 * ResponseEntity<Response>GetDeveloper(@RequestBody int devid) { List<Response>
		 * r2= responseservice.getDeveloper(devid); ResponseEntity re=new
		 * ResponseEntity<Response>(HttpStatus.OK); return re;
		 * 
		 * }
		 */
		

		}
