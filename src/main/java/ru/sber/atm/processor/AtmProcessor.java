package ru.sber.atm.processor;

import lombok.Getter;
import ru.sber.visual.VisualDialog;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

/**
 * Класс осуществляет управления процессом снятия наличных
 */
public class AtmProcessor {
    @Getter
    private HashSet<Client> clients = new HashSet<>();

    public void start() {

        String cardNum;
        String pin;
        int year;
        int month;
        Client client;
        Account account;
        Card findCard;
        AtmTransaction transaction = new AtmTransaction();

        VisualDialog dialog = new VisualDialog();
        //запрос номера карты
        cardNum = dialog.requestCardNum();
        //проверяем введенный номер карты на корректность
        if (cardNum.isEmpty()) {
            System.out.println("Номер карты не введен");
            return;
        }
        if (cardNum.length() != 16) {
            System.out.println("Номер карты введен не корректно");
            return;
        }
        if (!cardNum.matches("^-?\\d+$")) {
            System.out.println("Номер карты должен состоять из цифр");
            return;
        }
        //ищем карту
        boolean res;
        if (clients.stream().noneMatch(cl -> cl.getAccounts().anyMatch(acc -> acc.getCards().anyMatch(card -> card.getCardNum().equalsIgnoreCase(cardNum))))) {
            System.out.println("Карта с номером " + cardNum + " не найдена");
            return;
        }
        //если карта найдена, то получаем класс Card
        client = clients.stream().filter(cl -> cl.getAccounts().anyMatch(acc -> acc.getCards().anyMatch(card -> card.getCardNum().equalsIgnoreCase(cardNum)))).findFirst().get();
        account = client.getAccounts().filter(acc -> acc.getCards().anyMatch(card -> card.getCardNum().equalsIgnoreCase(cardNum))).findFirst().get();
        findCard = account.getCards().filter(card -> card.getCardNum().equalsIgnoreCase(cardNum)).findFirst().get();

        //запрос Pin-кода
        pin = dialog.requestPin();
        if (pin.isEmpty()) {
            System.out.println("ПИН-код карты не введен");
            return;
        }
        if (pin.length() != 4) {
            System.out.println("ПИН-код карты введен некорректно");
            return;
        }
        if (!pin.matches("^-?\\d+$")) {
            System.out.println("ПИН-код карты должен состоять из цифр");
            return;
        }

        if (pin.compareTo(findCard.getPinCode()) != 0) {
            System.out.println("Не верный ПИН-код карты");
            return;
        }

        year = dialog.requestYearOfValidityPeriod();
        month = dialog.requestMonthOfValidityPeriod();

        if (findCard.getDateEnd().compareTo(new GregorianCalendar(year, month - 1, 1)) != 0) {
            System.out.println("Срок окончания действия карты введен неверно");
            return;
        }

        System.out.println("Баланс счета: " + account.getBalance().getSum().toString() + " валюта: " + account.getBalance().getIsoCode());
    }
}
