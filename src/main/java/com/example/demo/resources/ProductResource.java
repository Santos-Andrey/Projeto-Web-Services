package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Product;
import com.example.demo.services.ProductServices;

@RestController
@RequestMapping(value = "/users")
public class ProductResource {

	@Autowired
	private ProductServices services;
	
	@GetMapping
	public ResponseEntity<List> findAll(){
		List<Product> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
