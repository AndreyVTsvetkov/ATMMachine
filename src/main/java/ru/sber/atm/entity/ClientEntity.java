package ru.sber.atm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_clients")
@NoArgsConstructor
@Getter
@Setter
public class ClientEntity {
    @javax.persistence.Id
    @GeneratedValue
    private Long Id;

    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    private int age;

    @OneToMany(mappedBy = "client_id")
    private Set<AccountEntity> accounts;
}
