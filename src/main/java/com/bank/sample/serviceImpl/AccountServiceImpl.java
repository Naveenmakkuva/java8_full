package com.bank.sample.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.sample.dao.AccountDao;
import com.bank.sample.dao.CustomerDao;
import com.bank.sample.dto.AccountDto;
import com.bank.sample.dto.AccountResponseDto;
import com.bank.sample.model.Account;
import com.bank.sample.model.Customer;
import com.bank.sample.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	public CustomerDao customerDao;
	
	@Autowired
	public AccountDao accountDao;

	@Override
	public AccountResponseDto saveAccount(AccountDto accountDto) {
		AccountResponseDto responseDto = new AccountResponseDto();
		Optional<Customer> customer = customerDao.findById(accountDto.getCustomerId());
		Account account = new Account();
		if(customer.isPresent()) {
			BeanUtils.copyProperties(accountDto, account);
			account.setCustomer(customer.get());
			accountDao.save(account);
		}
		responseDto.setAccountId(account.getId());
		responseDto.setAccountNumber(account.getAccountNumber());
		responseDto.setBalance(account.getBalance());
		responseDto.setCustomer(account.getCustomer());
		responseDto.setTransaction(account.getTransaction());
		return responseDto;
	}

	@Override
	public AccountResponseDto getAccountById(Integer accountId) {
		Optional<Account> account = accountDao.findById(accountId);
		AccountResponseDto accountModel = new AccountResponseDto();
		if(account.isPresent()) {
			accountModel.setAccountId(account.get().getId());
			accountModel.setAccountNumber(account.get().getAccountNumber());
			accountModel.setBalance(account.get().getBalance());
			accountModel.setCustomer(account.get().getCustomer());
			accountModel.setTransaction(account.get().getTransaction());
		}
		return accountModel;
	}

}
