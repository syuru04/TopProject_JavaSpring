package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
	private int id;
	private String title;
	private String body;
	private String author;
	private String name;
	private String stamp;
	
}

