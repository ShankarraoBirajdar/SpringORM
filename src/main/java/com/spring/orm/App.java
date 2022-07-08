package com.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.orm.dao.*;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config/config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
        input(studentDao);
//        Student student = new Student();
//        student.setId(1);
//        student.setName("Shankar");
//        student.setCity("Solapur");
//        
//       int r= studentDao.insert(student);
//       System.out.println("done"+r);
    }
    
    static void input(StudentDao studentDao) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {
			System.out.println("Press 1 for Add New Student");
			System.out.println("Press 2 for Display All Students");
			System.out.println("Press 3 for Get Details of Single Student");
			System.out.println("Press 4 for Update Student Details");
			System.out.println("Press 5 for Delete Student Details");
			System.out.println("Press 6 for Exit");
			try {
				int input = Integer.parseInt(br.readLine());
				switch (input) {

				case 1:
					System.out.println("================insertStudentDetails====================");
					insertStudentDetails(br, studentDao);
					System.out.println("====================================");
					break;
				case 2:
					System.out.println("================printAllStudentDetails====================");
					printAllStudentDetails(studentDao);
					System.out.println("====================================");
					break;
				case 3:
					System.out.println("================printStudentDetails====================");
					printStudentDetails(br, studentDao);
					System.out.println("====================================");
					break;
				case 4:
					System.out.println("================updateStudentDetails====================");
					updateStudentDetails(br, studentDao);
					System.out.println("====================================");
					break;
				case 5:
					System.out.println("=================deleteStudentDetails===================");
					deleteStudentDetails(br, studentDao);
					System.out.println("====================================");
					break;
				case 6:
					go = false;
					break;

				}

			} catch (Exception e) {
				System.out.println("Invalid Input Please Try Again");
				System.out.println(e.getMessage());

			}
		}

		System.out.println("Thank You Using My Console Application");
		System.out.println("See you soon!!");

	}

	static void insertStudentDetails(BufferedReader br, StudentDao studentDao)
			throws NumberFormatException, IOException {
		System.out.println("Enter Student Id");
		int sId = Integer.parseInt(br.readLine());
		System.out.println("Enter Student Name");
		String sName = br.readLine();
		System.out.println("Enter Student City");
		String sCity = br.readLine();
		Student student = new Student(sId, sName, sCity);
		int i = studentDao.insert(student);
		if (i > 0)
			System.out.println(i + " Record inserted");
		else
			System.out.println("Record Not inserted");
	}

	static void updateStudentDetails(BufferedReader br, StudentDao studentDao)
			throws NumberFormatException, IOException {
		System.out.println("Enter Student Id");
		int sId = Integer.parseInt(br.readLine());
		System.out.println("Enter Student Name");
		String sName = br.readLine();
		System.out.println("Enter Student City");
		String sCity = br.readLine();
		Student student = new Student(sId, sName, sCity);
		studentDao.update(student);

	}

	static void deleteStudentDetails(BufferedReader br, StudentDao studentDao)
			throws NumberFormatException, IOException {
		System.out.println("Enter Student Id");
		int sId = Integer.parseInt(br.readLine());
		studentDao.delete(sId);
	}

	static void printStudentDetails(BufferedReader br, StudentDao studentDao)
			throws NumberFormatException, IOException {
		System.out.println("Enter Student Id");
		int sId = Integer.parseInt(br.readLine());
		Student student = studentDao.getStudent(sId);
		System.out.println("Id: " + student.getId());
		System.out.println("Name: " + student.getName());
		System.out.println("City: " + student.getCity());

	}

	static void printAllStudentDetails(StudentDao studentDao) throws NumberFormatException, IOException {

		List<Student> students = studentDao.getAllStudent();
		for (Student student : students) {
			System.out.println("Id: " + student.getId());
			System.out.println("Name: " + student.getName());
			System.out.println("City: " + student.getCity());
		}

	}

}
