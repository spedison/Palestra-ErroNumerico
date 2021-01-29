package com.spedison.palestras.erroscomputacionais;

import java.util.Arrays;

public class MainMostraNumeroFloat {

    /*
     * Como representar o número fracionário usando casas decimais flutuantes.(Escorregadias)
     *   Segundo Norma IEEE 754
     * */


    public static void main(String[] args) {

        Float f = 10.45F;

        System.out.println("Valor para analisar : " + f);

        /****
         *  1 Bit  Sinal
         *  8 Bits Expoente
         * 23 Bits Mantissa
         * ------ 32 Bits ---------
         */

        /* 1o bit -> 0 (Pois é positivo)
         *
         * */

        /***
         * Separa em parte inteira e decimal
         */
        Integer fi = f.intValue();
        Float fd = f - f.intValue();

        int valConv = fi;
        int valRef;
        String convInt = "";
        for (int i = 32; i >= 0; i--) {
            valRef = (int) Math.pow(2, i);
            if (valConv >= valRef) {
                valConv -= valRef;
                convInt += "1";
            } else {
                convInt += "0";
            }
        }


        /*** (Foi para 0.04)
         * Convertendo em binário temos :
         * 0001. Parte decimal ...
         * que é multiplicando por 2.
         *
         * 0.04 * 2 = 0.08 = (0) = 2^-01 = 0.5
         * 0.08 * 2 = 0.16 = (0) = 2^-02 = 0.25
         * 0.16 * 2 = 0.32 = (0) = 2^-03 = 0.125
         * 0.32 * 2 = 0.64 = (0) = 2^-04 = 0.0625
         * 0.64 * 2 = 1.28 = (1) = 2^-05 = 0.03125
         * 0.28 * 2 = 0.56 = (0) = 2^-06 = 0.015625
         * 0.56 * 2 = 1.12 = (1) = 2^-07 = 0.0078125
         * 0.12 * 2 = 0.24 = (0) = 2^-08 = 0.00390625
         * 0.24 * 2 = 0.48 = (0) = 2^-09 = 0.001953125
         * 0.48 * 2 = 0.96 = (0) = 2^-10 = 0.0009765625
         * 0.96 * 2 = 1.92 = (1) = 2^-11 = 0.00048828125
         * 0.92 * 2 = 1.84 = (1) = 2^-12 = 0.00024414062
         * 0.84 * 2 = 1.68 = (1) = 2^-13 = 0.00012207031
         */


        Float dec = fd;
        float soma = 0.0F;
        float valBase = 1;
        String convFloat = "";
        for (int i = 0; i < 32 && dec != 0.0F; i++) {

            valBase /= 2.0;
            dec *= 2.0F;

            if (dec >= 1.0F) {
                convFloat += "1";
                System.out.printf("Valor do bit 1 => %28.26f\n", valBase);
                soma += valBase;
            } else {
                System.out.printf("Valor do bit 0 => %28.26f\n", valBase);
                convFloat += "0";
            }
            dec -= dec.intValue();
        }

        System.out.printf("Bits Int %s Bits Float %s \n", convInt, convFloat);
        System.out.printf("Soma do valor: %20.18f\n", soma);

        System.out.printf("Diferença = > %20.18f", (Math.abs(soma - fd)));


        /**
         * Multiplicando por  2
         */


        System.out.println(f.byteValue());
    }

}
