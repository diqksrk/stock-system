package com.example.stocksystem.application.users;

import com.example.stocksystem.domain.model.users.User;
import com.example.stocksystem.domain.model.users.UserRepository;
import com.example.stocksystem.presentation.users.request.UserRegistrationResquest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public User createUser(UserRegistrationResquest userRegistrationResquest) {
        User user = modelMapper.map(userRegistrationResquest, User.class);
        User newUser = userRepository.save(user);

        return newUser;
    }

    @Override
    public Page<User> queryUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
