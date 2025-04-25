package com.bank.sample.dto;

import java.util.List;

import com.bank.sample.model.Account;
import com.bank.sample.model.Address;

import lombok.Data;

@Data
public class CustomerResponseDto {
	private Integer id;
	private String customerName;
	private Address address;
	private String phoneNumber;
	private String email;
	private List<Account> account;
}
