package com.fizzbuzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fizzbuzz.service.FizzBuzzService;

@RestController
public class FizzBuzzController {

	@Autowired
	private FizzBuzzService fizzBuzzService;
	
	@GetMapping(path = "/fizzbuzz")
	public void fizzBussTask() {
		fizzBuzzService.printFizzBuzz();
	}
	
}
