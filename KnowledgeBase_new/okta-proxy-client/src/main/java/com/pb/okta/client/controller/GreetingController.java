package com.pb.okta.client.controller;

import java.security.Principal;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pb.okta.client.domain.Greeting;

@RestController
public class GreetingController {

	private static final String template = "Hello %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping(path = "/greeting")
	public Greeting getGreeting(@RequestParam String name) {

		return new Greeting(counter.getAndIncrement(), String.format(template, name));

	}
	
	/*@GetMapping("/")
	public String echoTheUsersEmailAddress(Principal principal) {
	   return "Hey there! Your email address is: " + principal.getName();
	}*/

}
