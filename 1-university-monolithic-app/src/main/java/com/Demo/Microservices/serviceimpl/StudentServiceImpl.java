package com.Demo.Microservices.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Demo.Microservices.model.Address;
import com.Demo.Microservices.model.Student;
import com.Demo.Microservices.repository.StudentRepository;
import com.Demo.Microservices.request.CreateStudentRequest;
import com.Demo.Microservices.response.StudentResponse;
import com.Demo.Microservices.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Address address = new Address(createStudentRequest.getStreet(), createStudentRequest.getCity());
		Student student = new Student(createStudentRequest.getFirstName(), createStudentRequest.getLastName(),
				createStudentRequest.getEmail());
		student.setAddress(address);
		student = studentRepository.save(student);

		return new StudentResponse(student);
	}

	@Override
	public StudentResponse getById(long id) {
		return new StudentResponse(studentRepository.findById(id).get());
	}

}
