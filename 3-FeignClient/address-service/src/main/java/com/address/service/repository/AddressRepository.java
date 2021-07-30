package com.address.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.address.service.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
