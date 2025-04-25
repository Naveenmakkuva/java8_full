package com.bank.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.sample.dto.CustomerDto;
import com.bank.sample.dto.CustomerResponseDto;
import com.bank.sample.service.CustomerService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerDto customerDto){
		customerService.addCustomer(customerDto);
		return new ResponseEntity<String>("Customer added successfully.",HttpStatus.ACCEPTED);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/{custId}")
	public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Integer custId){
		return new ResponseEntity(customerService.getCustomerDataById(custId),HttpStatus.FOUND) ;
	}
	
	@GetMapping("/getCustomerByName")
	public ResponseEntity<List<CustomerResponseDto>> getCustomerDataByName(@NotEmpty(message = "customreName cannot be empty") @RequestParam String customerName){
		return new ResponseEntity<List<CustomerResponseDto>>(customerService.getCustomerDataByName(customerName),HttpStatus.FOUND);
	}
}
