package com.example.demo.controller;

import static com.example.demo.controller.Util.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DocDao;
import com.example.demo.domain.Emp;
import com.example.demo.service.DocService;

@CrossOrigin("*")
@RestController
@RequestMapping("/docs")
public class DocController {
	@Autowired
	private DocDao dao;
	
	@Autowired
	private DocService service;
	
	@GetMapping
	public Object findAll() {
		return response(dao.findAll());
	}
	
}
