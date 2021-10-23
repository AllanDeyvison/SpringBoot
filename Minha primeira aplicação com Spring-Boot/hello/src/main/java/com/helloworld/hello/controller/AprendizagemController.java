package com.helloworld.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/aprendizagem")
public class AprendizagemController {
	
	@GetMapping
	public String aprendizagem() {
		return "Spring Boot ";
	}
	
	

}
