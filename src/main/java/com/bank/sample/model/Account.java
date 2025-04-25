package com.bank.sample.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "account_table")
@Data
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private Integer id;
	@Column(name = "account_number")
	private Long accountNumber;
	@Column(name = "account_balance")
	private Double balance;
	@Column(name = "account_type")
	private String accountType;

//	To join customer table (many accounts having one customer) so used manytoone
//	Join column helps in joining with primary key of customer table.
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_Id")
	@JsonIgnoreProperties("account")
	private Customer customer;
	
//	one account have many transactions.
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Transaction> transaction = new ArrayList<>();
}
