package com.spedison.palestras.erroscomputacionais;

public class MainMontaTabela {

    /*
     * Como representar o número fracionário usando casas decimais flutuantes.(Escorregadias)
     *   Segundo Norma IEEE 754
     * */


    public static void main(String[] args) {

        for (int i = 1; i < 32 ; i++) {
            System.out.printf("%d ; %28.26f\n", i , Math.pow(2, -i));
        }

    }

}
