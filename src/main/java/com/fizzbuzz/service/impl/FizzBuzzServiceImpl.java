package com.fizzbuzz.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fizzbuzz.service.FizzBuzzService;
import com.fizzbuzz.util.FileGenerator;

/**
 * @author harshali
 * 
 * FizzBuzzService to print the fizz buzz series
 *
 */
@Component
public class FizzBuzzServiceImpl implements FizzBuzzService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzzServiceImpl.class);
	
	@Value("${fizzbuzz.range.start}")
	private int startRange;
	
	@Value("${fizzbuzz.range.end}")
	private int endRange;
	
	@Autowired
	private FileGenerator fileGenerator;

	/**
	 * @throws IOException
	 * 
	 * Method is responsible to calculate the FizzBuzz result and print result in a file
	 */
	@Override
	public void printFizzBuzz() throws IOException {

		List<Object> result = new ArrayList<>();
		IntStream.rangeClosed(startRange, endRange)
				.mapToObj(item -> item % 3 == 0 ? (item % 5 == 0 ? "FizzBuzz" : "Fizz") : (item % 5 == 0 ? "Buzz" : String.valueOf(item)))
				.forEach(item -> {
					result.add(item);
				});
		
		LOGGER.info("Fizz Buzz result is created.. ready to write in a file");
		
		fileGenerator.generateFile(result);
		
		LOGGER.info("Fizz Buzz result is created in a file");
	}

}
