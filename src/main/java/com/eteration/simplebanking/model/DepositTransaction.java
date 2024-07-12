package com.eteration.simplebanking.model;


import com.eteration.simplebanking.enums.TransactionTypes;

// This class is a place holder you can change the complete implementation
public class DepositTransaction extends Transaction{
    public DepositTransaction(double amount) {
        super(amount, TransactionTypes.DepositTransaction);
    }

    public DepositTransaction(){}

    @Override
    public double process(final double balance){
        return balance + super.getAmount();
    }
}
