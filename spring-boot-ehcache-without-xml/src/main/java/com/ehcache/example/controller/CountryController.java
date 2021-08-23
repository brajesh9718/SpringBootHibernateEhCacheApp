package com.ehcache.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ehcache.example.entity.Country;
import com.ehcache.example.service.CountryService;

@RestController
@RequestMapping("/v1/country")
public class CountryController {

	final Logger logger = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ResponseEntity<Object> list(){
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("countryList", countryService.list());
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody Country country){
		Map<String, Object> resultMap = new HashMap<>();
		logger.info("create:> {} ",country);
		resultMap.put("country", countryService.save(country));
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}
}
