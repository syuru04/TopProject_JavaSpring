package com.example.demo.service;

import static com.example.demo.service.Util.encrypt;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmpDao;
import com.example.demo.domain.Emp;

@Service
public class EmpService {
	@Autowired
	EmpDao dao;

	public boolean isPwOk(String code, String pw) {
		return Arrays.equals((byte[]) dao.findPw(code), encrypt(pw));
	}

	public int insert(Emp emp) {
		return dao.insert(emp, encrypt(emp.getPw()));
	}

	public int update(Emp emp) {
		String pw = emp.getPw();
		return dao.update(emp, pw == null || pw.isEmpty() ? null : encrypt(pw));
	}
}