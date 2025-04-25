package com.bank.sample.dto;

import java.util.List;

import com.bank.sample.model.Transaction;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountDto {
	@NotNull(message = "Please provide accountNumber")
	private Long accountNumber;
	
	@NotNull(message = "initial balance can't be null")
	private Double balance;
	
	@NotNull(message = "customerId must not be null")
	private Integer customerId;
	
	@NotEmpty(message = "account type is not valid.")
	private String accountType;
	
	private List<Transaction> transaction;
}
