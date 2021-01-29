package com.spedison.palestras.erroscomputacionais.f_final;

public class MainErroDouble {

    public static void main(String[] args) {

        /***
         * FLOAT RANGE  : 3.40282347 x 1E38          a 1.40239846 x 1E-45
         * DOUBLE RANGE : 1.797_693_134_862_315_7 x 1E308 a 4.940_656_458_412_465_4 x 1E-324
         */

        double a = 1_000_000_000.000_000_1;
        double b = a - 1_000_000_000.0;
        System.out.println("A = %28.27f | B = %28.27f".formatted(a, b));
    }

}
