package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DeptDao;
import com.example.demo.domain.Dept;

@Service
public class DeptService {
	@Autowired
	DeptDao dao;
	
	public Dept getOrg() {
		return getOrg(dao.findRoot());
	}

	public Dept getOrg(int id) {
		Dept dept = dao.findOne(id);
		List<Dept> sub = new ArrayList<Dept>();
		for (int subId : dao.findSub(id)) {
			sub.add(getOrg(subId));
		}
		dept.setSub(sub);
		return dept;
	}
}