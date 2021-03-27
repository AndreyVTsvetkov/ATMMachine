package ru.sber.atm.processor;

import ru.sber.card.reader.CardReader;
import ru.sber.exchange.with.bank.ExchangeBank;
import ru.sber.visual.VisualDialog;

/**
 * Класс осуществляет управления процессом снятия наличных
 */
public class AtmProcessor {

    private boolean checkPin(int pin) {
        return true;
    }

    public void start() {
        int pin;
        AtmTransaction transaction = new AtmTransaction();
        //чтение карты
        CardReader reader = new CardReader();
        transaction.card = reader.readCard();
        //запрос Pin-кода
        VisualDialog dialog = new VisualDialog();
        pin = dialog.requestPin();
        transaction.checkPin = checkPin(pin);
        if (!transaction.checkPin) {
            System.out.println("Введен неверный Pin-код");
            return;
        }
        //запрашиваем действие
        transaction.actions = dialog.requestAction();
        //производим взаимодействие с банком
        ExchangeBank exchangeBank = new ExchangeBank();
        exchangeBank.SendToBank(transaction);
        //выводим результат
        if (transaction.actions == Actions.BALANCE) {
            dialog.viewBalance(transaction.balance);
        }
    }
    public boolean checkFunctionality() {
        return true;
    }


}
