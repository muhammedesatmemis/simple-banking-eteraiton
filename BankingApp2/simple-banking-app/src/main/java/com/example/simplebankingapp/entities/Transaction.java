package com.example.simplebankingapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class Transaction {
    @Id
    private short id;
    private Date date;
    private double amount;

    public Transaction(double amount) {
    }
}