package student.service;

import java.util.ArrayList;

import student.entity.Student;

public interface StudentService {
	
	
	boolean save(Student student);
	
	
	boolean update(Student student);
	
	
	boolean remove(int id);
	
	
	ArrayList<Student> findAll();
	
	
	Student findById(int id);
	
	
	ArrayList<Student> findByName(String name);
	
}
