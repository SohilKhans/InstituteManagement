package com.example.institutemanagementsystem.studentservice;

import com.example.institutemanagementsystem.studentmodel.StudentModel;

public interface StudentService {

	StudentModel create(StudentModel studentModel);

	StudentModel getById(Long id);

	StudentModel update(StudentModel studentModel, Long id);

	void delete(Long id);

}
