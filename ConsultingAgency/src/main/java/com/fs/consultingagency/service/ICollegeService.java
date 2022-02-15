package com.fs.consultingagency.service;

import java.util.List;

import com.fs.consultingagency.vo.College;

public interface ICollegeService 
{	
	public List<College> getUniversityAPI();
	public List<College> getCollegeByFeign();
}
