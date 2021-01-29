package com.spedison.palestras.erroscomputacionais.a_somatercos;

public class MainSomaTercosFloat {

    public static void main(String[] args) {

        float soma = 0.0F;

        float value = 1.0F / 3.0F;

        for (int i = 0; i < 5000; i++) {
            soma += value;
            System.out.printf("Resultado da Soma %d - %28.26f\n", i + 1, soma);
        }
    }
}
