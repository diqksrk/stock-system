package com.example.stocksystem.application.users;

import com.example.stocksystem.domain.model.users.User;
import com.example.stocksystem.presentation.users.request.UserRegistrationResquest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User createUser(UserRegistrationResquest userRegistrationResquest);

    Page<User> queryUsers(Pageable pageable);
}
