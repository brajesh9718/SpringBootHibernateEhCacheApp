package com.ehcache.example.service;

import java.util.List;

import com.ehcache.example.entity.Country;

public interface CountryService {

	public long getCount();
	
	public Country save(Country country);
	
	public List<Country> list();
}
