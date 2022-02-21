package com.fs.consultingagency.eo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fs.consultingagency.config.MyConfig;
import com.fs.consultingagency.dto.CollegeDto;
import com.fs.consultingagency.feignclient.IStudentFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Component
@EnableFeignClients(basePackageClasses = IStudentFeignClient.class)
public class ICollegeEOImpl implements ICollegeEO
{

	
	@Autowired
	private MyConfig myConfig;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IStudentFeignClient iStudentFeignClient;
	
	@Override
	public List<CollegeDto> getUniversityAPI()
	{
	CollegeDto[] objects = restTemplate.getForObject(myConfig.getUrl(), CollegeDto[].class);
	return Arrays.asList(objects);
	}
	
	

	@Override
	public List<CollegeDto> getCollegeByFeign() 
	{
//		logger.info(" fetched data in EO by FEIGN CLIENT");

		return iStudentFeignClient.getAllCollegeByFeign();		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
