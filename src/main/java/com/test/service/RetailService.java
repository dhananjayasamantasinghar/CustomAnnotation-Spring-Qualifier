package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class RetailService  implements IService{

	@Override
	public String print() {
		System.out.println("Retail Service Called!!");
		return "Retail";
		
	}

}
