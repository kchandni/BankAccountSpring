package com.example.mysqlproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysqlproject.model.AccountModel;
import com.example.mysqlproject.serviceImpl.AccountServiceImpl;

@RestController
public class AccountController {
	
	@Autowired
	AccountServiceImpl accService;
	
	@GetMapping("/getAll")
	public List<AccountModel> getAll()
	{
		return accService.get();
	}
	@GetMapping("/get/{id}")
	public AccountModel getById(@PathVariable Integer id)
	{
		
		return accService.getById(id);
	}
	@PostMapping("/save")
	public ResponseEntity<AccountModel> save(@RequestBody AccountModel model)
	{
		 return ResponseEntity.status(HttpStatus.CREATED).body(accService.Create(model));
	}

	@PutMapping("/edit/{id}/name")
	public ResponseEntity<AccountModel> updateToDB(@PathVariable Integer id, @RequestParam String Name)
	{
		AccountModel Updatedmodel=accService.update(id, Name);
		if(Updatedmodel!=null)
			return new ResponseEntity<>(Updatedmodel, HttpStatus.OK);
		else
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	@DeleteMapping("/del/{id}")
	public ResponseEntity<Void> deleteDB(@PathVariable Integer id)
	{
		boolean flag=accService.delete(id);
		return flag? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/deposit/{id}")
	public ResponseEntity<AccountModel> depositToDB(@PathVariable Integer id,@RequestBody Map<String,Double> request)
	{
		double amount=request.get("amount");
		 return ResponseEntity.status(HttpStatus.CREATED).body(accService.deposit(id,amount));
	}
	@PutMapping("/withdraw/{id}")
	public ResponseEntity<AccountModel> withdrawFromDB(@PathVariable Integer id,@RequestBody Map<String,Double> request)
	{

		double amount=request.get("amount");
		 return ResponseEntity.status(HttpStatus.CREATED).body(accService.withdraw(id,amount));
	}
}
