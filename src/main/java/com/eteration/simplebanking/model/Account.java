package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import com.eteration.simplebanking.exceptions.InsufficientBalanceException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private String accountNumber;
    private double balance;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    @OrderBy("date")
    private List<Transaction> transactions;

    public Account(String owner, String accountNumber){
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = Double.NaN;
        transactions = new ArrayList<>();
        this.id = Long.valueOf(accountNumber);
    }

    public TransactionStatus post(Transaction transaction) throws InsufficientBalanceException {

       balance = transaction.process(balance);
       transactions.add(transaction);
       return new TransactionStatus(HttpStatus.OK,transaction.getApprovalCode());

    }

    public void withdraw(double amount){
        balance = balance - amount;
    }

    public void deposit(double amount){
        balance = balance + amount;
    }
}
