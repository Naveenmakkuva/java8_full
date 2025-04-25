package com.bank.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.sample.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	List<Customer> findByCustomerNameLike(String customerName);
	
}
