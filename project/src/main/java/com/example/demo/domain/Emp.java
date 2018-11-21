package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
	private int id;
	private String nick;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private int deptId;
}