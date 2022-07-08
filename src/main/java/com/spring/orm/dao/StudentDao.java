package com.spring.orm.dao;

import java.util.List;

import com.spring.orm.entities.Student;

public interface StudentDao {
	public int insert(Student student);

	public Student getStudent(int id);

	public List<Student> getAllStudent();

	public void update(Student student);

	public void delete(int id);

}
