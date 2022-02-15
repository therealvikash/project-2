package com.fs.consultingagency.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.fs.consultingagency.dto.CollegeDto;
import com.fs.consultingagency.vo.College;
import com.fs.consultingagency.mapper.ICollegeMapper;

@Mapper
public interface ICollegeMapper 
{
	ICollegeMapper INSTANCE = Mappers.getMapper(ICollegeMapper.class);

	List<College> dtoToEntity(List<CollegeDto> collegeDto);
}
