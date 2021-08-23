package com.mytech.springboot.ehcache.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mytech.springboot.ehcache.model.Product;
import com.mytech.springboot.ehcache.service.ProductService;

/**
 * @author Brajesh Pandey
 *
 */
@RestController
@RequestMapping(value = "/api/product")
public class Productcontroller {
	@Autowired
	private ProductService pserv;

	
	@GetMapping("/")
	public List<Product> getProducts(){
		return pserv.getProducts();
	}
	
	/**
	 * Method to fetch product details on the basis of product id.
	 * 
	 * @param productId
	 * @return
	 */
	@GetMapping(value = "/{product-id}")
	@ResponseBody
	public ResponseEntity<Product> getProductById(@PathVariable("product-id") int productId) {
		Optional<Product> product = pserv.getProductById(productId);
		if (!product.isPresent())
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
	}

	/**
	 * Method to update product on the basis of product id.
	 * 
	 * @param productId
	 * @param productName
	 * @return
	 */
	@PutMapping(value = "/{product-id}/{product-name}")
	public ResponseEntity<Product> updateTicketById(@PathVariable("product-id") int productId,
			@PathVariable("product-name") String productName) {
		Optional<Product> product = pserv.getProductById(productId);
		if (!product.isPresent())
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Product>(pserv.updateProductById(product.get(), productName), HttpStatus.OK);
	}

	/**
	 * Method to delete product on the basis of product id.
	 * 
	 * @param productId
	 */
	@DeleteMapping(value = "/{product-id}")
	public ResponseEntity<Product> deleteProductById(@PathVariable("product-id") int productId) {
		Optional<Product> product = pserv.getProductById(productId);
		if (!product.isPresent())
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);

		pserv.deleteProductById(productId);
		return new ResponseEntity<Product>(HttpStatus.ACCEPTED);
	}
}