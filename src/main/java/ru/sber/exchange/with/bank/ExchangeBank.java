package ru.sber.exchange.with.bank;

import ru.sber.atm.processor.AtmTransaction;

public class ExchangeBank {
    public void sendToBank(AtmTransaction transaction) {
        transaction.setBalance(12);
    }
}
