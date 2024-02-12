package com.example.simplebankingapp;


import com.example.simplebankingapp.entities.Account;
import com.example.simplebankingapp.repositories.AccountRepository;
import com.example.simplebankingapp.repositories.TransactionRepository;
import com.example.simplebankingapp.service.AccountService;
import com.example.simplebankingapp.service.AccountServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private AccountServiceImp bankAccountService;

    @Test
    public void testCredit_Success() {

        //  Account account = new Account("123456", "Ahmet",500.0);
        //account = accountRepository.save(account);
      //  when(accountRepository.findById(anyString())).thenReturn(Optional.of(account));
        Account account = new Account();
        account.setOwner("Test-Name");
        account.setAccountNumber("123456");
        account.setBalance(500.0);
        Account accountMock = mock(Account.class);
        when(accountMock.getAccountNumber()).thenReturn("123456");

       // when(accountRepository.save(ArgumentMatchers.any(Account.class))).thenReturn(accountMock);

        account = accountRepository.save(account);
        System.out.println("account =>" + account.getAccountNumber());


        Account result = bankAccountService.credit(account.getAccountNumber(), account.getBalance());

        assertEquals(account.getAccountNumber(), result.getAccountNumber());
        assertEquals(600.0, result.getBalance());
    }


    @Test
    public void testCredit_AccountNotFound() {
        when(accountRepository.findById(anyString())).thenReturn(Optional.empty());

        String accountNumber = "123456";
        double amount = 100.0;

        Exception exception = assertThrows(RuntimeException.class, () -> {
            bankAccountService.credit(accountNumber, amount);
        });
        assertEquals("Account not found", exception.getMessage());
    }

    @Test
    public void testGetAccount_AccountNotFound() {
        String accountNumber = "789012";
        when(accountRepository.findById(accountNumber)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> bankAccountService.getAccount(accountNumber));

        verify(accountRepository, times(1)).findById(accountNumber);
    }
}