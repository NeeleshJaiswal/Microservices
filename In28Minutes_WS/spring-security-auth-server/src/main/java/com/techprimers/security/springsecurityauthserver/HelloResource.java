package com.techprimers.security.springsecurityauthserver;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {
	
	@GetMapping
	public String hello() {
		// TODO Auto-generated method stub
		return "Hello World";
	}
}
