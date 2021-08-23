package com.ehcache.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ehcache.example.dao.CountryDao;
import com.ehcache.example.entity.Country;

@Service
public class CountryServiceImpl implements CountryService {
	
	final Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);
	
	@Autowired
	private CountryDao countryDao;

	@Override
	public long getCount() {
		long count = countryDao.count();
		logger.info("getCount:> {} ",count);
		return count;
	}

	@Override
	public Country save(Country country) {
		logger.info("save:> {} ",country);
		return countryDao.save(country);
	}

	@Cacheable("countryListCache")
	@Override
	public List<Country> list() {
		logger.info("list called... ");
		return countryDao.findAll();
	}

}
