package com.example.bs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bs.exception.AccountNotFoundException;
import com.example.bs.model.Account;
import com.example.bs.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public double getAccountBalance(String email) throws AccountNotFoundException {
        Account account = accountRepository.findByEmail(email)
            .orElseThrow(() -> new AccountNotFoundException("Account not found for email: " + email));
        return account.getBalance();
    }
}