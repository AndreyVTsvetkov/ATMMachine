package ru.sber.atm.processor;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Stream;

public class Client {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private int age;
    private HashSet<Account> accounts = new HashSet<>();


    public Client(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.age = age;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
    public Stream<Account> getAccounts() {
        return accounts.stream();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return ((id == client.getId()) && (!firstName.equals(client.getFirstName())) && (!lastName.equals(client.getLastName())) && (age == client.getAge()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age);
    }
}
