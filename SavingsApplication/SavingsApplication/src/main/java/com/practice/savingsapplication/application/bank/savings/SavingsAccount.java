package com.practice.savingsapplication.application.bank.savings;

import com.practice.savingsapplication.application.bank.Bank;
import com.practice.savingsapplication.dto.AccountRequest;
import com.practice.savingsapplication.dto.DepositRequest;
import com.practice.savingsapplication.dto.WithdrawRequest;
import com.practice.savingsapplication.entity.AccountEntity;
import com.practice.savingsapplication.repository.SavingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service("savings")
public class SavingsAccount implements Bank {
    private final SavingsRepository savingsRepository;

    @Override
    public AccountEntity createAccount(AccountRequest accountRequest) {
        return savingsRepository.save(AccountEntity.builder()
            .firstName(accountRequest.getFirstName())
            .lastName(accountRequest.getLastName())
            .balance(new BigDecimal(0))
            .build());
    }

    @Override
    public AccountEntity deposit(DepositRequest depositRequest, Long id) {
        AccountEntity accountEntity = savingsRepository
            .getReferenceById(id);

        accountEntity.addToBalance(depositRequest.getAmount());

        return savingsRepository.save(accountEntity);
    }

    @Override
    public AccountEntity withdraw(WithdrawRequest depositRequest, Long id) {
        AccountEntity accountEntity = savingsRepository
            .getReferenceById(id);

        accountEntity.deductToBalance(depositRequest.getAmount());

        return savingsRepository.save(accountEntity);
    }


}
