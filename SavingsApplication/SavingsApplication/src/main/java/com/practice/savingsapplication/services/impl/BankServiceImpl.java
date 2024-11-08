package com.practice.savingsapplication.services.impl;

import com.practice.savingsapplication.application.bank.Bank;
import com.practice.savingsapplication.application.bank.savings.BankFactory;
import com.practice.savingsapplication.application.bank.savings.SavingsAccount;
import com.practice.savingsapplication.dto.AccountRequest;
import com.practice.savingsapplication.dto.DepositRequest;
import com.practice.savingsapplication.dto.WithdrawRequest;
import com.practice.savingsapplication.entity.AccountEntity;
import com.practice.savingsapplication.repository.SavingsRepository;
import com.practice.savingsapplication.services.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankServiceImpl implements BankService {
    private final SavingsRepository savingsRepository;
    private final BankFactory bankFactory;

    @Override
    public AccountEntity createAccount(AccountRequest accountRequest, String bankType) {
        Bank savingsBank = bankFactory.getBank(bankType);
        return savingsBank.createAccount(accountRequest);
    }

    @Override
    public AccountEntity depositAccount(DepositRequest depositRequest, Long id, String bankType) {
        Bank savingsBank = bankFactory.getBank(bankType);
        return savingsBank.deposit(depositRequest, id);
    }

    @Override
    public AccountEntity withdrawAccount(WithdrawRequest depositRequest, Long id, String bankType) {
        Bank savingsBank = bankFactory.getBank(bankType);
        return savingsBank.withdraw(depositRequest, id);
    }

}
