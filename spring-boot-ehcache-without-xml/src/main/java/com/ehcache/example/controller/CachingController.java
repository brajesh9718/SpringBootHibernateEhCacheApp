package com.ehcache.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ehcache.example.service.CommonCacheService;

@RestController
@RequestMapping("/v1/caching")
public class CachingController {

	
	private Logger log = LoggerFactory.getLogger(CachingController.class);
	
	@Autowired
	private CommonCacheService commonCacheService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ResponseEntity<Object> list(){
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("cachingList", commonCacheService.getCacheList());
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}
	
	@RequestMapping(value="/clear/{name}",method=RequestMethod.GET)
	public ResponseEntity<Object> clear(@PathVariable String name){
		log.info("clear name:> {}",name);
		Map<String, Object> resultMap = new HashMap<>();
		if(commonCacheService.isCacheExist(name)) {
			resultMap.put("cachingUpdate", commonCacheService.clearCache(name));
		}else {
			resultMap.put("cachingUpdate", Boolean.FALSE);	
		}
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}

}
