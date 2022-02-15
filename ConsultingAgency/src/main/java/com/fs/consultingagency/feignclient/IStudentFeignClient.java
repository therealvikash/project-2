package com.fs.consultingagency.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.fs.consultingagency.dto.CollegeDto;

@FeignClient(name = "University", url = "http://localhost:8080/college")
public interface IStudentFeignClient 
{
	@GetMapping("/viewallcollege")
	public List<CollegeDto> getAllCollegeByFeign();
}
