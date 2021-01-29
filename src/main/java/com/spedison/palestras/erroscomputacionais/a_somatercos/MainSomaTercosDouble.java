package com.spedison.palestras.erroscomputacionais.a_somatercos;

public class MainSomaTercosDouble {

    public static void main(String[] args) {

        double soma = 0.0;

        double value = 1.0 / 3.0;

        for (int i = 0; i < 100; i++) {
            soma += value;
            System.out.printf("Resultado da Soma %d - %28.26f\n", i + 1, soma);
        }
    }
}
