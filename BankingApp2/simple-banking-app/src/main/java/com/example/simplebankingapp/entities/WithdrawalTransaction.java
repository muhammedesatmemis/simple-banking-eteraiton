package com.example.simplebankingapp.entities;

import jakarta.persistence.Entity;

@Entity
public class WithdrawalTransaction extends Transaction {
    private String approvalCode;

    public WithdrawalTransaction(double amount, String approvalCode) {
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