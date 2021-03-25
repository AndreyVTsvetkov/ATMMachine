package ru.sber.visual;

import ru.sber.atm.processor.Actions;

import java.util.Scanner;

public class VisualDialog {
    public int requestPin() {
        System.out.println("Введите пин код...");
        Scanner console = new Scanner(System.in);
        return console.nextInt();
    }
    public int requestSum() {
        System.out.println("Введите сумму в рублях");
        Scanner console = new Scanner(System.in);
        return console.nextInt();
    }
    public Actions requestAction() {
        int actions;
        System.out.println("Введите необходимое действие (0 - снять наличные; 1 - внести наличные; 2 - получить баланс)");
        Scanner console = new Scanner(System.in);
        actions = console.nextInt();
        switch (actions) {
            case 0: return Actions.GET_AMOUNT;
            case 1: return Actions.DEPOSIT_AMOUNT;
            default: return Actions.BALANCE;
        }
    }

    public void viewBalance(double sum) {
        System.out.println("Текущий баланс: " + sum);
    }
}
