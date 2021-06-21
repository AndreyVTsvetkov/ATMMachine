package ru.sber.atm.atm.processor;

import java.io.IOException;
import java.math.BigDecimal;

public class BalanceWithoutOverdraft extends Balance{
    public BalanceWithoutOverdraft(BigDecimal sum, String isoCode) {
        super(sum, isoCode);
    }

    @Override
    public void debitSum(BigDecimal sum) throws IOException {
        BigDecimal resSum;
        resSum = getSum().subtract(sum);
        if (resSum.signum() == -1) {
            throw new IOException("Сумма превышает допустимую для списания");
        }
        super.debitSum(sum);
    }
}
