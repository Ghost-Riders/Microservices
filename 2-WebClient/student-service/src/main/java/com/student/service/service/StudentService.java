package com.student.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.student.service.entity.Student;
import com.student.service.repository.StudentRepository;
import com.student.service.request.CreateStudentRequest;
import com.student.service.response.AddressResponse;
import com.student.service.response.StudentResponse;

import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	WebClient webClient;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student(createStudentRequest.getFirstName(), createStudentRequest.getLastName(),
				createStudentRequest.getEmail());
		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);
		
		StudentResponse studentResponse = new StudentResponse(student);
		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		return studentResponse;
	}

	public StudentResponse getById(long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		return studentResponse;
	}

	public AddressResponse getAddressById(long addressId) {
		Mono<AddressResponse> addressResponse = webClient.get().uri("/getById/" + addressId).retrieve()
				.bodyToMono(AddressResponse.class);
		return addressResponse.block();
	}
}
