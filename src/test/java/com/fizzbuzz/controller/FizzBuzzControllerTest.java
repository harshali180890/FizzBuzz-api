package com.fizzbuzz.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fizzbuzz.service.FizzBuzzService;

/**
 * @author harshali
 * FizzBuzzControllerTest
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@WebMvcTest( FizzBuzzController.class)
@WebAppConfiguration
public class FizzBuzzControllerTest {
	
	public static final String GET_URL = "/fizzbuzz";
	public static final String INVALID_GET_URL = "/app/fizzbuzz";
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private FizzBuzzController fizzBuzzController;
	
	@Mock
	private FizzBuzzService fizzBuzzService;

	/**
	 * Initialization of the class variables
	 */
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.fizzBuzzController).build();
		ReflectionTestUtils.setField(this.fizzBuzzController, "fizzBuzzService", this.fizzBuzzService);
	}
	
	/**
	 * @throws Exception
	 * Test case to check the success scenario
	 */
	@Test
	public void test_checkSuccessResponse() throws Exception {
		mockMvc.perform(get(GET_URL)).andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
	}
	
	/**
	 * @throws Exception
	 * Test case to check the Error scenario
	 */
	@Test
	public void test_checkInvalidResponse() throws Exception {
		mockMvc.perform(get(INVALID_GET_URL)).andExpect(MockMvcResultMatchers.status().isNotFound()).andReturn();
	}


}
