package ru.sber.atm.exchange.with.bank;

import ru.sber.atm.atm.processor.AtmTransaction;

public class ExchangeBank {
    public void sendToBank(AtmTransaction transaction) {
        transaction.setBalance(12);
    }
}
