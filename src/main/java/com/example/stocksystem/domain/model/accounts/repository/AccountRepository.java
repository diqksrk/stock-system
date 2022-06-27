package com.example.stocksystem.domain.model.accounts.repository;

import com.example.stocksystem.domain.model.accounts.Entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    boolean existsByUserIdAndAccountNo(Integer userId, String accountNo);

    Account findByUserIdAndAccountNo(Integer userId, String accountNo);

    @EntityGraph(attributePaths = {"user"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("select c from Account c left join c.user")
    Page<Account> findAllPage(Pageable pageable);
}
