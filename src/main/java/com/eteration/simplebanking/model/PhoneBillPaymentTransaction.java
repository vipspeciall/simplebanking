package com.eteration.simplebanking.model;


import com.eteration.simplebanking.enums.TransactionTypes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneBillPaymentTransaction extends WithdrawalTransaction{

    private String phoneNumber;

    private String operator;
    public PhoneBillPaymentTransaction(double amount, String phoneNumber, String operator) {
        new WithdrawalTransaction(amount, TransactionTypes.PhoneBillPaymentTransaction);
        this.phoneNumber = phoneNumber;
        this.operator = operator;
    }

}
