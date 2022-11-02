package com.cg.Program;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class College {
	@Id
	@GeneratedValue
	private Long id;
	private String collegeadmin;
	private String collegename;
	private String location;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCollegeadmin() {
		return collegeadmin;
	}
	public void setCollegeadmin(String collegeadmin) {
		this.collegeadmin = collegeadmin;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
