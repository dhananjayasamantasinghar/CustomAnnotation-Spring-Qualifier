package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class BusinessService implements IService{

	@Override
	public String  print() {
		System.out.println("Business Service Called!!");
		return "Business";
	}

}
