package com.example.mysqlproject.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysqlproject.excepation.IdNotFoundExcption;
import com.example.mysqlproject.model.AccountModel;
import com.example.mysqlproject.repository.AccountRepo;
import com.example.mysqlproject.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepo accRepo;
	
	@Override
	public List<AccountModel> get()
	{
		return (List<AccountModel>) accRepo.findAll();
	}
	@Override
	public AccountModel getById(int id)
	{
		Optional<AccountModel> model=accRepo.findById(id);
		if(model.isPresent())
		{
			AccountModel modelById=model.get();
			return accRepo.save(modelById);
			
		}
		//return null;
		throw new IdNotFoundExcption("Resquest id is not found");
	}

	@Override
	public AccountModel Create(AccountModel model)
	{
		return accRepo.save(model);
	}
	
	@Override
	public AccountModel update(int id, String newName) {
        Optional<AccountModel> newDemo = accRepo.findById(id);
        if (newDemo.isPresent()) {
        	AccountModel updateName = newDemo.get();
        	updateName.setName(newName);;
            return accRepo.save(updateName);
        }
       // return null;
        throw new IdNotFoundExcption("Resquest id is not found");
    }
	@Override
	public boolean delete(int id)
	{
		if(accRepo.existsById(id))
		{
			accRepo.deleteById(id);
			return true;
		}
		
		else
			//return false;
			throw new IdNotFoundExcption("Resquest id is not found");
	}
	@Override
	public AccountModel deposit(int id,double amount)
	{
		AccountModel account=accRepo.findById(id).orElseThrow(()->  new IdNotFoundExcption("Resquest id is not found"));
		//new RuntimeException("Account not found"));
		double total=account.getAmount()+amount;
		account.setAmount(total);
		return accRepo.save(account);
	}
	
	@Override
	public AccountModel withdraw(int id,double amount)
	{
		AccountModel account=accRepo.findById(id).orElseThrow(()-> new IdNotFoundExcption("Resquest id is not found"));
		//new RuntimeException("Account not found"));
		if(account.getAmount()<amount)
		{
			throw new RuntimeException("Balance is low");
		}
		else
		{
		double total=account.getAmount()-amount;
		
		account.setAmount(total);
		return accRepo.save(account);
		}
	}
	
	}

