package com.bank.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.sample.dto.AccountDto;
import com.bank.sample.dto.AccountResponseDto;
import com.bank.sample.model.Account;
import com.bank.sample.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/accounts/")
public class AccountController {
	
	@Autowired
	public AccountService accountService;
	
	@PostMapping("/saveaccount")
	public ResponseEntity<AccountResponseDto> saveAccount(@Valid @RequestBody AccountDto accountDto){
		return new ResponseEntity<AccountResponseDto>(accountService.saveAccount(accountDto),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("{accountId}")
	public ResponseEntity<AccountResponseDto> getAccountById(@PathVariable Integer accountId){
		return new ResponseEntity<AccountResponseDto>(accountService.getAccountById(accountId),HttpStatus.FOUND);
	}
}
