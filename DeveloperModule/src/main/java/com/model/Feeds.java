package com.model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="feeds")
public class Feeds {
		@Id
		@GeneratedValue
		private int feedId;
		private String query;
		private LocalDate feedDate;
		@DateTimeFormat(pattern = "HH:mm", iso = ISO.DATE_TIME)
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
		private LocalTime feedTime;
		private String topic;	// Programming/Java/Testing
		private int relevance;
		private String keyword;
		// Likes on Feed increase relevance

		  public String getKeyword() {
			return keyword;
		}
		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
		@ManyToOne
		  
		  @JoinColumn(name = "devId", referencedColumnName = "devId") private Developer
		  dev;
		  
		  @OneToMany(mappedBy = "feed") 
		  private List<Response> responses;
		private int totalComments;
	public int getFeedId() {
		return feedId;
	}
	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public LocalDate getFeedDate() {
		return feedDate;
	}
	public void setFeedDate(LocalDate feedDate) {
		this.feedDate = feedDate;
	}
	public LocalTime getFeedTime() {
		return feedTime;
	}
	public void setFeedTime(LocalTime feedTime) {
		this.feedTime = feedTime;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getRelevance() {
		return relevance;
	}
	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}
	
	
	
	  public Developer getDev() { return dev; } public void setDev(Developer dev) {
	  this.dev = dev; }
	  
	  
	  public List<Response> getResponses() { return responses; } public void
	  setResponses(List<Response> responses) { this.responses = responses; }
	 
	 
	 
	 
	public int getTotalComments() {
		return totalComments;
	}
	public void setTotalComments(int totalComments) {
		this.totalComments = totalComments;
	}
	@Override
	public String toString() {
		return "Feed [feedId=" + feedId + ", query=" + query + ", feedDate=" + feedDate + ", feedTime=" + feedTime
				+ ", topic=" + topic + ", relevance=" + relevance + ", totalComments=" + totalComments + "]";
	}



	}


