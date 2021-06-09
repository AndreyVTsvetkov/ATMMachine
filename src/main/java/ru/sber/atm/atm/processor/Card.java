package ru.sber.atm.atm.processor;

import lombok.Value;
import java.util.Date;

/**
 * Класс служит для хранения реквизитов карты
 */

@Value
public class Card {
    //так как используется анотация lombok "@Value",
    //то делать переменной объявление "private final" не нужно во избежание варнингов
    Long id;
    int pinCode;
    String cardNum;
    Date dateEnd;
    int cvcCvv2Code;
}
