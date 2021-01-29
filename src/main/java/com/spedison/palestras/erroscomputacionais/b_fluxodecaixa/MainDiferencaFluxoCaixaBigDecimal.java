package com.spedison.palestras.erroscomputacionais.b_fluxodecaixa;

import javax.print.attribute.standard.PrinterName;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

public class MainDiferencaFluxoCaixaBigDecimal {

    public static void main(String[] args) {

        int tamanhoAmostra = 30_000;
        BigDecimal listaFloat[] = new BigDecimal[tamanhoAmostra];
        BigInteger listaInt[] = new BigInteger[tamanhoAmostra];
        Random rnd = new Random();
        MathContext mc = new MathContext(24, RoundingMode.CEILING); // Até 30K ... precisao de 24.
                                                                               // 300K .. 2.5 MILHÃO ... precisão de 28

        for (int i = 0; i < listaFloat.length; i++) {
            listaInt[i] =  BigInteger.valueOf(Math.abs(rnd.nextLong()));
            listaFloat[i] = new BigDecimal  (listaInt[i]).divide(BigDecimal.valueOf(100.0D), mc);
            System.out.printf("Gerando %d   %s\n", listaInt[i], listaFloat[i].toPlainString());
        }

        BigInteger somaInteiro = BigInteger.ZERO;
        BigDecimal somaFloat = new BigDecimal(0.0);

        for (int i = 0; i < listaFloat.length; i++) {
            System.out.printf("Somando %015d   %s\n", listaInt[i], listaFloat[i].toPlainString());
            somaFloat  = somaFloat.add(listaFloat[i], mc) ;
            somaInteiro = somaInteiro.add( listaInt[i] );
        }

        BigDecimal somaInteiroDiv100 = new BigDecimal(somaInteiro).divide(BigDecimal.valueOf(100.00), mc);

        System.out.printf("Soma dos inteiros       = %s\n", somaInteiro.toString());
        System.out.printf("Soma dos inteiros / 100 = %s\n", somaInteiroDiv100.toPlainString());
        System.out.printf("Soma do BigDecimal      = %s\n", somaFloat.toPlainString());

        BigDecimal diff = somaFloat.subtract(somaInteiroDiv100, mc);
        double diffAceitavel = 0.0001;

        System.out.println(diff.toPlainString());

        if (diff.compareTo( BigDecimal.valueOf(diffAceitavel)) < 0 || diff.compareTo( BigDecimal.valueOf(diffAceitavel)) == 0){
            System.out.println("Sucesso na soma");
        } else {
            System.out.println("Pensar sobre o Erro");
        }
    }
}
