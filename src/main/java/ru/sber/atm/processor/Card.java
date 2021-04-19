package ru.sber.atm.processor;

import lombok.Data;

import java.util.Calendar;

/**
 * Класс служит для хранения реквизитов карты
 */

@Data
public class Card {
    private String pinCode;
    private String cardNum;
    private Calendar dateEnd;
    private int cvcCvv2Code;

    public Card(String pinCode, String cardNum, Calendar dateEnd, int cvcCvv2Code) {
        this.pinCode = pinCode;
        this.cardNum = cardNum;
        this.dateEnd = dateEnd;
        this.cvcCvv2Code = cvcCvv2Code;
    }
}
