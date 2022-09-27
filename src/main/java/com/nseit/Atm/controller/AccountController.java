package com.nseit.Atm.controller;

import com.nseit.Atm.modal.Amount;
import com.nseit.Atm.service.AccountService;
import com.nseit.Atm.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/amount")
@CrossOrigin(value = "http://localhost:3000")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/withdraw")
    public void withdrawlAmount(@RequestBody Amount amount) {
        int bal = Util.balance;
        Util util = new Util();
        Util.valid();
        int fbal = bal - amount.getAmount();
        Util.balance = fbal;

        if (amount.getAmount() <= bal) {
            System.out.println(fbal);
        } else {
            System.out.println("In sufficient amount");
        }
        amount.setAmount(fbal);
        accountService.withdrawlAmount(amount);
    }

    @PostMapping("/deposit")
    public void depositAmount(@RequestBody Amount amount) {
        int bal = Util.balance;
        Util util = new Util();
        Util.valid();
        int fbal = bal + amount.getAmount();
        Util.balance = fbal;
        System.out.println(Util.balance);
        amount.setAmount(fbal);
        accountService.depositAmount(amount);
    }

//    @GetMapping("/{id}")
//    public Optional<Amount> viewBalance(@PathVariable Integer id) {
//        Util util = new Util();
//        Util.valid();
//        System.out.println(util.balance);
//        Amount amount = new Amount();
//        System.out.println(amount.getAmount());
//      return accountService.viewBalance(id);
//
//    }
    @GetMapping("/all")
    public int ViewBalance(){
       return accountService.viewBalance();
    }
}
