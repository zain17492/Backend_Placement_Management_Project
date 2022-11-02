package com.cg.Program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
	@CrossOrigin("http://localhost:3000")
public class StudentController {
	
	
		
		@Autowired
		 private StudentRepository studentRepository;
		
		@PostMapping("/student")
		Student newstudent(@RequestBody Student newstudent) {
		 return studentRepository .save(newstudent);
		 
		 }
		 
		 //RESTful API methods for Retrieval operations
		 @GetMapping("/students")
		 List<Student> getAllStudents() {
		    return studentRepository.findAll();
		 }
		 
		 @GetMapping("/student/{id}")
		 Student getStudentById(@PathVariable Long id) {
			 
		 
		 return studentRepository.findById(id)
				 .orElseThrow(()-> new StudentNotFoundException(id));
		 
		 }
		 
		 
		 //RESTful API method for Update operation
		 @PutMapping("/student/{id}")
		 Student updateStudent(@RequestBody Student newstudent, @PathVariable Long id) { 
		 
		 return studentRepository.findById(id)
				 .map(student-> {
					 student.setStudentname(newstudent.getStudentname());
					 student.setCollegename(newstudent.getCollegename());
					 student.setRollno(newstudent.getRollno());
					 student.setQualification(newstudent.getQualification());
					 student.setCourse(newstudent.getCourse());
					 student.setYear(newstudent.getYear());
					 student.setCertificate(newstudent.getCertificate());
					 student.setHallticketno(newstudent.getHallticketno());
			    
			     return studentRepository.save(student);
		 }).orElseThrow(() -> new StudentNotFoundException(id));
		 
		 }
		 //RESTful API method for Delete operation
		 @DeleteMapping("/student/{id}")
		 String deleteStudent(@PathVariable Long id) {
			 if(!studentRepository.existsById(id)) {
				 throw new StudentNotFoundException(id);
			 }
			 studentRepository.deleteById(id);
			 return "Student with id "  + id + " has been deleted successfully";
			 
		 }

	}




