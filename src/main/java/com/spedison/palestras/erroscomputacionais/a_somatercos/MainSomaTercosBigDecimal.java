package com.spedison.palestras.erroscomputacionais.a_somatercos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainSomaTercosBigDecimal {

    public static void main(String[] args) {

        BigDecimal soma = BigDecimal.ZERO;
        BigDecimal um = BigDecimal.ONE;
        BigDecimal tres = BigDecimal.valueOf(3.0);
        BigDecimal umTerco = um.divide(tres, 155, RoundingMode.CEILING);// .setScale(30, RoundingMode.FLOOR);

        for (int i = 0; i < 2E3; i++) {
            soma = soma.add(umTerco);
            System.out.printf("Resultado da Soma %d - %s\n", i + 1, soma.toPlainString());
        }
    }
}
