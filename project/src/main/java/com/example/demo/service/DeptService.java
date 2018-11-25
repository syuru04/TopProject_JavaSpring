package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DeptDao;
import com.example.demo.domain.Org;

@Service
public class DeptService {
	@Autowired
	DeptDao dao;
	
	public Org getOrg() {
		return getOrg(dao.findRoot());
	}

	public Org getOrg(int id) {
		List<Org> sub = new ArrayList<Org>();
		Org org = new Org(id, dao.getName(id), sub);
		for (int subId : dao.findSub(id)) {
			sub.add(getOrg(subId));
		}
		return org;
	}
}