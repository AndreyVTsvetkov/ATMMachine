package ru.sber.card.reader;


/**
 * Класс обеспечивает считывание информации с карты
 */
public class CardReader {
    public BankCardDetails readCard() {
        BankCardDetails bankcard = new BankCardDetails();
        bankcard.BankName = "Сбербанк";
        bankcard.CardNum = "0000 1234 4567 8900";

        return bankcard;
    }
}
