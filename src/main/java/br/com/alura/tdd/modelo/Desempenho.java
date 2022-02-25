package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR("0.03"), BOM("0.15"), OTIMO("0.2");

    private final  String percentualReajuste;

    Desempenho(String percentualReajuste) {
        this.percentualReajuste = percentualReajuste;
    }

    public BigDecimal getPercentualReajuste() {
        return new BigDecimal(this.percentualReajuste);
    }

}
