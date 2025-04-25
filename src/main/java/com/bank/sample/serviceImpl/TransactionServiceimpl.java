package com.bank.sample.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.sample.dao.AccountDao;
import com.bank.sample.dto.TransactionDto;
import com.bank.sample.dto.TransactionResponseDto;
import com.bank.sample.model.Account;
import com.bank.sample.model.Transaction;
import com.bank.sample.service.TransactionService;

@Service
public class TransactionServiceimpl implements TransactionService {

	@Autowired
	public AccountDao accountDao;

	@Override
	public TransactionResponseDto saveTransaction(TransactionDto transactionDto) {
		Optional<Account> account = accountDao.findById(transactionDto.getToAccountId());
		Transaction creditTransaction = new Transaction();
		
		Transaction debitTransaction = new Transaction();
		debitTransaction.setAccount(account.get());
		return null;
	}

}
