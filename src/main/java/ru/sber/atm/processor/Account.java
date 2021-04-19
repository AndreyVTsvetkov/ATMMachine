package ru.sber.atm.processor;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.stream.Stream;

public class Account {
    @Getter @Setter
    private String accountNum;
    @Getter @Setter
    private Balance balance;
    private HashSet<Card> cards = new HashSet<>();

    public Account(String accountNum, Balance balance) {
        this.accountNum = accountNum;
        this.balance = balance;
    }
    public void addCard(Card card) {
        cards.add(card);
    }

    public Stream<Card> getCards() {
        return cards.stream();
    }
}
