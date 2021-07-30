package com.student.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.student.service.entity.Student;
import com.student.service.repository.StudentRepository;
import com.student.service.request.CreateStudentRequest;
import com.student.service.response.StudentResponse;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	WebClient webClient;

//	@Autowired
//	AddressFeignClient addressFeignClient;

	@Autowired
	CommanServices commanServices;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student(createStudentRequest.getFirstName(), createStudentRequest.getLastName(),
				createStudentRequest.getEmail());
		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);

		StudentResponse studentResponse = new StudentResponse(student);
		studentResponse.setAddressResponse(commanServices.getAddressById(student.getAddressId()));
//		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
		return studentResponse;
	}

	public StudentResponse getById(long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		studentResponse.setAddressResponse(commanServices.getAddressById(student.getAddressId()));
//		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
		return studentResponse;
	}

//	@CircuitBreaker(name = "addressService", fallbackMethod = "fallbackGetAddressById")
//	public AddressResponse getAddressById(long addressId) {
//		AddressResponse addressResponse = addressFeignClient.getById(addressId);
//		return addressResponse;
//	}
//
//	public AddressResponse fallbackGetAddressById(long addressId, Throwable th) {
//		return new AddressResponse();
//	}
}
