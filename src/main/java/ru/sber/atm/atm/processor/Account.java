package ru.sber.atm.atm.processor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@EqualsAndHashCode
public class Account <T extends Balance> {
    @Getter
    private final Long id;
    @Getter
    private final String accountNum;
    @Getter
    private final T balance;

    private final List<Card> cards;



    public Stream<Card> cardsStream() {
        return cards.stream();
    }
}
