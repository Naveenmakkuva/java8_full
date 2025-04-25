package com.bank.sample.dto;

import java.util.List;

import com.bank.sample.model.Customer;
import com.bank.sample.model.Transaction;

import lombok.Data;

@Data
public class AccountResponseDto {
	private Integer accountId;
	private Long accountNumber;
	private Double balance;
	private Customer customer;
	private List<Transaction> transaction;
}
