import java.util.ArrayList;
import java.util.List;

/*
 * AULA 4 - POLIMORFISMO
 *
 * "Muitas formas": uma variável do tipo da mãe pode guardar qualquer filha,
 * e o método executado é o do OBJETO REAL (decidido em tempo de execução).
 *
 * Isso permite escrever código que funciona para tipos que ainda nem existem.
 *
 * Bônus: SOBRECARGA (overload) = mesmo nome, parâmetros diferentes,
 * decidido em tempo de COMPILAÇÃO. Não confunda com SOBRESCRITA (override).
 */
public class Aula4Polimorfismo {

    static class Forma {
        public double area() { return 0; }
    }

    static class Retangulo extends Forma {
        private final double largura, altura;
        Retangulo(double largura, double altura) { this.largura = largura; this.altura = altura; }
        @Override public double area() { return largura * altura; }
    }

    static class Circulo extends Forma {
        private final double raio;
        Circulo(double raio) { this.raio = raio; }
        @Override public double area() { return Math.PI * raio * raio; }
    }

    // Este método não sabe (nem precisa saber) quais formas existem.
    static double areaTotal(List<Forma> formas) {
        double total = 0;
        for (Forma f : formas) {
            total += f.area(); // chama a área do Retangulo, do Circulo...
        }
        return total;
    }

    // Sobrecarga: mesmo nome, parâmetros diferentes.
    static String descrever(int x) { return "inteiro " + x; }
    static String descrever(String s) { return "texto " + s; }

    public static void main(String[] args) {
        List<Forma> formas = new ArrayList<>();
        formas.add(new Retangulo(2, 3));
        formas.add(new Circulo(1));
        formas.add(new Retangulo(1, 1));

        for (Forma f : formas) {
            System.out.printf("%s -> %.2f%n", f.getClass().getSimpleName(), f.area());
        }
        System.out.printf("Total: %.2f%n", areaTotal(formas)); // 10.14

        // Tipo da variável = Forma, objeto real = Circulo.
        Forma f = new Circulo(2);
        System.out.printf("Forma f = new Circulo(2) -> area %.2f%n", f.area()); // 12.57
        // f.raio  <- não compila: pela variável só se vê o que Forma tem.

        System.out.println(descrever(42));
        System.out.println(descrever("oi"));

        // Pergunta: Forma.area() retorna 0. Faz sentido existir "uma forma
        // genérica"? Não! A Aula 5 resolve com classe abstrata.
    }
}
