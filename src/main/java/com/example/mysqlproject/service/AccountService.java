package com.example.mysqlproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mysqlproject.model.AccountModel;


@Service
public interface AccountService {
	
	
	List<AccountModel> get();
	AccountModel getById(int id);
	AccountModel Create(AccountModel model);
	 AccountModel update(int id, String newName);
	  boolean delete(int id);
	  AccountModel deposit(int id,double amount);
	  AccountModel withdraw(int id,double amount);
	  
	
	

}
