package com.ehcache.example.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class CommonCacheService {

	final Logger logger = LoggerFactory.getLogger(CommonCacheService.class);
	
	@Autowired
	private CacheManager cacheManager;
	
	public Collection<String> getCacheList() {
		return cacheManager.getCacheNames();
	}
	
	public Boolean isCacheExist(String cacheName) {
		Collection<String> cacheList = getCacheList();
		return (!cacheList.isEmpty() && cacheList.contains(cacheName)) ? Boolean.TRUE : Boolean.FALSE;
	}
	
	public Boolean clearCache(String cacheName) {
		logger.info("clearCache name::  {}", cacheName);
		cacheManager.getCache(cacheName).clear();
		return Boolean.TRUE;
	}
	
	public Boolean clearAllCache() {
		cacheManager.getCacheNames().parallelStream().forEach(name -> {
			logger.info("clearAllCache name::  {}", name);
			cacheManager.getCache(name).clear();
		});
		return Boolean.TRUE;
	}
}
