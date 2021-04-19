package ru.sber.atm.processor;

import java.io.IOException;
import java.math.BigDecimal;

public class BalanceOverdraft extends Balance{
    private BigDecimal sumOverdraft;

    public BalanceOverdraft(BigDecimal sum, String isoCode, BigDecimal sumOverdraft) {
        super(sum, isoCode);
        this.sumOverdraft = sumOverdraft;
    }

    @Override
    public void debitSum(BigDecimal sum) throws IOException {
        BigDecimal resSum;
        resSum = getSum().subtract(sum).add(sumOverdraft);
        if (resSum.signum() == -1) {
            throw new IOException("Сумма превышает допустимую для списания");
        }
        super.debitSum(sum);
    }
}
