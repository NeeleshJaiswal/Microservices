package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	private SomeBean someBean() {
		// TODO Auto-generated method stub
		System.out.println("Filtering");
		return new SomeBean("Value1","Value2","Value3");
	}
}
