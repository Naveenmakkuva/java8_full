package com.bank.sample.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransactionDto {
	@NotNull(message = "please provide transaction amount")
	private Double transactionAmount;

	@NotNull(message = "please provide debit account id")
	private Integer fromAccountId;

	@NotNull(message = "please provide credit account id")
	private Integer toAccountId;
	
	@NotEmpty(message = "please provide transaction number")
	private String transactionNumber;
}
