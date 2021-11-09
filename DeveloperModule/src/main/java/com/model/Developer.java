package com.model;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Email;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="developer")
public class Developer {
	@Id
	@GeneratedValue
	private int devId;
	private String name;
	@Email (message="email address has invalid format:${validatedValue}",
			regexp="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
	@Column(name="email",length=120)
	private String email;
	private String skillLevel;
	private LocalDate memberSince;
	private int totalFeeds;
	private int reputation;
	
	
	  @OneToOne
	  
	  @JoinColumn(name = "userId", referencedColumnName = "userId") 
	  private User users;
	  
	  @OneToMany(mappedBy = "dev")
	  
	  private List<Feeds> feeds;
	 
	 
	 
	 
	private boolean isverified;
	private boolean isblocked;
	public int getDevId() {
		return devId;
	}
	public void setDevId(int devId) {
		this.devId = devId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
	/*
	 * public String getEmail() { return email; } public void setEmail(String email)
	 * { email = email; } public String getSkillLevel() { return skillLevel; }
	 * public void setSkillLevel(String skillLevel) { skillLevel = skillLevel; }
	 */
	public LocalDate getMemberSince() {
		return memberSince;
	}
	public void setMemberSince(LocalDate memberSince) {
		this.memberSince = memberSince;
	}
	public int getTotalFeeds() {
		return totalFeeds;
	}
	public void setTotalFeeds(int totalFeeds) {
		this.totalFeeds = totalFeeds;
	}
	public int getReputation() {
		return reputation;
	}
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}
	
	
	  public User getUsers() { return users; } public void setUsers(User users) {
	  this.users = users; }
	  
	  public List<Feeds> getFeeds() { return feeds; } public void
	  setFeeds(List<Feeds> feeds) { this.feeds = feeds; }
	 
	 
	 
	 
	public boolean isIsverified() {
		return isverified;
	}
	public void setIsverified(boolean isverified) {
		this.isverified = isverified;
	}
	public boolean isIsblocked() {
		return isblocked;
	}
	public void setIsblocked(boolean isblocked) {
		this.isblocked = isblocked;
	}
	@Override
	public String toString() {
		return "Developer [devId=" + devId + ", name=" + name + ", Email=" + email + ", SkillLevel=" + skillLevel
				+ ", memberSince=" + memberSince + ", totalFeeds=" + totalFeeds + ", reputation=" + reputation
				+ ",  isverified=" + isverified + ", isblocked=" + isblocked
				+ "]";
	}
	
}
