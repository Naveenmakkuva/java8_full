package com.bank.sample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.sample.model.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer>{

}
