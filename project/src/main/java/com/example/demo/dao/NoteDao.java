package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.example.demo.domain.Note;

@Mapper
public interface NoteDao {
	
	@Insert("insert into note(title,body,author,stamp) values(#{title},#{body},#{author},#{stamp})")
	@SelectKey(statement="select LAST_INSERT_ID()", before=false, keyProperty="id", resultType=Integer.class)
	public int insert(Note note);
	
	public int update(Note note);
	
	@Delete("delete from note where id=#{id}")
	public int delete(int empno);
	
	@Select("select note.ID, note.TITLE, note.STAMP ,emp.name from note left join emp ON emp.ID = note.AUTHOR;")
	public List<Note> findAll();
	
	@Select("select * from note where dept_id=#{id} order by name")
	public List<Note> findMembers(String title);
	
	@Select("select count(*) from Note")
	public int count();
	
	@Select("select * from Note where id = #{id}")
	public Note findOne(int id);
	
	@Select("select * from Note where code = #{title}")
	public Note findByTitle(String title);
}