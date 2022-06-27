package com.example.stocksystem.domain.model.accounts.Resource;

import com.example.stocksystem.presentation.accounts.AccountHistoryController;
import com.example.stocksystem.domain.model.accounts.Entity.AccountHistory;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import java.util.Arrays;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class AccountHistoryResource extends EntityModel<AccountHistory> {
    public AccountHistoryResource(AccountHistory accountHistory, Link... links) {
        super(accountHistory, Arrays.asList(links));
        add(linkTo(AccountHistoryController.class).slash(accountHistory.getId()).withSelfRel());
    }

}
