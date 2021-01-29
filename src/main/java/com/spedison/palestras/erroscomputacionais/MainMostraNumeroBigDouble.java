package com.spedison.palestras.erroscomputacionais;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MainMostraNumeroBigDouble {

    /*
     * Como representar o número fracionário usando casas decimais flutuantes.(Escorregadias)
     *   Segundo Norma IEEE 754
     * */


    public static void main(String[] args) {

        BigDecimal f = new BigDecimal(args[0]);

        System.out.println("Valor para analisar : " + f.toPlainString());

        BigDecimal fi = new BigDecimal(f.intValue());
        BigDecimal fd = f.subtract(fi);

        BigDecimal valConv = new BigDecimal(fi.intValue());
        BigDecimal valRef ;
        String convInt = "";
        for (int i = 32; i >= 0; i--) {
            valRef = BigDecimal.valueOf(2);
            valRef = valRef.pow(i) ;
            if ( valConv.subtract(valRef).signum() > 0 || valConv.subtract(valRef).signum() == 0) {
                valConv = valConv.subtract(valRef) ;
                convInt += "1";
            } else {
                convInt += "0";
            }
        }

        BigDecimal dec = new BigDecimal( fd.doubleValue());
        System.out.printf("Soma do valor => %s\n", dec.toPlainString());
        BigDecimal soma = BigDecimal.ZERO;
        BigDecimal valBase = BigDecimal.ONE;
        String convFloat = "";
        for (int i = 0; i < 72 && dec.compareTo(BigDecimal.ZERO) != 0; i++) {

            valBase = valBase.divide(BigDecimal.valueOf(2.0));
            dec = dec.multiply(BigDecimal.valueOf(2.0)) ;

            if (dec.compareTo(BigDecimal.ONE) >= 0) {
                convFloat += "1";
                System.out.printf("Valor do bit 1 => %28.26f\n", valBase);
                soma = soma.add(valBase);
            } else {
                System.out.printf("Valor do bit 0 => %28.26f\n", valBase);
                convFloat += "0";
            }
            dec = dec.subtract(BigDecimal.valueOf(dec.intValue()));
            //dec -= dec.intValue();
        }

        System.out.printf("Bits %s . %s \n", convInt, convFloat);
        System.out.printf("Soma do valor = > %s\n", soma.toPlainString());
        System.out.printf("Diferença     = > %s", soma.subtract(fd).toPlainString());

    }

}
