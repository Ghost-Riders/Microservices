package com.Demo.Microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.Microservices.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
