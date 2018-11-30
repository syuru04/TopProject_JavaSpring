package com.example.demo.controller;

import static com.example.demo.controller.Util.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
=======
>>>>>>> c0c0a70ab94467c74cb1d6e2fb46b45a314aa72f
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DocDao;

@CrossOrigin("*")
@RestController
@RequestMapping("/docs")
public class DocController {
	@Autowired
	private DocDao dao;
<<<<<<< HEAD
=======
		
>>>>>>> c0c0a70ab94467c74cb1d6e2fb46b45a314aa72f
	
	@GetMapping
	public Object findAll() {
		return response(dao.findAll());
	}
	
	@PostMapping("/u")
	public Object findByUpinfo(@RequestBody int deptId) {
		return response(dao.findByUpinfo(deptId));
	}
	
}
