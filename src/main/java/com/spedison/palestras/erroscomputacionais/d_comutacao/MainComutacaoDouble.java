package com.spedison.palestras.erroscomputacionais.d_comutacao;

public class MainComutacaoDouble {

    public static void main(String[] args) {

        double a =     10.000_7;
        double b = 11_000.000_065_5 ;
        double c =      1.945;
        double v1 ;
        double v2 ;
        double somaReal      = 11_011.9457655;
        double subtracaoReal = 10_988.054_365;
        double diff;

        v1 = (a + b) + c;
        v2 = a + (b + c);
        diff = v1 - v2;
        double erro_v1 = Math.abs(v1 - somaReal);
        double erro_v2 = Math.abs(v2 - somaReal);
        System.out.println(
                "V1  = %28.20f   |   V2 = %28.20f  |  DIF = %28.20f | PRECISAO V1 = %28.20f  |  PRECISAO V2 = %28.20f".
                        formatted(v1, v2, diff, erro_v1, erro_v2));

        v1 = (b - a) - c;
        v2 = b - (a + c);
        /***
         * Provável hipótese:
         * "a" e "c" tem valores mais próximos ( em ordem de grandeza ) entre si, do que de b
         * ao subtrair "a" de "b" gera-se um erro maior.
         */
        diff = Math.abs(v1 - v2);
        erro_v1 = Math.abs(v1 - subtracaoReal);
        erro_v2 = Math.abs(v2 - subtracaoReal);
        System.out.println(
                "V1  = %28.20f   |   V2 = %28.20f  |  DIF = %28.20f | ERRO V1 = %28.20f  |  ERRO V2 = %28.20f".
                        formatted(v1, v2, diff, erro_v1, erro_v2));
    }

}
