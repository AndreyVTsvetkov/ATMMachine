package ru.sber.atm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_accounts")
@NoArgsConstructor
@Getter
@Setter
public class AccountEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ACCOUNTNUM")
    private String accountNum;
    private int balance;
    @Column(name = "ISOCODE")
    private String isoCode;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client_id;

    @OneToMany(mappedBy = "account_id")
    private Set<CardEntity> cards;
}
