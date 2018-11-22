package com.example.demo.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.domain.ServerResponse;


@CrossOrigin("*")
@RestController
@RequestMapping("/emps")
public class EmpController {
	@Autowired
	private EmpDao dao;
	
	@GetMapping
	public Object getAll() {
		List<Emp> emps = dao.findAll();
		ServerResponse message = new ServerResponse(emps);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<ServerResponse>(message, headers, HttpStatus.OK);
	}
	
	@GetMapping("/m/{id}")
	public Object getMembers(@PathVariable int id) {
		List<Emp> emps = dao.findMembers(id);
		ServerResponse message = new ServerResponse(emps);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<ServerResponse>(message, headers, HttpStatus.OK);
	}

	@PostMapping("/c")
	public Object getByCode(@RequestBody String code) {
		System.out.println(code);
		Emp emp = dao.findByCode(code);
		ServerResponse message = new ServerResponse(emp);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<ServerResponse>(message, headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Object getById(@PathVariable int id) {
		Emp emp = dao.findOne(id);
		ServerResponse message = new ServerResponse(emp);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<ServerResponse>(message, headers, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public Object delete(@PathVariable int id) {
		dao.delete(id);
		ServerResponse message = new ServerResponse();
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
	}

	@PostMapping
	public Object insert(@RequestBody Emp emp) {
		dao.insert(emp);
		ServerResponse message = new ServerResponse(emp);
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
	}

	@PutMapping
	public Object update(@RequestBody Emp emp) {
		dao.update(emp);
		ServerResponse message = new ServerResponse(emp);
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
	}
}