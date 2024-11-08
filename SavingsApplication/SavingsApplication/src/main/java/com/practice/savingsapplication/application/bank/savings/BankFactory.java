package com.practice.savingsapplication.application.bank.savings;

import com.practice.savingsapplication.application.bank.Bank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class BankFactory {

    private final Map<String, Bank> bankMap;

    public Bank getBank(String type) {
        Bank bank = bankMap.get(type.toLowerCase());
        if (bank == null) {
            throw new IllegalArgumentException("Unknown Bank Type: " + type);
        }
        return bank;
    }

}