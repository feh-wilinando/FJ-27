package br.com.caelum.fj27.loja.models;

import java.math.BigDecimal;

/**
 * Created by nando on 06/07/17.
 */
public class PaymentData {
    private final BigDecimal value;

    public PaymentData(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
