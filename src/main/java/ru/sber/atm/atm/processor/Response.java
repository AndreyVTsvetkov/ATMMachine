package ru.sber.atm.atm.processor;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Response {
    //так как используется анотация lombok "@Value",
    //то делать переменной объявление "private final" не нужно во избежание варнингов
    ErrorsCode errorsCode;
    BigDecimal balance;
    String account;
    String isoCode;

    public Response(final ErrorsCode errorsCode) {
        this.errorsCode = errorsCode;
        this.balance = new BigDecimal(0);
        this.account = "";
        this.isoCode = "";
    }

    public Response(final BigDecimal balance, final String account, final String isoCode) {
        this.errorsCode = ErrorsCode.NOT_ERROR;
        this.balance = balance;
        this.account = account;
        this.isoCode = isoCode;
    }
}
