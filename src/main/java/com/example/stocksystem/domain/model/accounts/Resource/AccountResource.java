package com.example.stocksystem.domain.model.accounts.Resource;

import com.example.stocksystem.presentation.accounts.AccountController;
import com.example.stocksystem.domain.model.accounts.Entity.Account;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import java.util.Arrays;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class AccountResource<T> extends EntityModel {
    public AccountResource(T t, Link... links) {
        super((Account)t, Arrays.asList(links));
        add(linkTo(AccountController.class).slash(((Account) t).getAccountNo()).withSelfRel());
    }
}
