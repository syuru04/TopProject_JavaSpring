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

import com.example.demo.dao.DeptDao;
import com.example.demo.domain.Dept;
import com.example.demo.domain.ServerResponse;


@CrossOrigin("*")
@RestController
@RequestMapping("/depts")
public class DeptController {
	@Autowired
	private DeptDao dao;
	
	@GetMapping
	public Object get() {
		List<Dept> depts = dao.findAll();
		System.out.println(depts);
		ServerResponse message = new ServerResponse(depts);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<ServerResponse>(message, headers, HttpStatus.OK);
	}

	@PostMapping
	public Object post(@RequestBody Dept dept) {
		dao.insert(dept);
		ServerResponse message = new ServerResponse(dept);
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public Object delete(@PathVariable int id) {
		dao.delete(id);
		ServerResponse message = new ServerResponse();
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
	}

	@PutMapping
	public Object update(@RequestBody Dept dept) {
		dao.update(dept);
		ServerResponse message = new ServerResponse(dept);
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
	}

}
