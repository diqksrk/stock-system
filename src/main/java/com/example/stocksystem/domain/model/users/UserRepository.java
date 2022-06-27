package com.example.stocksystem.domain.model.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByNameAndBirthAndHandPhone(String name, String birth, String handPhone);
}
