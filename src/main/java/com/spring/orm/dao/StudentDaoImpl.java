package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;


import com.spring.orm.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private HibernateTemplate hibernateTemplate;

	
	@Transactional
	public int insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

	public Student getStudent(int id) {
		Student student = this.hibernateTemplate.get(Student.class,id);
		return student;
	}

	public List<Student> getAllStudent() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}

	@Transactional
	public void update(Student student) {
		this.hibernateTemplate.update(student);
	}

	@Transactional
	public void delete(int id) {
		 Student student = this.hibernateTemplate.get(Student.class,id);
		 this.hibernateTemplate.delete(student);
	}
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


}
