package com.example.greeting;

import org.springframework.stereotype.Component;

@Component
public class GreetingComponent {
	
	public String getMessage() {
		return "Hellow from GreetingComponent!";
	}
}
