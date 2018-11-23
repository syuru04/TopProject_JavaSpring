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
	
	@Select("select main.ID, main.NAME, main.CHIEF, emp.NAME as CHIEF_NAME, main.UP_ID , dept.NAME as UP_NAME "
			+ "from dept main "
			+ "left join dept ON dept.ID = main.UP_ID "
			+ "left join emp ON main.CHIEF = emp.ID")
	public List<Dept> findAll();
	
	@Select("select * from dept where up_id=#{id} order by name")
	public List<Dept> findSubs(int id);
	
	@Select("select count(*) from dept")
	public int count();
	
	@Select("select main.ID, main.NAME, main.CHIEF, emp.NAME as CHIEF_NAME, main.UP_ID , dept.NAME as UP_NAME\r\n" 
			+ "from dept main " 
			+ "left join dept ON dept.ID = main.UP_ID " 
			+ "left join emp ON main.CHIEF = emp.ID " 
			+ "where main.id = #{id}")
	public Dept findOne(int id);
}