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

import com.example.demo.dao.EmpDao;
import com.example.demo.domain.Emp;
import com.example.demo.service.EmpService;

@CrossOrigin("*")
@RestController
@RequestMapping("/emps")
public class EmpController {
	@Autowired
	private EmpDao dao;
	
	@Autowired
	private EmpService service;

	@GetMapping
	public Object findAll() {
		return response(dao.findAll());
	}
	
	@GetMapping("/m/{id}")
	public Object findMembers(@PathVariable int id) {
		return response(service.findMembers(id));
	}

	@PostMapping("/c")
	public Object findByCode(@RequestBody String code) {
		return response(dao.findByCode(code));
	}

	@PostMapping("/pw")
	public Object isPwOk(@RequestBody String[] codePw) {
		return response(service.isPwOk(codePw[0], codePw[1]));
	}

	@GetMapping("/{id}")
	public Object findById(@PathVariable int id) {
		return response(dao.findOne(id));
	}

	@DeleteMapping("/{id}")
	public Object delete(@PathVariable int id) {
		return response(service.delete(id), HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public Object insert(@RequestBody Emp emp) {
		return response(service.insert(emp), HttpStatus.FOUND);
	}

	@PutMapping
	public Object update(@RequestBody Emp emp) {
		System.out.println("# EmpController # update() : " + emp.toString());
		return response(service.update(emp), HttpStatus.CONFLICT);
	}
}