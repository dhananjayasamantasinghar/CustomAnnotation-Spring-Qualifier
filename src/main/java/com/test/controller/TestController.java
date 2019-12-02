package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.IService;
import com.test.util.RetailService;

@RestController
public class TestController {
	
	@RetailService
	private IService service;
	
	@GetMapping("/test")
	public void test(){
		String print = service.print();
		System.out.println(print);
	}

}
