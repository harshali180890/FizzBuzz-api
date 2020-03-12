package com.fizzbuzz.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fizzbuzz.service.FizzBuzzService;

/**
 * @author harshali
 * FizzBuzzController class
 */
@RestController
public class FizzBuzzController {

	@Autowired
	private FizzBuzzService fizzBuzzService;
	
	/**
	 * @throws IOException
	 */
	@GetMapping(path = "/fizzbuzz")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void fizzBussTask() throws IOException{
		fizzBuzzService.printFizzBuzz();
	}
	
}
