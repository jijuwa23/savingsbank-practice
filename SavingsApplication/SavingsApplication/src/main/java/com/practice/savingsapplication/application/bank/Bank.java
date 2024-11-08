package com.practice.savingsapplication.application.bank;

import com.practice.savingsapplication.dto.AccountRequest;
import com.practice.savingsapplication.dto.DepositRequest;
import com.practice.savingsapplication.dto.WithdrawRequest;
import com.practice.savingsapplication.entity.AccountEntity;

public interface Bank {
    AccountEntity createAccount(AccountRequest accountRequest);

    AccountEntity deposit(DepositRequest depositRequest, Long id);

    AccountEntity withdraw(WithdrawRequest depositRequest, Long id);
}
