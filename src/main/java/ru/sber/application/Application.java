package ru.sber.application;

import ru.sber.atm.processor.*;
import ru.sber.atm.processor.Card;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        //инициализация данных о клиентах, счетах и картах
        HashSet<Client> clients;
        HashMap<String, Account> accounts;
        HashMap<String, Card> cards;

        Card card = new Card("1234", "4276990012342999", new GregorianCalendar(2022, Calendar.JANUARY , 1), 123);
        BalanceOverdraft balance = new BalanceOverdraft(new BigDecimal(500), "RUR", new BigDecimal(1000));

        Account account = new Account("40702810130000033374", balance);
        account.addCard(card);

        Client client = new Client(1, "Иванов", "Иван", 25);
        client.addAccount(account);

        AtmProcessor atmprocessor = new AtmProcessor();
        clients = atmprocessor.getClients();
        clients.add(client);

        //запуск обработки
        atmprocessor.start();
    }
}
