package com.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="responses")
public class Response {
	@Id
	@GeneratedValue
	private int respId;
		private String answer;
		private LocalDate respDate;
		/*
		 * private int counter=0; public int getCounter() { return counter; } public
		 * void setCounter(int counter) { this.counter = counter; }
		 */
    	@DateTimeFormat(pattern = "HH:mm", iso = ISO.DATE_TIME)
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
		private LocalTime respTime;
		private int accuracy;	// Likes on Response increase accuracy
		
		  @OneToOne
		  
		  @JoinColumn(name = "devId", referencedColumnName = "devId") private Developer
		  dev;
		  
		  @ManyToOne
		  
		  @JoinColumn(name = "feedId", referencedColumnName = "feedId") private Feeds
		  feed;
	public int getRespId() {
				return respId;
			}
			public void setRespId(int respId) {
				this.respId = respId;
			}
			public String getAnswer() {
				return answer;
			}
			public void setAnswer(String answer) {
				this.answer = answer;
			}
			public LocalDate getRespDate() {
				return respDate;
			}
			public void setRespDate(LocalDate respDate) {
				this.respDate = respDate;
			}
			public LocalTime getRespTime() {
				return respTime;
			}
			public void setRespTime(LocalTime respTime) {
				this.respTime = respTime;
			}
			public int getAccuracy() {
				return accuracy;
			}
			public void setAccuracy(int accuracy) {
				this.accuracy = accuracy;
			}

			
			
			
			  public Developer getDev() { return dev; } public void setDev(Developer dev) {
			  
			  this.dev = dev; } public Feeds getFeed() { return feed; } public void
			  setFeed(Feeds feed) { this.feed = feed; }
			 
			 
			 
			 
			@Override
			public String toString() {
				return "Response [answer=" + answer + ", respDate=" + respDate + ", respTime=" + respTime + ", accuracy="
						+ accuracy + ", respId=" + respId + "]";
			}
			
			
	

}
