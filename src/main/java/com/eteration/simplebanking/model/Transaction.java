package com.eteration.simplebanking.model;


import com.eteration.simplebanking.enums.TransactionTypes;
import com.eteration.simplebanking.exceptions.InsufficientBalanceException;
import com.eteration.simplebanking.helper.ApprovalCodeGenerator;
import com.eteration.simplebanking.helper.MockIdDataGenerator;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

// This class is a place holder you can change the complete implementation

@Getter
@Setter
@Entity
public abstract class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private OffsetDateTime date;
    private double amount;

    private String type;

    private String approvalCode;

    @ManyToOne
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    private Account account;

    public Transaction(){
        this.date = OffsetDateTime.now();
    }

    public Transaction(double amount, TransactionTypes transactionTypes)
    {
        this.amount = amount;
        this.date = OffsetDateTime.now();
        this.type = transactionTypes.getTypeName();
        this.id = MockIdDataGenerator.generateUniqueId();
        this.approvalCode = ApprovalCodeGenerator.generateRandomApprovalCode();
    }

    public abstract double process(final double balance) throws InsufficientBalanceException;


}
