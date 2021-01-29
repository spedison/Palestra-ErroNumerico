package com.spedison.palestras.erroscomputacionais.c_goldenratio;

public class MainGoldenRatioFloat {

    public static class Resultado {
        public int numeroPotencia;
        public float valorPotencia;
        public float valorIterado;

        @Override
        public String toString() {
            String ide = "Resultado{ Na potência %d temos o valor %29.27f e valor iterado %29.27f com erro de %29.27f }";
            String excel = "%d|%29.27f|%29.27f|%29.27f|%29.27f";
            return String.format(excel,
                    numeroPotencia,
                    (Math.abs(valorPotencia - valorIterado) / valorPotencia) * 100.00,
                    Math.abs(valorPotencia - valorIterado),
                    valorPotencia,
                    valorIterado
                    );
        }

        protected Resultado clone() {
            Resultado r = new Resultado();
            r.valorIterado = this.valorIterado;
            r.valorPotencia = this.valorPotencia;
            r.numeroPotencia = this.numeroPotencia;
            return r;
        }
    }

    private static float potenciaGoldenRatio(int pow) {
        float ratio = (float) (Math.sqrt(5.0F) / 2.0F) - (1.0F / 2.0F);
        return (float) Math.pow(ratio, pow);
    }

    private static Resultado calculaProximaIteracao(Resultado n, Resultado n_1) {
        /**
         * Resultado de N+1 = N-1 - N
         */
        Resultado resultado_m_p_1 = new Resultado();
        resultado_m_p_1.numeroPotencia = n.numeroPotencia + 1;
        resultado_m_p_1.valorPotencia = potenciaGoldenRatio(resultado_m_p_1.numeroPotencia);
        resultado_m_p_1.valorIterado = n_1.valorIterado - n.valorIterado;
        return resultado_m_p_1;
    }


    public static void main(String[] args) {
        System.out.printf("""
                                
                Iniciando em %s com %s iterações
                                
                """, args[0], args[1]);
        int potenciaInicial = Integer.parseInt(args[0]);
        int iteracoes = Integer.parseInt(args[1]);

        Resultado r_n = new Resultado();
        r_n.numeroPotencia = potenciaInicial;
        r_n.valorPotencia = potenciaGoldenRatio(potenciaInicial);
        r_n.valorIterado = r_n.valorPotencia;

        Resultado r_n_1 = new Resultado();
        r_n_1.numeroPotencia = potenciaInicial - 1;
        r_n_1.valorPotencia = potenciaGoldenRatio(potenciaInicial - 1);
        r_n_1.valorIterado = r_n_1.valorPotencia;


        for (int i = 0; i < iteracoes; i++) {
            Resultado n_p_1 = calculaProximaIteracao(r_n, r_n_1);
            System.out.println(n_p_1);
            r_n_1 = r_n.clone();
            r_n = n_p_1.clone();
        }

    }

}
