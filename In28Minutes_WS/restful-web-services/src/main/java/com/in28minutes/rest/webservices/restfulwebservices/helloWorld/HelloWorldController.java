package com.in28minutes.rest.webservices.restfulwebservices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(method=RequestMethod.GET, path = "/hello-world")
	//or for GET mapping
	//@GetMapping(path = "/hello-world")
	private String helloWorld() {
		// TODO Auto-generated method stub
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	private HelloWorldBean helloWorldBean() {
		// TODO Auto-generated method stub
		return new HelloWorldBean("Hell0-world-bean");
	}
	
	//hello-world/path-variable/in28minute
	@GetMapping(path="/hello-world/path-variable/{name}")
	private HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		// TODO Auto-generated method stub
		return new HelloWorldBean(String.format("Hell0-world, %s",name));
	}
}
