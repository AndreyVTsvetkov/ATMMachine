package ru.sber.exchange.with.bank;

import ru.sber.atm.processor.AtmTransaction;

public class ExchangeBank {
    public void SendToBank(AtmTransaction transaction) {
        transaction.balance = 12;
    }
}
