package com.eteration.simplebanking.enums;

public enum TransactionTypes {

    WithdrawalTransaction("WithdrawalTransaction"),
    DepositTransaction("DepositTransaction"),
    PhoneBillPaymentTransaction("PhoneBillPaymentTransaction");

    private final String typeName;

    TransactionTypes(String typeName){

        this.typeName = typeName;

    }

    public String getTypeName(){
        return typeName;
    }


}
