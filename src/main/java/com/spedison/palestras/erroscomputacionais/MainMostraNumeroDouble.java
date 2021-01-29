package com.spedison.palestras.erroscomputacionais;

public class MainMostraNumeroDouble {

    /*
     * Como representar o número fracionário usando casas decimais flutuantes.(Escorregadias)
     *   Segundo Norma IEEE 754
     * */


    public static void main(String[] args) {

        Double f = Double.parseDouble(args[0]);

        System.out.println("Valor para analisar : " + f);

        Integer fi = f.intValue();
        Double fd = f - f.intValue();

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

        Double dec = fd;
        Double soma = 0.0;
        Double valBase = 1.0;
        String convFrac = "";
        for (int i = 0; i < 64 && dec != 0.0F; i++) {

            valBase /= 2.0;
            dec *= 2.0;

            if (dec >= 1.0F) {
                convFrac += "1";
                System.out.printf("Valor do bit 1 => %28.26f\n", valBase);
                soma += valBase;
            } else {
                System.out.printf("Valor do bit 0 => %28.26f\n", valBase);
                convFrac += "0";
            }
            dec -= dec.intValue();
        }

        System.out.printf("Bits Int %s Bits Float %s \n", convInt, convFrac);
        System.out.printf("Soma Decomposição = > %20.18f\n", soma);
        System.out.printf("Valor             = > %20.18f\n", fd);
        System.out.printf("Diferença         = > %20.18f\n", (Math.abs(soma - fd)));
        System.out.printf("\n---------\n" +
                          "Valor Inteiro    = > %d\n", fi);
        System.out.printf("\n---------\n" +
                "Valor atribuído           = > %20.18f\n", f);

    }

}
