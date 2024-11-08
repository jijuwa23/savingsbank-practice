package com.practice.savingsapplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.savingsapplication.dto.AccountRequest;
import com.practice.savingsapplication.dto.DepositRequest;
import com.practice.savingsapplication.dto.WithdrawRequest;
import com.practice.savingsapplication.entity.AccountEntity;
import com.practice.savingsapplication.services.BankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static com.practice.savingsapplication.common.BankConstants.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BankController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BankService bankService;

    private AccountRequest accountRequest;
    private AccountEntity accountEntity;
    private DepositRequest depositRequest;
    private WithdrawRequest withdrawRequest;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();

        accountRequest = new AccountRequest();
        accountRequest.setFirstName("niki");
        accountRequest.setLastName("damn");

        accountEntity = new AccountEntity();
        accountEntity.setFirstName("niki");
        accountEntity.setLastName("damn");
        accountEntity.setBalance(new BigDecimal(0));
        accountEntity.setId(Long.valueOf(1));

        depositRequest = new DepositRequest();
        depositRequest.setAmount(new BigDecimal(100));

        withdrawRequest = new WithdrawRequest();
        withdrawRequest.setAmount(new BigDecimal(100));
    }

    @Test
    public void testCreateAccount() throws Exception {
        when(bankService.createAccount(accountRequest, SAVINGS)).thenReturn(accountEntity);

        mockMvc.perform(post(API + SAVINGS_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(accountRequest)))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(accountEntity)));

        verify(bankService).createAccount(accountRequest, SAVINGS);
    }


    @Test
    public void testDeposit() throws Exception {
        when(bankService.depositAccount(depositRequest, Long.valueOf(1), SAVINGS)).thenReturn(accountEntity);

        mockMvc.perform(post(API + SAVINGS_URL + ID + DEPOSIT, Long.valueOf(1))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(depositRequest)))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(accountEntity)));

        verify(bankService).depositAccount(depositRequest, Long.valueOf(1), SAVINGS);
    }

    @Test
    public void testWithdraw() throws Exception {
        when(bankService.withdrawAccount(withdrawRequest, Long.valueOf(1), SAVINGS)).thenReturn(accountEntity);

        mockMvc.perform(post(API + SAVINGS_URL + ID + WITHDRAW, Long.valueOf(1))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(withdrawRequest)))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(accountEntity)));

        verify(bankService).withdrawAccount(withdrawRequest, Long.valueOf(1), SAVINGS);
    }
}
