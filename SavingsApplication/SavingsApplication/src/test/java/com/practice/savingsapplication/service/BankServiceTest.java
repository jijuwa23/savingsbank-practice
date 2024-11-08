package com.practice.savingsapplication.service;

import com.practice.savingsapplication.application.bank.Bank;
import com.practice.savingsapplication.application.bank.savings.BankFactory;
import com.practice.savingsapplication.application.bank.savings.SavingsAccount;
import com.practice.savingsapplication.dto.AccountRequest;
import com.practice.savingsapplication.entity.AccountEntity;
import com.practice.savingsapplication.repository.SavingsRepository;
import com.practice.savingsapplication.services.impl.BankServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankServiceTest {

    BankServiceImpl bankServiceImpl;

    @Mock
    SavingsRepository savingsRepository;

    @Mock
    BankFactory bankFactory;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateAccountServiceSuccess() {


        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setFirstName("Parker");
        accountRequest.setLastName("Cannon");

        AccountEntity expectedResponse = new AccountEntity();
        expectedResponse.setId(Long.valueOf(1));
        expectedResponse.setBalance(new BigDecimal(0));
        expectedResponse.setFirstName("Parker");
        expectedResponse.setLastName("Cannon");

        SavingsAccount savingsAccount = spy(new SavingsAccount(savingsRepository));
        when(savingsAccount.createAccount(accountRequest)).thenReturn(expectedResponse);

        Map<String, Bank> bankMap = new HashMap<>();
        bankMap.put("checkings", savingsAccount);

        BankFactory bankFactory1 = new BankFactory(bankMap);
        Bank bank = spy(new SavingsAccount(savingsRepository));

//        when(bank.createAccount(accountRequest)).thenReturn(expectedResponse);
        bankServiceImpl = new BankServiceImpl(savingsRepository, bankFactory1);
//        when(bankFactory1.getBank(SAVINGS)).thenReturn(bank);
        AccountEntity actualResponse = bankServiceImpl.createAccount(accountRequest, "checkings");

        Assertions.assertEquals(expectedResponse, actualResponse);
    }
}
