package com.example.institutemanagementsystem.studentservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.institutemanagementsystem.ResourceNotFoundException.ResourceNotFoundException;
import com.example.institutemanagementsystem.studententity.StudentEntity;
import com.example.institutemanagementsystem.studentmodel.StudentModel;
import com.example.institutemanagementsystem.studentrepository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentModel create(StudentModel studentModel) {
		StudentEntity entities = new StudentEntity();
		entities.setId(studentModel.getId());
		entities.setName(studentModel.getName());
		entities.setLastName(studentModel.getLastName());
		entities.setAge(studentModel.getAge());
		entities.setCity(studentModel.getCity());
		entities.setCourseName(studentModel.getCourseName());
		entities.setEmail(studentModel.getEmail());
		entities.setAddress(studentModel.getAddress());
		studentRepository.save(entities);
		studentModel.setId(entities.getId());
		return studentModel;

	}

	@Override
	public StudentModel getById(Long id) {
		Optional<StudentEntity> entity = studentRepository.findById(id);
		StudentModel model = null;
		if (entity.isPresent()) {
			model = new StudentModel();
			model.setName(entity.get().getName());
			model.setLastName(entity.get().getLastName());
			model.setCity(entity.get().getCity());
			model.setAge(entity.get().getAge());
			model.setAddress(entity.get().getAddress());
			model.setCourseName(entity.get().getCourseName());
			model.setEmail(entity.get().getEmail());

		} else {
			throw new ResourceNotFoundException("student", "model", model);
		}
		return model;

	}

	@Override
	public StudentModel update(StudentModel studentModel, Long id) {
		StudentEntity entity = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("StudentModel", "id", id));
		entity.setName(studentModel.getName());
		entity.setLastName(studentModel.getLastName());
		entity.setAge(studentModel.getAge());
		entity.setAddress(studentModel.getAddress());
		entity.setCourseName(studentModel.getCourseName());
		entity.setEmail(studentModel.getEmail());
		studentRepository.save(entity);
		studentModel.setId(entity.getId());
		return studentModel;
	}

	@Override
	public void delete(Long id) {
		studentRepository.findById(id);
		studentRepository.deleteById(id);
	}

}
