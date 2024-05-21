package com.example.bs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bs.exception.AccountNotFoundException;
import com.example.bs.model.AccountBalanceResponse;
import com.example.bs.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accountBalance/{email}")
    public ResponseEntity<AccountBalanceResponse> getAccountBalance(@PathVariable("email") String email) {
        try {
            double balance = accountService.getAccountBalance(email);
            return ResponseEntity.ok(new AccountBalanceResponse(balance));
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AccountBalanceResponse(e.getMessage()));
        }
    }
}

