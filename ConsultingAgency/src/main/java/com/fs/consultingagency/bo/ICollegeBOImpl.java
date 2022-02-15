package com.fs.consultingagency.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fs.consultingagency.dto.CollegeDto;
import com.fs.consultingagency.eo.ICollegeEO;

@Component
public class ICollegeBOImpl implements ICollegeBO
{
	@Autowired
	private ICollegeEO iCollegeEo;

	@Override
	public List<CollegeDto> getUniversityAPI() {
		return iCollegeEo.getUniversityAPI();
	}

	@Override
	public List<CollegeDto> getCollegeByFeign() {
		return iCollegeEo.getCollegeByFeign();
	}



}
