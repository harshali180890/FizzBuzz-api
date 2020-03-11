package com.fizzbuzz.service.impl;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fizzbuzz.service.FizzBuzzService;
import com.fizzbuzz.util.FileGenerator;

/**
 * @author harshali
 * 
 *  FizzBuzzService to print the fizz buzz series
 *
 */
@Component
public class FizzBuzzServiceImpl implements FizzBuzzService {
	
	@Autowired
	private FileGenerator fileGenerator;

	@Override
	public void printFizzBuzz() {
		
		IntStream.rangeClosed(1, 100)
	    .mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i))
	    .forEach(System.out::println);
		
		fileGenerator.generateFile();
	}

}
