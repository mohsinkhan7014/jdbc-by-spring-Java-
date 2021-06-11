package com.springJdbc.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springJdbc.Dao.Entity.Student;

@Component("studentdao")
public class StudentDaoImplement implements StudentDao{
	
	@Autowired
	JdbcTemplate jdbctemplet;

	public JdbcTemplate getJdbctemplet() {
		 
		return jdbctemplet;
	}

	public void setJdbctemplet(JdbcTemplate jdbctemplet) {
		this.jdbctemplet = jdbctemplet;
	}

	public int insert(Student s) {
		// TODO Auto-generated method stub
		 String query="insert into student (id,name,city) values(?,?,?)";
		  int r=this.jdbctemplet.update(query,s.getId(),s.getName(),s.getCity());
		return r;
	}

	public int change(Student s) {
		// update
		String query="update student set name=? ,city=? where id=?";
		return this.jdbctemplet.update(query,s.getName(),s.getCity(),s.getId());
	}

	public int Delete(int id) {
		// delete operation
		String query="delete from student where id=?";
		this.jdbctemplet.update(query,id);
		return 0;
	}

	public Student getStudnetData(int studentId) {
		// selelte singke studnet
		String query="select * from student where id=? ";
		RowMapper<Student> rowMapper=new RawMapperImpl();
		Student studnet=this.jdbctemplet.queryForObject(query, rowMapper,studentId);
		return studnet;
	}

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		String query="Select * from student";
		List<Student> students=this.jdbctemplet.query(query, new RawMapperImpl());
		return students;
	}
	

}
