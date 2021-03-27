package ru.sber.card.reader;

import lombok.Data;

import java.util.Calendar;

/**
 * Класс служит для хранения реквизитов карты
 */

@Data
public class BankCardDetails {
    public String PinCode;
    public String BankName;
    public String CardNum;
    public Calendar DateEnd;
    public String UserName;
    public int CvcCvv2Code;
}
