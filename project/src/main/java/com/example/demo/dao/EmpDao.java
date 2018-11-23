package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.example.demo.domain.Emp;

@Mapper
public interface EmpDao {
	
	@Insert("insert into emp(code,pw,name,phone,email,dept_id) values(#{code},#{pw},#{name},#{phone},#{email},#{deptId})")
	@SelectKey(statement="select LAST_INSERT_ID()", before=false, keyProperty="id", resultType=Integer.class)
	public int insert(Emp emp);
	
	public int update(Emp emp);
	
	@Delete("delete from emp where id=#{id}")
	public int delete(int empno);
	
	@Select("select emp.id, emp.CODE,emp.NAME,emp.PHONE,emp.EMAIL,dept.NAME as DEPT_NAME FROM emp left join dept ON dept.ID = emp.DEPT_ID order by dept.id,emp.id;")
	public List<Emp> findAll();
	
	@Select("select * from emp where dept_id=#{id} order by name")
	public List<Emp> findMembers(int id);
	
	@Select("select count(*) from emp")
	public int count();
	
	@Select("select * from emp where id = #{id}")
	public Emp findOne(int id);
	
	@Select("select * from emp where code = #{code}")
	public Emp findByCode(String coded);
}