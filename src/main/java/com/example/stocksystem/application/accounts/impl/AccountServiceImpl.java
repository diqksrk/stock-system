package com.example.stocksystem.application.accounts.impl;

import com.example.stocksystem.presentation.accounts.request.AccountRegistrationRequest;
import com.example.stocksystem.application.accounts.AccountService;
import com.example.stocksystem.domain.model.accounts.Entity.Account;
import com.example.stocksystem.domain.model.accounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Override
    public Account registerAccount(AccountRegistrationRequest accountRegistrationRequest) {
        Account account = modelMapper.map(accountRegistrationRequest, Account.class);
        return accountRepository.save(account);
    }

    @Override
    public Page<Account> queryAccounts(Pageable pageable) {
        return accountRepository.findAllPage(pageable);
    }
}
