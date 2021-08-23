package com.ehcache.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehcache.example.entity.Country;

public interface CountryDao extends JpaRepository<Country, Long>{

}
