package com.example.greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	//define a variable of type GreetingComponent without initialization
	private GreetingComponent gc;
	
	//initialize gc by injection within constructor
	public GreetingController(GreetingComponent g) {
		gc = g;
	}
	
	
	// http://localhost:8080/greeting
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	// http://localhost:8080/testcomponent
	//define a method to test GreetingComponent
	@GetMapping("/testcomponent")
	public ResponseEntity<String> getMessage(){
		return ResponseEntity.ok(gc.getMessage());
	}
}
