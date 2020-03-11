package com.fizzbuzz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

	@GetMapping(path = "/fizzbuzz")
	public void fizzBussTask() {
		
	}
	
}
