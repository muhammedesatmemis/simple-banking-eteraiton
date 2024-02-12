package com.example.simplebankingapp.service;

import com.example.simplebankingapp.entities.Account;
import com.example.simplebankingapp.entities.DepositTransaction;
import com.example.simplebankingapp.entities.WithdrawalTransaction;
import com.example.simplebankingapp.repositories.AccountRepository;
import com.example.simplebankingapp.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public Account credit(String accountNumber, double amount) {
        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);

        DepositTransaction depositTransaction = new DepositTransaction(amount, "");
        transactionRepository.save(depositTransaction);

        account = accountRepository.save(account);
        return account;
    }

    @Override
    public Account debit(String accountNumber, double amount) {
        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);

        WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction(amount, "");
        transactionRepository.save(withdrawalTransaction);

        account = accountRepository.save(account);
        return account;
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountRepository.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
