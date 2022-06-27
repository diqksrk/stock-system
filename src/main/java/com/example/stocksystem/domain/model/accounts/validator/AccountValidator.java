package com.example.stocksystem.domain.model.accounts.validator;

import com.example.stocksystem.domain.model.accounts.repository.AccountRepository;
import com.example.stocksystem.presentation.accounts.request.AccountRegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class AccountValidator implements Validator {
    private final AccountRepository accountRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(AccountRegistrationRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountRegistrationRequest accountRegistrationRequest = (AccountRegistrationRequest) target;
        if (accountRepository.existsByUserIdAndAccountNo(accountRegistrationRequest.getUserId(), accountRegistrationRequest.getAccountNo())) {
            errors.reject("DuplcationAccount", "해당 유저에게 이미 등록된 계좌입니다.");
        }
    }
}
