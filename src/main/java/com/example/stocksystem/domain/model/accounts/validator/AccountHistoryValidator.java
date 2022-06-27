package com.example.stocksystem.domain.model.accounts.validator;

import com.example.stocksystem.presentation.accounts.request.AccountHistoryRegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class AccountHistoryValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(AccountHistoryRegistrationRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountHistoryRegistrationRequest accountHistoryRegistrationRequest = (AccountHistoryRegistrationRequest) target;
        if (accountHistoryRegistrationRequest.getDepositAmt() < 0) {
            errors.reject("wrongAmt", "입금액은 0원보다 커야 합니다.");
        }
    }
}
