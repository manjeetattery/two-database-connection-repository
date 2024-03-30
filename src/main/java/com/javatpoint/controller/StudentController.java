package com.javatpoint.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.dto.StudentDTO;
import com.javatpoint.model1.Student;
import com.javatpoint.service.StudentService;
//creating RestController
@RestController
public class StudentController 
{
//autowired the StudentService class
@Autowired
StudentService studentService;
//creating a get mapping that retrieves all the students detail from the database 
@GetMapping("/student")
private String getAllStudent() {
	return "jatin kumar";
	
}

@PostMapping("/save-data")
private String saveData(@RequestBody StudentDTO studentDTO) {
	studentService.saveData(studentDTO);
	return "SAVE DATA";
	
}
}
