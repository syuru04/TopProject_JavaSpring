package com.example.demo.controller;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class Util {
	private static final HttpHeaders HEADERS = new HttpHeaders();
	{
		HEADERS.setContentType(new MediaType("text", "json", Charset.forName("UTF-8")));
	}
	
	public static <T> Object response(T object) {
		return new ResponseEntity<T>(object, HEADERS, HttpStatus.OK);
	}
	
	public static Object response(int rowsAffected, HttpStatus errorStatus) {
		return new ResponseEntity<Object>(rowsAffected == 1 ? HttpStatus.OK : errorStatus);
	}
}