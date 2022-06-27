package com.example.stocksystem.application.accounts;

import com.example.stocksystem.presentation.accounts.request.AccountRegistrationRequest;
import com.example.stocksystem.domain.model.accounts.Entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {
    Account registerAccount(AccountRegistrationRequest accountRegistrationRequest);

    Page<Account> queryAccounts(Pageable pageable);
}
