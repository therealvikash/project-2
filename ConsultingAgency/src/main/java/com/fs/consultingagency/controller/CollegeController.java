package com.fs.consultingagency.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fs.consultingagency.service.ICollegeService;
import com.fs.consultingagency.vo.College;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import com.fs.consultingagency.controller.CollegeController;


@RestController
@RequestMapping("/clz")
public class CollegeController 
{
	Logger logger = LoggerFactory.getLogger(CollegeController.class);
	
	public static final String UNIVERSITY_SERVICE_BY_REST_TEMPLATE = "getAllCollegeFallbackByRestTemplate";

	private static final String UNIVERSITY_SERVICE_BY_FEIGN = "getAllCollegeFallbackByFeign";
	
	@Autowired
	private ICollegeService iCollegeService;
	
//	@GetMapping(value = "/allcollegelist")
//	public ResponseEntity<College> getData()
//	{
//		CollegeDto getData = iCollegeService.getUniversityAPI();
//		
//		//iCollegeMapper.entityToDto(restTemplate.getForObject("http://localhost:8080/college/viewallcollege",College.class));
//		logger.info("API Called!!!");
//		return new ResponseEntity<CollegeDto>(HttpStatus.OK);
//		ResponseEntity<College> customerWithId = new ResponseEntity<College>(iCollegeMapper.dtoToEntity(iCollegeService.getUniversityAPI()),HttpStatus.OK);
//		logger.info("Customer With Id displayed");
//		return customerWithId;
//		
//	}

//	@GetMapping("/getAllEmployees-restTemplate")
//	public List<College> getUniversityAPI() {
//		College[] emp = restTemplate.getForObject("http://localhost:8080/employee/getAllEmployee",
//				College[].class);
//		return Arrays.asList(emp);
//	
//	}
	
	@GetMapping("/getallcollegebyresttemplate")
	@CircuitBreaker(name=UNIVERSITY_SERVICE_BY_REST_TEMPLATE, fallbackMethod = "getAllCollegeFallbackByRestTemplate")
	public ResponseEntity<List<College>> getUniversityAPI() 
	{
		List<College> list = iCollegeService.getUniversityAPI();
		return new ResponseEntity<List<College>>(list, HttpStatus.OK);
	}
	
	public ResponseEntity<String> getAllCollegeFallbackByRestTemplate(Exception e)
	{
		return new ResponseEntity<String>("University service down while fetching by rest template!!!", HttpStatus.OK);
		
	}
	
	@GetMapping("/allcollegebyfeign")
	@CircuitBreaker(name=UNIVERSITY_SERVICE_BY_FEIGN, fallbackMethod = "getAllCollegeFallbackByFeign")
	public ResponseEntity<List<College>> getCollegeByFeign()
	{
		List<College> allCollege = iCollegeService.getCollegeByFeign();
		return new ResponseEntity<List<College>>(allCollege, HttpStatus.OK);
	}
	
	public ResponseEntity<String> getAllCollegeFallbackByFeign(Exception e)
	{
		return new ResponseEntity<String>("University service down while fetching by feign client!!!", HttpStatus.OK);
		
	}

}
