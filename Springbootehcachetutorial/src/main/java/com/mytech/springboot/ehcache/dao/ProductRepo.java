package com.mytech.springboot.ehcache.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytech.springboot.ehcache.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}