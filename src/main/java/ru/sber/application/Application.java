package ru.sber.application;

import ru.sber.atm.processor.AtmProcessor;

public class Application {
    public static void main(String[] args) {
        AtmProcessor atmprocessor = new AtmProcessor();
        atmprocessor.start();
    }
}
