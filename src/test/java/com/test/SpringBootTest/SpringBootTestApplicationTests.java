package com.test.SpringBootTest;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.test.controller.TestController;
import com.test.service.IService;
import com.test.util.BusinessService;
import com.test.util.RetailService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootTestApplicationTests {

	@MockBean
	@RetailService
	private IService retailService;
	
	@MockBean
	@BusinessService
	private IService businessService;
	
	@Autowired
	private TestController controller;
	
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@org.junit.Test
	public void forRetail() throws Exception {
		ReflectionTestUtils.setField(controller, "service", retailService);
		Mockito.when(retailService.print()).thenReturn("RETAIL");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/test"))	
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

	
	@org.junit.Test
	public void forBusiness() throws Exception {
		ReflectionTestUtils.setField(controller, "service", businessService);
		Mockito.when(businessService.print()).thenReturn("BUSINESS");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/test"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
