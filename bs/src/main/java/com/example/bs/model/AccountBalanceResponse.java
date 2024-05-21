package com.example.bs.model;

import lombok.Data;

@Data
public class AccountBalanceResponse {
    private double balance;
    private String message;

    public AccountBalanceResponse(double balance) {
        this.balance = balance;
        this.message = "Success";
    }

    public AccountBalanceResponse(String message) {
        this.message = message;
    }

}
