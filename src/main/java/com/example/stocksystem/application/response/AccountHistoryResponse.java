package com.example.stocksystem.application.response;

import com.example.stocksystem.domain.model.accounts.Entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountHistoryResponse {
    private Integer id;

    private Account account;

    private String depositWithdrawalYn;

    private Integer depositAmt;

    private LocalDate transactionDate;
}
