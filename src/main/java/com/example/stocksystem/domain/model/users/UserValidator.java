package com.example.stocksystem.domain.model.users;

import com.example.stocksystem.presentation.users.request.UserRegistrationResquest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {
    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(UserRegistrationResquest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRegistrationResquest userRegistrationResquest = (UserRegistrationResquest) target;
        if (userRepository.existsByNameAndBirthAndHandPhone(userRegistrationResquest.getName(), userRegistrationResquest.getBirth(), userRegistrationResquest.getHandPhone())) {
            errors.reject("ExistedUser", "이미 등록된 유저입니다.");
        }
    }
}
