package com.bank.sample.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.sample.dao.CustomerDao;
import com.bank.sample.dto.CustomerDto;
import com.bank.sample.dto.CustomerResponseDto;
import com.bank.sample.model.Account;
import com.bank.sample.model.Customer;
import com.bank.sample.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public CustomerResponseDto getCustomerDataById(Integer custId) {
		CustomerResponseDto responseDto = new CustomerResponseDto();
		Customer customer = new Customer();
		Optional<Customer> customerOpt = customerDao.findById(custId);
		if(customerOpt.isPresent()) {
			customer = customerOpt.get();
			BeanUtils.copyProperties(customer, responseDto);
		}
		return responseDto;
	}

	@Override
	public String addCustomer(CustomerDto customerDto) {
		CustomerResponseDto responseDto = new CustomerResponseDto();
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		List<Account> accountList = new ArrayList<>();
		for(Account acc: customerDto.getAccount()) {
			acc.setCustomer(customer);
			accountList.add(acc);
		}
		customer.setAccount(accountList);
		customerDao.save(customer);
		return "customer details added successfully";
	}

	@Override
	public List<CustomerResponseDto> getCustomerDataByName(String customerName) {
		List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();

		List<Customer> customerList = customerDao.findByCustomerNameLike(customerName);
		if (null != customerList) {
			for (Customer custList : customerList) {
				CustomerResponseDto customerResponseDto = new CustomerResponseDto();
				customerResponseDto.setCustomerName(custList.getCustomerName());
				customerResponseDto.setAddress(custList.getAddress());
				customerResponseDto.setAccount(custList.getAccount());
				customerResponseDto.setEmail(custList.getEmail());
				customerResponseDto.setPhoneNumber(custList.getPhoneNumber());
				customerResponseDto.setId(custList.getId());
				customerResponseDtoList.add(customerResponseDto);
			}
		}
		return customerResponseDtoList;
	}
	
}
