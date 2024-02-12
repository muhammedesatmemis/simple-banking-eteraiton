package com.example.simplebankingapp.service;

import com.example.simplebankingapp.entities.Account;

public interface AccountService {

        Account credit(String accountNumber, double amount);
        Account debit(String accountNumber, double amount);
        Account getAccount(String accountNumber);

}
