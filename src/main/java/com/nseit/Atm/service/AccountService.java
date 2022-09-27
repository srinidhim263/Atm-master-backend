package com.nseit.Atm.service;

import com.nseit.Atm.modal.Amount;
import com.nseit.Atm.repository.AccountRepository;
import com.nseit.Atm.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public void withdrawlAmount(Amount amount){

        accountRepository.save(amount);
    }
    public void depositAmount( Amount amount){

        accountRepository.save(amount);
    }
//   public Optional<Amount> viewBalance(Integer id){
//        return accountRepository.findById(id);
//   }

    public int viewBalance(){
        return Util.balance;
    }

}
