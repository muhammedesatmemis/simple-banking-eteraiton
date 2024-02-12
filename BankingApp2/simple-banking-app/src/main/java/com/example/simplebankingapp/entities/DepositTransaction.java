package com.example.simplebankingapp.entities;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class DepositTransaction extends Transaction {
    private String approvalCode;


    public DepositTransaction(double amount, String approvalCode) {
        super(amount);
        this.approvalCode = approvalCode;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }
}