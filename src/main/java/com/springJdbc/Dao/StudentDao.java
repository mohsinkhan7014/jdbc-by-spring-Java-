package com.springJdbc.Dao;

import java.util.List;

import com.springJdbc.Dao.Entity.Student;

public interface StudentDao {
	public int insert(Student s);
	public int change(Student s);
	public int Delete(int s);
	public Student getStudnetData(int studentId);
	public List<Student> getAllStudent();

}
