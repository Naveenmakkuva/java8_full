package com.bank.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.sample.dto.TransactionDto;
import com.bank.sample.dto.TransactionResponseDto;
import com.bank.sample.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	public TransactionService transactionService;
	
	@PostMapping("/saveTransaction")
	public ResponseEntity<TransactionResponseDto> saveTransaction(@Valid @RequestBody TransactionDto transactiondto){
		return new ResponseEntity<TransactionResponseDto>(transactionService.saveTransaction(transactiondto),HttpStatus.ACCEPTED);
	}
}
