package ru.sber.atm.atm.processor;

import lombok.Getter;

import java.io.IOException;
import java.math.BigDecimal;

public class Balance {
    @Getter
    private BigDecimal sum;
    @Getter
    private String isoCode;

    public Balance(BigDecimal sum, String isoCode){
      this.sum = sum;
      this.isoCode = isoCode;
    }

    public void debitSum(BigDecimal sum) throws IOException {
      this.sum = this.sum.subtract(sum);
    }

    public void creditSum(BigDecimal sum) {
      this.sum = this.sum.add(sum);
    }
}
