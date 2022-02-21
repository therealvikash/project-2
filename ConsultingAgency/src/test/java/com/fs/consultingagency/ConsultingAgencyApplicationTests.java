package com.fs.consultingagency;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fs.consultingagency.dto.CollegeDto;
import com.fs.consultingagency.feignclient.IStudentFeignClient;
import com.fs.consultingagency.vo.College;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ConsultingAgencyApplicationTests 
{
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@MockBean
	private RestTemplate restTemplate;
	
	@MockBean
	private IStudentFeignClient iStudentFeignClient;

	

	@Before
	private void setUp()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void contextLoads() 
	{
		
	}
	
	@Test
	public void getAllCollegeByRestTemplateTest() throws Exception
	{
		CollegeDto[] college = new CollegeDto[2];
		college[0] = new CollegeDto(12,"gda",67);
		college[1] = new CollegeDto(12,"erty",67);
		
		Mockito.when(restTemplate.getForObject("http://localhost:8080/college/viewallcollege", CollegeDto[].class))
		.thenReturn(college);
		
		mockMvc.perform(get("/clz/getallcollege"))
			.andExpect(status().isOk());
			//.andExpect(jsonPath("collegeName[0]", is("gda")));
		
		Assert.assertEquals(college.length, 2);
	
	}

	@Test
	public void getAllCollegeByFeignClient() throws Exception
	{

		List<CollegeDto> college = new ArrayList<CollegeDto>();
		
		CollegeDto college1 = new CollegeDto(123, "udftg", 567);
		CollegeDto college2 = new CollegeDto(124, "tryuj", 654);
		college.add(college2);
		college.add(college1);
		
		when(iStudentFeignClient.getAllCollegeByFeign())
			.thenReturn(college);
		mockMvc.perform(get("/clz/allcollegebyfeign"))
			.andExpect(status().isOk());
			//.andExpect(jsonPath("collegeName[0]", is("gda")));
		
		Assert.assertEquals(college.size(), 2);
		
		
	
	}

	

}
