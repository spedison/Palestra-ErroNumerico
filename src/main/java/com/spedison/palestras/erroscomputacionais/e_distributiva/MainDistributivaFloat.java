package com.spedison.palestras.erroscomputacionais.e_distributiva;

public class MainDistributivaFloat {

    public static void main(String[] args) {

        float a =     10.000_7F;
        float b = 11_000.000_065_5F ; //  a + b = 11_010.000_765
        float c =      1.945F;
        float v1 ;
        float v2 ;
        float produtoReal = 21_414.451_487_925F;
        float diff;

        v1 = (a + b) * c;
        v2 = (a * c) + (b * c);
        diff = v1 - v2;
        float erro_v1 = Math.abs(v1 - produtoReal);
        float erro_v2 = Math.abs(v2 - produtoReal);
        System.out.println(
                "V1  = %28.20f   |   V2 = %28.20f  |  DIF = %28.20f | ERRO V1 = %28.20f  |  ERRO V2 = %28.20f".
                        formatted(v1, v2, diff, erro_v1, erro_v2));

        /***
         * Quanto maior a distância dos números que multiplicamos, maior o erro encontrado...
         */

    }

}
