package com.address.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.address.service.request.CreateAddressRequest;
import com.address.service.response.AddressResponse;
import com.address.service.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	@Autowired
	AddressService studentService;

	@PostMapping("/create")
	public AddressResponse createAddress(@RequestBody CreateAddressRequest createAddressRequest) {
		return studentService.createAddress(createAddressRequest);
	}

	@GetMapping("/getById/{id}")
	public AddressResponse getById(@PathVariable("id") Long id) {
		return studentService.getById(id);
	}

}
