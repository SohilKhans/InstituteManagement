package com.example.institutemanagementsystem.studentcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.institutemanagementsystem.studentmodel.StudentModel;
import com.example.institutemanagementsystem.studentservice.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping()
	public ResponseEntity<StudentModel> create(@RequestBody StudentModel studentModel) {
		return new ResponseEntity<StudentModel>(studentService.create(studentModel), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentModel> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<StudentModel>(studentService.getById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<StudentModel> update(@PathVariable("id") Long id, @RequestBody StudentModel studentModel) {
		return new ResponseEntity<>(studentService.update(studentModel, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		studentService.delete(id);
		return new ResponseEntity<String>((" Student id deleted successfully"), HttpStatus.OK);
	}
}
