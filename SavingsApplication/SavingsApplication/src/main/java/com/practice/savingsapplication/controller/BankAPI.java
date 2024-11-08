package com.practice.savingsapplication.controller;

import com.practice.savingsapplication.dto.AccountRequest;
import com.practice.savingsapplication.dto.DepositRequest;
import com.practice.savingsapplication.dto.WithdrawRequest;
import com.practice.savingsapplication.entity.AccountEntity;
import org.springframework.http.ResponseEntity;


public interface BankAPI {
    ResponseEntity<AccountEntity> createAccount(AccountRequest accountRequest);

    ResponseEntity<AccountEntity> deposit(DepositRequest depositRequest, Long id);

    ResponseEntity<AccountEntity> withdraw(WithdrawRequest withdrawRequest, Long id);

}
