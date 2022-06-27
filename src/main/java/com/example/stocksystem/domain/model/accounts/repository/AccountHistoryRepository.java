package com.example.stocksystem.domain.model.accounts.repository;

import com.example.stocksystem.domain.model.accounts.Entity.AccountHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountHistoryRepository extends JpaRepository<AccountHistory, Integer> {
    @EntityGraph(attributePaths = {"account"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("select c from AccountHistory c left join c.account")
    Page<AccountHistory> findAllPage(Pageable pageable);
}
