package test03;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class Teste3 {
    static class Faturamento {
        public int dia;
        public double valor;
    }

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = Teste3.class.getClassLoader().getResourceAsStream("faturamento.json");

        if (is == null) {
            throw new IllegalArgumentException("Arquivo não encontrado no classpath!");
        }

        List<Faturamento> faturamentos = List.of(mapper.readValue(is, Faturamento[].class));

        double soma = 0, min = Double.MAX_VALUE, max = Double.MIN_VALUE;
        int diasValidos = 0;

        for (Faturamento f : faturamentos) {
            if (f.valor > 0) {
                soma += f.valor;
                diasValidos++;
                if (f.valor < min) min = f.valor;
                if (f.valor > max) max = f.valor;
            }
        }

        double media = soma / diasValidos;
        long diasAcimaMedia = faturamentos.stream().filter(f -> f.valor > media).count();

        System.out.printf("Menor faturamento: R$ %.2f\n", min);
        System.out.printf("Maior faturamento: R$ %.2f\n", max);
        System.out.println("Dias acima da média: " + diasAcimaMedia);
    }
}
