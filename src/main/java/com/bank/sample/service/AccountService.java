package com.bank.sample.service;

import com.bank.sample.dto.AccountDto;
import com.bank.sample.dto.AccountResponseDto;
import com.bank.sample.model.Account;

public interface AccountService {

	public AccountResponseDto saveAccount(AccountDto accountDto);

	public AccountResponseDto getAccountById(Integer accountId);

}
