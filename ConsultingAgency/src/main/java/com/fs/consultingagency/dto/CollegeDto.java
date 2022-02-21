package com.fs.consultingagency.dto;

public class CollegeDto 
{
	private int collegeId;
	private String collegeName;
	private int noOfStudents;
	
	
	
	
	public CollegeDto() {
		//super();
	}
	public CollegeDto(int collegeId, String collegeName, int noOfStudents) 
	{
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.noOfStudents = noOfStudents;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

}
