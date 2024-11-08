package com.practice.savingsapplication.controller;

import com.practice.savingsapplication.dto.AccountRequest;
import com.practice.savingsapplication.dto.DepositRequest;
import com.practice.savingsapplication.dto.WithdrawRequest;
import com.practice.savingsapplication.entity.AccountEntity;
import com.practice.savingsapplication.services.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.practice.savingsapplication.common.BankConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API)
public class BankController implements BankAPI {

    private final BankService bankService;

    @Override
    @PostMapping(SAVINGS_URL)
    public ResponseEntity<AccountEntity> createAccount(@RequestBody AccountRequest accountRequest) {
        return ResponseEntity.ok(bankService.createAccount(accountRequest, "checkings"));
    }

    @Override
    @PostMapping(SAVINGS_URL + ID + DEPOSIT)
    public ResponseEntity<AccountEntity> deposit(@RequestBody DepositRequest depositRequest
        , @PathVariable("id") Long id) {
        return ResponseEntity.ok(bankService.depositAccount(depositRequest, id, SAVINGS));
    }

    @Override
    @PostMapping(SAVINGS_URL + ID + WITHDRAW)
    public ResponseEntity<AccountEntity> withdraw(@RequestBody WithdrawRequest withdrawRequest, @PathVariable("id") Long id) {
        return ResponseEntity.ok(bankService.withdrawAccount(withdrawRequest, id, SAVINGS));
    }

}
