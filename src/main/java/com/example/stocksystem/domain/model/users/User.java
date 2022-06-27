package com.example.stocksystem.domain.model.users;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "BIRTH", nullable = false)
    private String birth;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "HAND_PHONE", nullable = false)
    private String handPhone;

    @Column(name = "REGISTRATION_DATE")
    @CreatedDate
    private LocalDate registrationDate;
}
