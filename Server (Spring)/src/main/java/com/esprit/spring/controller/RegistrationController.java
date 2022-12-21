package com.esprit.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Registration.RegistrationRequest;
import com.esprit.spring.services.RegistrationService;

import lombok.AllArgsConstructor;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {
	
	 private final RegistrationService registrationService;

	    @PostMapping
	    @ResponseBody
	    public String register(@RequestBody RegistrationRequest request) {
	        return registrationService.register(request);
	    }
	     
	    @GetMapping(path = "confirm")
	    @ResponseBody  // se fait à travers le mail  
	    public String confirm(@RequestParam("token") String token) {
	        return registrationService.confirmToken(token);
	    }

}