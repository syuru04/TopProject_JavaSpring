package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.example.demo.domain.Dept;

@Mapper
public interface DeptDao {
	
	@Insert("insert into dept(name, up_id) values(#{name}, #{upId})")
	@SelectKey(statement="select LAST_INSERT_ID()", before=false, keyProperty="id", resultType=Integer.class)
	public int insert(Dept dept);
	
	public int update(Dept dept);
	
	@Delete("delete from dept where id=#{id}")
	public int delete(int id);
	
	@Select("select * from dept order by id")
	public List<Dept> findAll();
	
	@Select("select count(*) from dept")
	public int count();
	
	@Select("select * from dept where id = #{id}")
	public Dept findOne(int id);
}