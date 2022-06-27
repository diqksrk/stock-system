package com.example.stocksystem.application.accounts.impl;

import com.example.stocksystem.presentation.accounts.request.AccountHistoryRegistrationRequest;
import com.example.stocksystem.application.accounts.AccountHistoryService;
import com.example.stocksystem.domain.model.accounts.Entity.AccountHistory;
import com.example.stocksystem.domain.model.accounts.repository.AccountHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountHistoryServiceImpl implements AccountHistoryService {
    private final AccountHistoryRepository accountHistoryRepository;
    private final ModelMapper modelMapper;


    @Override
    public AccountHistory registerAccountHistory(AccountHistoryRegistrationRequest accountHistoryRegistrationRequest) {
        AccountHistory accountHistory = modelMapper.map(accountHistoryRegistrationRequest, AccountHistory.class);
        return accountHistoryRepository.save(accountHistory);
    }

    @Override
    public Page<AccountHistory> queryAccountHistorys(Pageable pageable) {
        return accountHistoryRepository.findAllPage(pageable);
    }
}
