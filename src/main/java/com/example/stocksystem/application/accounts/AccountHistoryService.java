package com.example.stocksystem.application.accounts;

import com.example.stocksystem.presentation.accounts.request.AccountHistoryRegistrationRequest;
import com.example.stocksystem.domain.model.accounts.Entity.AccountHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountHistoryService {
    AccountHistory registerAccountHistory(AccountHistoryRegistrationRequest accountHistoryRegistrationRequest);

    Page<AccountHistory> queryAccountHistorys(Pageable pageable);
}
