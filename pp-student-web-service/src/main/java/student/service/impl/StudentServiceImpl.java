package student.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.entity.Student;
import student.repository.StudentRepository;
import student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public boolean save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public boolean update(Student student) {
		return studentRepository.update(student);
	}

	@Override
	public boolean remove(int id) {
		return studentRepository.remove(id);
	}

	@Override
	public ArrayList<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int id) {
		return studentRepository.findById(id);
	}

	@Override
	public ArrayList<Student> findByName(String name) {
		return studentRepository.findByName(name);
	}

}
