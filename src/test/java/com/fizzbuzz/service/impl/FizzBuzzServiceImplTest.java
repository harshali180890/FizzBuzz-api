package com.fizzbuzz.service.impl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.fizzbuzz.util.FileGenerator;

/**
 * @author harshali
 * 
 * FizzBuzzServiceImplTest
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzServiceImplTest {

	@InjectMocks
	private FizzBuzzServiceImpl fizzBuzzServiceImpl;
	
	@Mock
	private FileGenerator fileGenerator;
	
	private int startRange=1;
	
	private int endRange=100;
	
	/**
	 *  Initialization of the class variables
	 */
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(this.fizzBuzzServiceImpl, "fileGenerator", this.fileGenerator);
		ReflectionTestUtils.setField(this.fizzBuzzServiceImpl, "startRange", this.startRange);
		ReflectionTestUtils.setField(this.fizzBuzzServiceImpl, "endRange", this.endRange);
	}
	
	/**
	 * @throws IOException
	 * Test case to check success scenario for FizzBuzz
	 */
	@Test
	public void test_printFizzBuzz_success() throws IOException {
		
		Mockito.doNothing().when(this.fileGenerator).generateFile(Mockito.any());
		fizzBuzzServiceImpl.printFizzBuzz();
		verify(this.fileGenerator, times(1)).generateFile(Mockito.any());
		
	}	

	/**
	 * @throws IOException
	 * Test case to check error scenario for FizzBuzz
	 */
	@Test(expected = IOException.class)
	public void test_printFizzBuzz_Error() throws IOException {
		
		Mockito.doThrow(new IOException()).when(this.fileGenerator).generateFile(Mockito.any());
		fizzBuzzServiceImpl.printFizzBuzz();
		verify(this.fileGenerator, times(1)).generateFile(Mockito.any());
		
	}

}
