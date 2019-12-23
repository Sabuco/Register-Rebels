package com.concatel.restful.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.concatel.restful.exceptions.InvalidRebelException;
import com.concatel.restful.models.Rebel;
import com.concatel.restful.service.RebelServiceImpl;

@RestController
public class RebelController {

	private static final Logger logger = LogManager.getLogger(RebelController.class);
	
	@Autowired
	private RebelServiceImpl rebelService;
	
	@GetMapping("/rebel")
	public List<Rebel> getAllRebel() throws InvalidRebelException{
		try {
			logger.info("Searching all rebels...");
			return rebelService.getAllRebel();
		} catch (Exception ex) {
			logger.error("Could not find any rebel!");
			throw new InvalidRebelException("Failed to find Rebel", ex);
		}
	}
	
	@GetMapping("/rebel/{rebelId}")
	public Rebel getRebelById(@PathVariable int rebelId) throws InvalidRebelException {
		try {
			logger.info("Searching a rebel with id: " + rebelId);
			return rebelService.getRebelById(rebelId);
		} catch (Exception ex) {
			logger.error("Could not find any rebel!");
			throw new InvalidRebelException("Failed to find Rebel", ex);
		}
		
	}
	
	/*
 	Create a new rebel POST and http://localhost:8080/rebel
		{
			"name": "Alvaro Garcia",
			"planet": "Tierra"
		}
	*/
	@PostMapping("/rebel")
	public ResponseEntity<Void> addRebel(@RequestBody Rebel newRebel, UriComponentsBuilder builder) throws InvalidRebelException{
		try {
			logger.info("Creating new register");
			Rebel rebel = rebelService.addRebel(newRebel);
			
			if(rebel == null) {
				logger.warn("Could not register the rebel");
				return ResponseEntity.noContent().build();
			}
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/rebel/{id}").buildAndExpand(rebel.getId()).toUri());
			logger.info("Created new register of the rebel");
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (Exception ex) {
			throw new InvalidRebelException("Rebels registry could not be created", ex);
		}
	}
		
}
