package com.example.stocksystem.domain.model.accounts.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ACCOUNT_HISTORYS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountHistory {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_NO", referencedColumnName = "ACCOUNT_NO")
    private Account account;

    @Column(name = "DEPOSIT_WITHDRAWAL_YN", nullable = false)
    @ColumnDefault("'N'")
    private String depositWithdrawalYn;

    private Integer depositAmt;

    @Column(name = "TRANSACTION_DATE")
    @CreatedDate
    private LocalDate transactionDate;

}
