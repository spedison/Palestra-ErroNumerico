package com.spedison.palestras.erroscomputacionais.d_comutacao;

public class MainComutacaoFloat {

    public static void main(String[] args) {

        float a =     10.000_7F;
        float b = 11_000.000_065_5F ;
        float c =      1.945F;
        float v1 ;
        float v2 ;
        float somaReal      = 11_011.9457655F;
        float subtracaoReal = 10_988.054_365F;
        float diff;

        v1 = (a + b) + c;
        v2 = a + (b + c);
        diff = v1 - v2;
        float erro_v1 = Math.abs(v1 - somaReal);
        float erro_v2 = Math.abs(v2 - somaReal);
        System.out.println(
                "V1  = %28.20f   |   V2 = %28.20f  |  DIF = %28.20f | ERRO V1 = %28.20f  |  ERRO V2 = %28.20f".
                        formatted(v1, v2, diff, erro_v1, erro_v2));

        v1 = (b - a) - c;
        v2 = b - (a + c);
        double v3 = b +  a * (-1.0) + c * (-1.0);
        /***
         * Provável hipótese:
         * "a" e "c" tem valores mais próximos ( em ordem de grandeza ) entre si, do que de b
         * ao subtrair "a" de "b" gera-se um erro maior.
         */
        diff = Math.abs(v1 - v2);
        erro_v1 = Math.abs(v1 - subtracaoReal);
        erro_v2 = Math.abs(v2 - subtracaoReal);
        double erro_v3 = Math.abs(v3 - subtracaoReal);
        System.out.println(
                "V1  = %28.20f   |   V2 = %28.20f  |  DIF = %28.20f | ERRO V1 = %28.20f  |  ERRO V2 = %28.20f  |  ERRO V3 = %28.20f".
                        formatted(v1, v2, diff, erro_v1, erro_v2, erro_v3));
    }

}
