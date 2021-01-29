package com.spedison.palestras.erroscomputacionais.c_goldenratio;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class MainGoldenRatioBigDecimal {

    public static class Resultado {
        public int numeroPotencia;
        public BigDecimal valorPotencia;
        public BigDecimal valorIterado;
        public MathContext mc;
        public boolean modoExcel;

        public double pegaDiferencaPercentual() {
            return valorPotencia.subtract(valorIterado).
                    abs(mc).
                    divide(valorPotencia, mc).
                    multiply(BigDecimal.valueOf(100.0), mc).doubleValue();
        }

        @Override
        public String toString() {
            String humano = "Resultado { Na potência %d com erro percentual %s e erro absoluto de %s temos o valor %s e valor iterado %s }";
            String excel = "%d|%s|%s|%s|%s";
            String formato;

            if(modoExcel)
                formato = excel;
            else
                formato = humano;

            return String.format(formato,
                    numeroPotencia,
                    valorPotencia.subtract(valorIterado).
                            abs(mc).
                            divide(valorPotencia, mc).
                            multiply(BigDecimal.valueOf(100.0), mc).
                            toPlainString().replace(".", ","),
                    valorPotencia.subtract(valorIterado).abs(mc).toPlainString().replace(".", ","),
                    valorPotencia.toPlainString().replace(".", ","),
                    valorIterado.toPlainString().replace(".", ","));
        }

        protected Resultado clone() {
            Resultado r = new Resultado();
            r.valorIterado = this.valorIterado;
            r.valorPotencia = this.valorPotencia;
            r.numeroPotencia = this.numeroPotencia;
            r.mc = this.mc;
            return r;
        }
    }

    private static BigDecimal potenciaGoldenRatio(int pow, MathContext mc) {
        BigDecimal raiz = BigDecimal.valueOf(5.0);
        raiz = raiz.sqrt(mc);
        raiz = raiz.divide(BigDecimal.valueOf(2.0), mc);
        BigDecimal meio = BigDecimal.valueOf(0.5);
        return raiz.subtract(meio, mc).pow(pow);
    }

    private static Resultado calculaProximaIteracao(Resultado n, Resultado n_1) {
        /**
         * Resultado de N+1 = N-1 - N
         */
        Resultado resultado_m_p_1 = new Resultado();
        resultado_m_p_1.mc = n.mc;
        resultado_m_p_1.numeroPotencia = n.numeroPotencia + 1;
        resultado_m_p_1.valorPotencia = potenciaGoldenRatio(resultado_m_p_1.numeroPotencia, n.mc);
        resultado_m_p_1.valorIterado = n_1.valorIterado.subtract(n.valorIterado, n.mc);
        return resultado_m_p_1;
    }


    public static void main(String[] args) {
        for (int scale = Integer.parseInt(args[0]); scale <= Integer.parseInt(args[1]); scale++){
            main2(args[2], "20000000", Integer.toString(scale,10), Boolean.valueOf(false).toString() , "Excel" );
        }
    }

    public static void main2(String ... args) {

        int potenciaInicial = Integer.parseInt(args[0]);
        int iteracoes = Integer.parseInt(args[1]);
        int scale = Integer.parseInt(args[2]);
        boolean mostraValores = Boolean.parseBoolean(args[3]);
        boolean modoExcel = args[4].trim().compareToIgnoreCase("Excel") == 0;
        long startTime = System.currentTimeMillis();

        if (mostraValores)
            System.out.printf("""
                                    
                    Iniciando em %s com %s iterações com Precisão
                                    
                    """, args[0], args[1], args[3], args[4]);

        /***
         * Ordem dos parâmetros:
         * 0 - Potência inicial
         * 1 - Número máximo de iterações
         * 2 - Escala Usada
         * 3 - Se mostra os resultados durante as iterações
         * 4 - Se Imprime Humano ou para Excel
         */

        MathContext mc = new MathContext(scale, RoundingMode.FLOOR);

        Resultado r_n = new Resultado();
        r_n.mc = mc;
        r_n.numeroPotencia = potenciaInicial;
        r_n.valorPotencia = potenciaGoldenRatio(potenciaInicial, mc);
        r_n.valorIterado = potenciaGoldenRatio(potenciaInicial, mc);

        Resultado r_n_1 = new Resultado();
        r_n_1.mc = mc;
        r_n_1.numeroPotencia = potenciaInicial - 1;
        r_n_1.valorPotencia = potenciaGoldenRatio(potenciaInicial - 1, mc);
        r_n_1.valorIterado = potenciaGoldenRatio(potenciaInicial - 1, mc);

        int i = 0;
        for (; i < iteracoes; i++) {
            Resultado n_p_1 = calculaProximaIteracao(r_n, r_n_1);
            if (mostraValores) {
                n_p_1.modoExcel = modoExcel;
                System.out.println(n_p_1);
            }
            r_n_1 = r_n.clone();
            r_n = n_p_1.clone();

            if (r_n.pegaDiferencaPercentual() > 5.0)
                break;
        }

        long endTime = System.currentTimeMillis();
        long diffTime = endTime - startTime;

        String humano = "Precisão %d Foram executados %d iterações - demorou %d milis e gastou %15.4f milis / iterações";
        String excel = "%d|%d|%d|%15.4f";
        String formato = modoExcel ? excel : humano;
        System.out.println(formato.formatted(scale, i, diffTime, (double) diffTime / (double) i ));

    }
}
