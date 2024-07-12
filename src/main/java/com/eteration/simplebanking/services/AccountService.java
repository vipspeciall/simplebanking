package com.eteration.simplebanking.services;


import com.eteration.simplebanking.exceptions.InsufficientBalanceException;
import com.eteration.simplebanking.model.TransactionStatus;
import com.eteration.simplebanking.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// This class is a place holder you can change the complete implementation
@Service
public class AccountService {

    private List<Account> mockAccounts = new ArrayList<>();


    public AccountService(){

        mockAccounts.add(new Account("Kerem Karaca", "17892"));
        mockAccounts.add(new Account("Canan Kaya", "1234"));
        mockAccounts.add(new Account("Demet Demircan", "9834"));

    }
    public Account findAccount(String accountNumber)
    {
        return mockAccounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    public TransactionStatus credit(String accountNumber, double amount) throws InsufficientBalanceException {

        Account account = findAccount(accountNumber);
        TransactionStatus transactionStatus = account.post(new WithdrawalTransaction(amount));                                                            //examples

        return transactionStatus;

    }

    public TransactionStatus debit(String accountNumber, double amount) throws InsufficientBalanceException {

        Account account = findAccount(accountNumber);
        TransactionStatus transactionStatus = account.post(new DepositTransaction(amount));

        return transactionStatus;

    }

    public TransactionStatus phoneBillPayment(String accountNumber, String operator, String phoneNumber, double amount) throws InsufficientBalanceException {

        Account account = findAccount(accountNumber);
        TransactionStatus transactionStatus = account.post(new PhoneBillPaymentTransaction(amount, phoneNumber, operator));                                                                  //examples

        return transactionStatus;

    }
}
