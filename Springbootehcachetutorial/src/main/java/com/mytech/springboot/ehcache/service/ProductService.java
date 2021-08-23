package com.mytech.springboot.ehcache.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mytech.springboot.ehcache.dao.ProductRepo;
import com.mytech.springboot.ehcache.model.Product;

/**
 * @author Brajesh Pandey
 *
 */
@Service
public class ProductService {
	@Autowired
	private ProductRepo prepo;

	@Cacheable(value = "productsCache")
	public List<Product> getProducts() {
		return prepo.findAll();
	}

	/**
	 * Method to fetch product details on the basis of product id.
	 * 
	 * @param productId
	 * @return
	 */
	// @Cacheable annotation adds the caching behaviour.
	// If multiple requests are received, then the method won't be repeatedly
	// executed, instead, the results are shared from cached storage.
	@Cacheable(value = "productsCache", key = "#p0")
	public Optional<Product> getProductById(int productId) {
		return prepo.findById(productId);
	}

	/**
	 * Method to update product on the basis of product id.
	 * 
	 * @param product
	 * @param productName
	 * @return
	 */
	// @CachePut annotation updates the cached value.
	@CachePut(value = "productsCache")
	public Product updateProductById(Product product, String productName) {
		product.setName(productName);
		prepo.save(product);

		return product;
	}

	/**
	 * Method to delete product on the basis of product id.
	 * 
	 * @param ticketId
	 */
	// @CacheEvict annotation removes one or all entries from cached storage.
	// <code>allEntries=true</code> attribute allows developers to purge all entries
	// from the cache.
	@CacheEvict(value = "productsCache", key = "#p0")
	public void deleteProductById(int productId) {
		prepo.deleteById(productId);
	}
}