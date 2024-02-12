package com.example.simplebankingapp.repositories;

import com.example.simplebankingapp.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
