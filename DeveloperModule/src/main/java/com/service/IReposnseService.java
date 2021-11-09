package com.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.*;
import com.model.*;
@Service
public class IReposnseService {
		
		@Autowired
		IResponseRepository repo;

	public Response addResponse(Response resp)
	
 {
		repo.save(resp);
		return resp; 
	}
		
	public Response editResponse(Response resp) throws Throwable{
		

		int id=resp.getRespId();
		//Supplier s1= ()->new ResourceNotFoundException("Feed Does not exist in the database");
	Response r1=repo.findById(id).orElseThrow();
	r1.setAccuracy(r1.getAccuracy());
	r1.setDev(r1.getDev());
	r1.setFeed(r1.getFeed());
	r1.setRespDate(r1.getRespDate());
	//r1.setRespId(r1.);
		r1.setAnswer(r1.getAnswer());
		repo.save(r1);
		return r1;
	}
		public Response deleteResponseById(int respid)
		
		{
			Response r1=repo.getById(respid);
			repo.deleteById(respid);
			return r1;
		}
		public List<Response> getDeveloper(int devId) 
		  { 
			Response r= repo.findById(devId).orElseThrow();
			  List<Response> r1= new ArrayList<>(); 
			  r1.add(r);
			  return r1;
		  
		  }
		public List<Response>getFeed(int feedId) 
		  { 
			 // List<Response> r1=(List<Response>) repo.findById(feedId).orElseThrow(); 
			Response r= repo.findById(feedId).orElseThrow();
			  List<Response> r1= new ArrayList<>(); 
			  r1.add(r);  
			return r1;
		  
		  }
			
			/*
			 * public Response LikeFeed(int respid) { Response resp=repo.getById(respid);
			 * int counter = resp.g; resp.setCounter(counter+1); return resp;
			 * 
			 * }
			 */
			 
	}

