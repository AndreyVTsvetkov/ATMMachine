package ru.sber.atm.atm.processor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@EqualsAndHashCode
public class Client <T extends Account<Balance>> {
    @Getter
    private final Long id;
    @Getter
    private final String firstName;
    @Getter
    private final String lastName;
    @Getter
    private final int age;

    private final List<T> accounts;

    public Stream<T> accountsStream() {
        return accounts.stream();
    }
}
