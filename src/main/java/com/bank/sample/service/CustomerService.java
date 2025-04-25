package com.bank.sample.service;

import java.util.List;

import com.bank.sample.dto.CustomerDto;
import com.bank.sample.dto.CustomerResponseDto;

public interface CustomerService {
	public String addCustomer(CustomerDto customerDto);
	public CustomerResponseDto getCustomerDataById(Integer custId);
	public List<CustomerResponseDto> getCustomerDataByName(String customerName);
}
