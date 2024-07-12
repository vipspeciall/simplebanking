package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class TransactionStatus {

    private HttpStatus status;
    private String approvalCode;

    public TransactionStatus(HttpStatus status, String approvalCode){
        this.status = status;
        this.approvalCode = approvalCode;
    }



}
