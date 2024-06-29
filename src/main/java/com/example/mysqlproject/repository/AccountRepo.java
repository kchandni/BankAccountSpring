package com.example.mysqlproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mysqlproject.model.AccountModel;

@Repository
public interface AccountRepo extends JpaRepository<AccountModel,Integer>{

}
