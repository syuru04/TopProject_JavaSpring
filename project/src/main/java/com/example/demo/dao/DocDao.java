package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Doc;

@Mapper
public interface DocDao {

	public List<Doc> findAll();

}
