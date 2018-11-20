package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Dept;

@Mapper
public interface EmpDao {
	
	@Insert("insert into dept(name, up_id) values(#{name}, #{upId}")
	@SelectKey(statement="select LAST_INSERT_ID()", before=false, keyProperty="id", resultType=Integer.class)
	public int insert(Dept dept);
	
	@Update("update dept set name=#{name}, up_id=#{upId}, chief=#{chief} where id=#{id}")
	public int update(Dept dept);
	
	@Delete("delete from dept where id=#{id}")
	public int delete(int id);
	
	@Select("select * from dept order by id")
	public List<Dept> findAll();
	
	@Select("select count(*) from dept")
	public int count();
	
	@Select("select * from dept where id = #{id}")
	public Dept findOne(int id);

/*	
	@Insert("insert into emp(ename, job, sal) values(#{ename}, #{job}, #{sal})")
	@SelectKey(statement="select LAST_INSERT_ID()", before=false, keyProperty="empno", resultType=Integer.class)
	public int insert(Emp emp);
	
	@Update("update emp set ename=#{ename}, job=#{job}, sal=#{sal} where empno=#{empno}")
	public int update(Emp emp);
	
	@Delete("delete from emp where empno=#{empno}")
	public int delete(int empno);
	
	// 마이바티스가 제공하는 애노테이션으로 사용할 SQL을 설정할 수 있다.
	@Select("select * from emp order by empno asc")
	public List<Emp> findAll();
	
	@Select("select count(*) from emp")
	public int count();
	
	@Select("select * from emp where empno = #{empno}")
	public Emp findOne(int empno);
*/
}