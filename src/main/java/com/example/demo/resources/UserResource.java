package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.User;
import com.example.demo.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserServices services;
	
	@GetMapping
	public ResponseEntity<List> findAll(){
		List<User> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
