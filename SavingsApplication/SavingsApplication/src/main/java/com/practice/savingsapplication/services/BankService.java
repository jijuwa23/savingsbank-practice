package com.practice.savingsapplication.services;

import com.practice.savingsapplication.dto.AccountRequest;
import com.practice.savingsapplication.dto.DepositRequest;
import com.practice.savingsapplication.dto.WithdrawRequest;
import com.practice.savingsapplication.entity.AccountEntity;

public interface BankService {

    AccountEntity createAccount(AccountRequest accountRequest, String bankType);

    AccountEntity depositAccount(DepositRequest depositRequest, Long id, String bankType);

    AccountEntity withdrawAccount(WithdrawRequest depositRequest, Long id, String bankType);

}
