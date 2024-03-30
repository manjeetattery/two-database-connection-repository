package com.javatpoint.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.dto.StudentDTO;
import com.javatpoint.model1.Student;
import com.javatpoint.repository1.StudentRepository;

//defining the business logic
@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

//getting all student records
	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<Student>();
		studentRepository.findAll().forEach(student -> students.add(student));
		return students;
	}

//getting a specific record
	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();
	}

	public void saveOrUpdate(Student student) {
		studentRepository.save(student);
	}

//deleting a specific record
	public void delete(int id) {
		studentRepository.deleteById(id);
	}

	public void saveData(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		Student stu = new Student();
		stu.setId(studentDTO.getId());
		stu.setAge(studentDTO.getAge());
		stu.setEmail(studentDTO.getEmail());
		stu.setName(studentDTO.getName());
		studentRepository.save(stu);
		

	}
}