package com.ehcache.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.ehcache.example.entity.Country;
import com.ehcache.example.service.CountryService;

@SpringBootApplication
public class SpringBootEhcacheWithoutXmlApplication implements ApplicationListener<ContextRefreshedEvent>{

	final Logger logger = LoggerFactory.getLogger(SpringBootEhcacheWithoutXmlApplication.class);
	
	@Autowired
	private CountryService countryService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEhcacheWithoutXmlApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("***************");
		
		if(countryService.getCount() == 0) {
			initData();
		}
	}
	
	private void initData() {
		Country country1 = new Country();
		country1.setName("Australia");
		countryService.save(country1);
		
		Country country2 = new Country();
		country2.setName("Brazil");
		countryService.save(country2);
		
		Country country3 = new Country();
		country3.setName("Canada");
		countryService.save(country3);
		
		Country country4 = new Country();
		country4.setName("Denmark");
		countryService.save(country4);
		
		Country country5 = new Country();
		country5.setName("Egypt");
		countryService.save(country5);
	}
}
