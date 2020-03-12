package com.fizzbuzz.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * @author harshali
 * 
 * FileGeneratorTest
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class FileGeneratorTest {
	
	@InjectMocks
	private FileGenerator fileGenerator;
	private String filePath = "test.txt";

	/**
	 *  Initialization of the class variables
	 */
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(this.fileGenerator, "filePath", this.filePath);
	}
	
	/**
	 * @throws IOException
	 * Test Case to check the generate File functionality
	 */
	@Test
	public void test_generateFile() throws IOException {
		
		List<Object> data = new ArrayList<>();
		data.add("1");
		data.add("2");
		data.add("Fizz");
		data.add("4");
		data.add("Buzz");
		fileGenerator.generateFile(data);
	}
	
}
