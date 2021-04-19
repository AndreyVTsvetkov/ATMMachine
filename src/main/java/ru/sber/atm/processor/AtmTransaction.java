package ru.sber.atm.processor;

import lombok.Data;

@Data
public class AtmTransaction {
    private Card card;
    private boolean checkPin;
    private int sum;
    private Actions actions;
    private double balance;
    private int errorCode;
}
