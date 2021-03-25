package ru.sber.atm.processor;

import lombok.Data;
import ru.sber.card.reader.BankCardDetails;

@Data
public class AtmTransaction {
    public BankCardDetails card;
    public boolean checkPin;
    public int sum;
    public Actions actions;
    public double balance;
    public int errorCode;
}
