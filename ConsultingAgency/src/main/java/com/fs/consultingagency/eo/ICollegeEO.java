package com.fs.consultingagency.eo;


import java.util.List;

import com.fs.consultingagency.dto.CollegeDto;


public interface ICollegeEO 
{
	public List<CollegeDto> getUniversityAPI();
	public List<CollegeDto> getCollegeByFeign();
}
