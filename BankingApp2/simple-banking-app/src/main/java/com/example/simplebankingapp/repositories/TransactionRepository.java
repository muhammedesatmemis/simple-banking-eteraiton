package com.example.simplebankingapp.repositories;

import com.example.simplebankingapp.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Short> {
}
