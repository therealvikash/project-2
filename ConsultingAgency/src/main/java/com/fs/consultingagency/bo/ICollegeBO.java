package com.fs.consultingagency.bo;

import java.util.List;

import com.fs.consultingagency.dto.CollegeDto;

public interface ICollegeBO 
{
	public List<CollegeDto> getUniversityAPI();
	public List<CollegeDto> getCollegeByFeign();

}
