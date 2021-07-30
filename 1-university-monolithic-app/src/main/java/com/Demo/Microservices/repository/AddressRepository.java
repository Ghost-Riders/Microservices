package com.Demo.Microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.Microservices.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
