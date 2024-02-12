package com.example.simplebankingapp.controller;

import com.example.simplebankingapp.dto.TransactionRequest;
import com.example.simplebankingapp.entities.Account;
import com.example.simplebankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/v1")
public class AccountController {

    @Autowired
    private AccountService bankAccountService;



    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<Object> credit(@PathVariable String accountNumber, @RequestBody TransactionRequest request) {
        try {
            Account account = bankAccountService.credit(accountNumber, request.getAmount());
            return ResponseEntity.ok(account);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<Object> debit(@PathVariable String accountNumber, @RequestBody TransactionRequest request) {
        try {
            Account account = bankAccountService.debit(accountNumber, request.getAmount());
            return ResponseEntity.ok(account);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Object> getAccount(@PathVariable String accountNumber) {
        try {
            Account account = bankAccountService.getAccount(accountNumber);
            return ResponseEntity.ok(account);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}