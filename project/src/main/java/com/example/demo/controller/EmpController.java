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
	public Object get() {
		List<Emp> emps = dao.findAll();
		System.out.println(emps);
		ServerResponse message = new ServerResponse(emps);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<ServerResponse>(message, headers, HttpStatus.OK);
	}

	@PostMapping
	public Object post(@RequestBody Emp emp) {
		dao.insert(emp);
		ServerResponse message = new ServerResponse(emp);
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public Object delete(@PathVariable int id) {
		dao.delete(id);
		ServerResponse message = new ServerResponse();
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
	}

	@PutMapping
	public Object update(@RequestBody Emp emp) {
		dao.update(emp);
		ServerResponse message = new ServerResponse(emp);
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
	}
}
