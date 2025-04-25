package com.bank.sample.dto;

import java.util.ArrayList;
import java.util.List;

import com.bank.sample.model.Account;
import com.bank.sample.model.Address;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
	
	@NotEmpty(message = "Kindly provide customer name")
	@Size(min = 5,max = 50)
	private String customerName;
	
	@NotEmpty(message = "Kindly provide email")
	@Email
	private String email;
	
	@NotEmpty(message = "Kindly enter phone number")
	@Pattern(regexp = "[0-9]{10}",message = "Please enter valid phone number")
	private String phoneNumber;
	
	@NotNull(message = "kindly provide address")
	private Address address;
	
	@NotEmpty(message = "please provide account details")
	@NotNull(message = "please provide account details")
	private List<Account> account = new ArrayList<>();
}
