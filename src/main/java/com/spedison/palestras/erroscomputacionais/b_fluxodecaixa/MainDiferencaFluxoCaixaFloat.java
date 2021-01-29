package com.spedison.palestras.erroscomputacionais.b_fluxodecaixa;

import java.util.Random;

public class MainDiferencaFluxoCaixaFloat {

    public static void main(String[] args) {

        int tamanhoAmostra = 1000;
        float listaFloat[] = new float[tamanhoAmostra];
        int listaInt[] = new int[tamanhoAmostra];
        Random rnd = new Random();
        for (int i = 0; i < listaFloat.length; i++) {
            listaInt[i] =  Math.abs(rnd.nextInt(99999)); // Teste com +4 noves.
            listaFloat[i] = listaInt[i] ;
            listaFloat[i] /= 100.0F ;
            System.out.printf("Gerando %d   %28.20f\n", listaInt[i], listaFloat[i]);
        }

        long somaInteiro = 0;
        float somaFloat = 0.0F;

        for (int i = 0; i < listaFloat.length; i++) {
            System.out.printf("Somando %d   %28.20f\n", listaInt[i], listaFloat[i]);
            somaFloat  += listaFloat[i] ;
            somaInteiro += listaInt[i] ;
        }
        float somaInteiroDiv100 = somaInteiro/100.0F;
        System.out.printf("Soma dos inteiros       = % 28d\n",   somaInteiro);
        System.out.printf("Soma dos inteiros / 100 = %28.20f\n", somaInteiroDiv100);
        System.out.printf("Soma do Float           = %28.20f\n", somaFloat);

        if (Math.abs(somaInteiroDiv100 - somaFloat) <= 0.001F){
            System.out.println("Passou a soma - Funcionou");
        } else {
            System.out.println("Soma NÃO Funcionou");
        }

    }

}
