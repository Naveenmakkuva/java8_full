package com.bank.sample.service;

import com.bank.sample.dto.TransactionDto;
import com.bank.sample.dto.TransactionResponseDto;

public interface TransactionService {

	public TransactionResponseDto saveTransaction(TransactionDto transactiondto);

}
