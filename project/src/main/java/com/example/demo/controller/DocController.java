package com.example.demo.controller;

import static com.example.demo.controller.Util.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DocDao;

@CrossOrigin("*")
@RestController
@RequestMapping("/docs")
public class DocController {
	@Autowired
	private DocDao dao;
		
	
	@GetMapping
	public Object findAll() {
		return response(dao.findAll());
	}
	
}
