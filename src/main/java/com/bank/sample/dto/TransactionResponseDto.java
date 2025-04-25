package com.bank.sample.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransactionResponseDto {
	@NotNull(message = "please provide transaction amount")
	private Double transactionedAmount;

	@NotEmpty(message = "provide account type")
	private String accountType;

	@NotNull(message = "provide from account no")
	private Long accountId;

	@NotNull(message = "provide accout balance")
	private Double accountBalance;

	@NotNull(message = "provide transactionDate")
	private Date transactionDate;

	@NotEmpty(message = "provide transaction number")
	private String transactionNumber;

	@NotNull(message = "provide from account id")
	private Integer fromAccountId;

	@NotNull(message = "provide to account id")
	private Integer toAccountId;

	private Date fromDate;

	private Date toDate;
}
