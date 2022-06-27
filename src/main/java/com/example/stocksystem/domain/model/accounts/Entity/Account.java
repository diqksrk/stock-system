package com.example.stocksystem.domain.model.accounts.Entity;

import com.example.stocksystem.domain.model.users.User;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNTS")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ACCOUNT_NO")
    @Length(max = 14)
    private String accountNo;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
