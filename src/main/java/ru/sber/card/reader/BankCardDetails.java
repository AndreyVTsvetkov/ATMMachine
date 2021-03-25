package ru.sber.card.reader;

import lombok.Data;

import java.util.Calendar;

/**
 * Класс служит для хранения реквизитов карты
 */

@Data
public class BankCardDetails {
    String PinCode;
    String BankName;
    String CardNum;
    Calendar DateEnd;
    String UserName;
    int CvcCvv2Code;
}
