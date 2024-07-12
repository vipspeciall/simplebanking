package com.eteration.simplebanking.model;


import com.eteration.simplebanking.enums.TransactionTypes;
import com.eteration.simplebanking.exceptions.InsufficientBalanceException;

// This class is a place holder you can change the complete implementation
public class WithdrawalTransaction extends Transaction {


    public WithdrawalTransaction(double amount){ // Kendi construction methodu için
        super(amount, TransactionTypes.WithdrawalTransaction);
    }

    public WithdrawalTransaction(double amount, TransactionTypes transactionType){ // Subclasslarin constructor methodu icin
        super(amount, transactionType);
    }

    public WithdrawalTransaction(){

    }


    @Override
    public double process(final double balance) throws InsufficientBalanceException {
        if (balance >= super.getAmount()) {
            return balance - super.getAmount();
        } else {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
    }

}


