package com.Demo.Microservices.service;

import com.Demo.Microservices.request.CreateStudentRequest;
import com.Demo.Microservices.response.StudentResponse;

public interface StudentService {

	StudentResponse createStudent(CreateStudentRequest createStudentRequest);

	StudentResponse getById(long id);

}
