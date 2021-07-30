package com.student.service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.service.feignclients.AddressFeignClient;
import com.student.service.response.AddressResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommanServices {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	int count = 0;

	@Autowired
	AddressFeignClient addressFeignClient;

	@CircuitBreaker(name = "addressService", fallbackMethod = "fallbackGetAddressById")
	public AddressResponse getAddressById(long addressId) {
		LOGGER.info("Count: " + count);
		count++;
		AddressResponse addressResponse = addressFeignClient.getById(addressId);
		return addressResponse;
	}

	public AddressResponse fallbackGetAddressById(long addressId, Throwable th) {
		LOGGER.error("Error: " + th);
		return new AddressResponse();
	}
}
