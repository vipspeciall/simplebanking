package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.exceptions.InsufficientBalanceException;
import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// This class is a place holder you can change the complete implementation
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/v1/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.findAccount(accountNumber));
    }

    @PostMapping("/v1/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber, @RequestBody DepositTransaction transaction) throws InsufficientBalanceException {

        TransactionStatus transactionStatus = accountService.credit(accountNumber,transaction.getAmount());
        return ResponseEntity.ok(transactionStatus);

    }

    @PostMapping("/v1/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber, @RequestBody WithdrawalTransaction transaction) throws InsufficientBalanceException {

        TransactionStatus transactionStatus = accountService.debit(accountNumber,transaction.getAmount());
        return ResponseEntity.ok(transactionStatus);

    }

    @PostMapping("/v1/phoneBillPayment/{accountNumber}")
    public ResponseEntity<TransactionStatus> phoneBillPayment(@PathVariable String accountNumber, @RequestBody PhoneBillPaymentTransaction transaction) throws InsufficientBalanceException {

        TransactionStatus transactionStatus = accountService.phoneBillPayment(accountNumber,transaction.getOperator(),transaction.getPhoneNumber(),transaction.getAmount());
        return ResponseEntity.ok(transactionStatus);

    }
}