package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Emp;

@Mapper
public interface EmpDao {
	
	@Insert("insert into emp(code,pw,name,phone,email,dept_id) values(#{e.code},#{pw},#{e.name},#{e.phone},#{e.email},#{e.deptId})")
	@SelectKey(statement="select LAST_INSERT_ID()", before=false, keyProperty="e.id", resultType=Integer.class)
	public int insert(@Param("e") Emp emp, @Param("pw") byte[] pw);
	
	public int update(@Param("e") Emp emp, @Param("pw") byte[] pw);
	
	@Delete("delete from emp where id=#{id}")
	public int delete(int empno);
	
	@Update("update dept set chief = null where chief = #{id}")
	public int deleteChief(int id);
	
	public List<Emp> findAll();
	
	public Emp findOne(int id);
	
	@Select("select id,name,code,phone,email from emp where dept_id=#{id} order by name")
	public List<Emp> findMembers(int id);
	
	@Select("select count(*) from emp")
	public int count();
	
	@Select("select * from emp where code = #{code}")
	public Emp findByCode(String code);
	
	@Select("select pw from emp where code = #{code}")
	public Object findPw(String code);
}