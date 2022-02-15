package com.fs.consultingagency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.consultingagency.bo.ICollegeBO;
import com.fs.consultingagency.mapper.ICollegeMapper;
import com.fs.consultingagency.vo.College;

@Service
public class ICollegeServiceImpl implements ICollegeService
{
	
	@Autowired
	private ICollegeMapper iCollegeMapper;
	
	@Autowired
	private ICollegeBO iCollegeBO;

	@Override
	public List<College> getUniversityAPI() 
	{
		// TODO Auto-generated method stub
		return iCollegeMapper.dtoToEntity(iCollegeBO.getUniversityAPI());
	}



	@Override
	public List<College> getCollegeByFeign() 
	{
		return iCollegeMapper.dtoToEntity(iCollegeBO.getCollegeByFeign());
	}

}
