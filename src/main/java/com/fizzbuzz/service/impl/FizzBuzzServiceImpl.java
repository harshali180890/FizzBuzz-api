package com.fizzbuzz.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fizzbuzz.service.FizzBuzzService;
import com.fizzbuzz.util.FileGenerator;

/**
 * @author harshali
 * 
 *         FizzBuzzService to print the fizz buzz series
 *
 */
@Component
public class FizzBuzzServiceImpl implements FizzBuzzService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzzServiceImpl.class);
	@Autowired
	private FileGenerator fileGenerator;

	@Override
	public void printFizzBuzz() throws IOException {

		List<String> result = new ArrayList<>();
		IntStream.rangeClosed(1, 100)
				.mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : String.valueOf(i)))
				.forEach(item -> {
					result.add(item);
				});
		fileGenerator.generateFile(result);
	}

}
