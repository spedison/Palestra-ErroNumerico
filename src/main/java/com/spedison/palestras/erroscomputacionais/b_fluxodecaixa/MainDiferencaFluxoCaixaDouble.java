package com.spedison.palestras.erroscomputacionais.b_fluxodecaixa;

import java.util.Random;

public class MainDiferencaFluxoCaixaDouble {

    public static void main(String[] args) {

        int tamanhoAmostra = 200;
        double listaFloat[] = new double[tamanhoAmostra];
        long listaInt[] = new long[tamanhoAmostra];
        Random rnd = new Random();

        for (int i = 0; i < listaFloat.length; i++) {
            listaInt[i] =  ((long)Math.abs(rnd.nextInt()) + (10000L * Math.abs(rnd.nextInt()))); // COLOCAR + 3 Zeros.
            listaFloat[i] = ((double)listaInt[i])  / 100.0;
            System.out.printf("Gerando %028d   %028.20f\n", listaInt[i], listaFloat[i]);
        }

        long somaInteiro = 0;
        double somaFloat = 0.0F;

        for (int i = 0; i < listaFloat.length; i++) {
            somaFloat  += listaFloat[i] ;
            somaInteiro += listaInt[i] ;
        }
        double somaInteiroDiv100 = somaInteiro/100.0;
        System.out.printf("Soma dos inteiros / 100 = %28d\n", somaInteiro);
        System.out.printf("Soma dos inteiros / 100 = %28.20f\n", somaInteiroDiv100);
        System.out.printf("Soma do Double           = %28.20f\n", somaFloat);

        if (Math.abs(somaInteiroDiv100-somaFloat) < 0.001)
            System.out.println("Soma Funcionou !!");
        else
            System.out.println("Soma NÃO Funcionou :-(");

    }

}
