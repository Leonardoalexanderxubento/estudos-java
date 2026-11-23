import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/*
 * EXERCÍCIOS DE POO
 *
 * Troque cada "throw new UnsupportedOperationException(...)" pela sua
 * implementação e rode de novo. O corretor no fim do arquivo diz o que
 * passou. Travou? Releia a aula indicada. Ainda travou? Veja solucoes/.
 */
public class Exercicios {

    // ---------- EXERCÍCIO 1 (Aulas 1 e 2): encapsulamento ----------
    // Retângulo com largura e altura PRIVADAS.
    // - O construtor deve lançar IllegalArgumentException se algum lado for <= 0.
    // - area() = largura * altura;  perimetro() = 2 * (largura + altura)
    static class Retangulo {
        // TODO: declare os atributos

        Retangulo(double largura, double altura) {
            throw new UnsupportedOperationException("TODO");
        }

        double area() { throw new UnsupportedOperationException("TODO"); }

        double perimetro() { throw new UnsupportedOperationException("TODO"); }
    }

    // ---------- EXERCÍCIO 2 (Aula 3): herança ----------
    // Conta já está pronta. Faça ContaPoupanca ESTENDER Conta (troque a linha
    // da classe) e implemente renderMes(): saldo += saldo * taxaMensal.
    static class Conta {
        protected double saldo;
        Conta(double saldoInicial) { this.saldo = saldoInicial; }
        double getSaldo() { return saldo; }
    }

    static class ContaPoupanca /* TODO: extends ... */ {
        ContaPoupanca(double saldoInicial, double taxaMensal) {
            throw new UnsupportedOperationException("TODO: chame super(...) e guarde a taxa");
        }

        void renderMes() { throw new UnsupportedOperationException("TODO"); }

        double getSaldo() { throw new UnsupportedOperationException("TODO: apague este método, ele vem de Conta"); }
    }

    // ---------- EXERCÍCIO 3 (Aulas 4 e 5): polimorfismo + abstração ----------
    // Pagamento é abstrato. Implemente taxa() em cada filha:
    //   Pix: 0     Cartao: 3% do valor     Boleto: 2.50 fixo
    // e somaTotais(), que soma total() de qualquer lista de pagamentos.
    static abstract class Pagamento {
        protected final double valor;
        Pagamento(double valor) { this.valor = valor; }
        abstract double taxa();
        double total() { return valor + taxa(); }
    }

    static class Pix extends Pagamento {
        Pix(double valor) { super(valor); }
        @Override double taxa() { throw new UnsupportedOperationException("TODO"); }
    }

    static class Cartao extends Pagamento {
        Cartao(double valor) { super(valor); }
        @Override double taxa() { throw new UnsupportedOperationException("TODO"); }
    }

    static class Boleto extends Pagamento {
        Boleto(double valor) { super(valor); }
        @Override double taxa() { throw new UnsupportedOperationException("TODO"); }
    }

    static double somaTotais(List<Pagamento> pagamentos) {
        throw new UnsupportedOperationException("TODO");
    }

    // ---------- EXERCÍCIO 4 (Aula 5): interface Comparable ----------
    // Implemente compareTo para ordenar da MAIOR nota para a MENOR.
    // Dica: Double.compare(a, b) retorna negativo, 0 ou positivo.
    static class Aluno implements Comparable<Aluno> {
        final String nome;
        final double nota;
        Aluno(String nome, double nota) { this.nome = nome; this.nota = nota; }

        @Override
        public int compareTo(Aluno outro) {
            throw new UnsupportedOperationException("TODO");
        }
    }

    // ---------- EXERCÍCIO 5 (Aula 6): equals e hashCode ----------
    // Dois Pontos com mesmo x e y devem ser iguais, inclusive dentro de um HashSet.
    static final class Ponto {
        final int x, y;
        Ponto(int x, int y) { this.x = x; this.y = y; }

        @Override
        public boolean equals(Object o) {
            throw new UnsupportedOperationException("TODO");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("TODO");
        }
    }

    // ===================== CORRETOR (não precisa mexer) =====================

    static void verificar(boolean condicao, String mensagem) {
        if (!condicao) throw new AssertionError(mensagem);
    }

    static boolean perto(double a, double b) { return Math.abs(a - b) < 1e-9; }

    static void ex1() {
        Retangulo r = new Retangulo(2, 3);
        verificar(perto(r.area(), 6), "area de 2x3 deveria ser 6, deu " + r.area());
        verificar(perto(r.perimetro(), 10), "perimetro de 2x3 deveria ser 10, deu " + r.perimetro());
        try {
            new Retangulo(-1, 3);
            throw new AssertionError("new Retangulo(-1, 3) deveria lançar IllegalArgumentException");
        } catch (IllegalArgumentException esperado) { /* ok */ }
    }

    static void ex2() {
        verificar(Conta.class.isAssignableFrom(ContaPoupanca.class), "ContaPoupanca deve estender Conta");
        ContaPoupanca p = new ContaPoupanca(1000, 0.01);
        p.renderMes();
        verificar(perto(p.getSaldo(), 1010), "depois de 1 mês a 1% deveria ter 1010, tem " + p.getSaldo());
        p.renderMes();
        verificar(perto(p.getSaldo(), 1020.1), "juros compostos: deveria ter 1020.1, tem " + p.getSaldo());
    }

    static void ex3() {
        verificar(perto(new Pix(100).total(), 100), "Pix de 100 deveria custar 100");
        verificar(perto(new Cartao(100).total(), 103), "Cartao de 100 deveria custar 103");
        verificar(perto(new Boleto(100).total(), 102.5), "Boleto de 100 deveria custar 102.5");
        List<Pagamento> lista = Arrays.<Pagamento>asList(new Pix(10), new Cartao(100), new Boleto(10));
        double soma = somaTotais(lista);
        verificar(perto(soma, 125.5), "somaTotais deveria ser 125.5, deu " + soma);
    }

    static void ex4() {
        List<Aluno> turma = new ArrayList<>(Arrays.asList(
                new Aluno("Ana", 7), new Aluno("Bia", 9.5), new Aluno("Caio", 5)));
        Collections.sort(turma); // usa o seu compareTo
        verificar(turma.get(0).nome.equals("Bia") && turma.get(2).nome.equals("Caio"),
                "ordem esperada: Bia, Ana, Caio (maior nota primeiro)");
    }

    static void ex5() {
        verificar(new Ponto(1, 2).equals(new Ponto(1, 2)), "Ponto(1,2) deveria ser igual a Ponto(1,2)");
        verificar(!new Ponto(1, 2).equals(new Ponto(2, 1)), "Ponto(1,2) NÃO deveria ser igual a Ponto(2,1)");
        Set<Ponto> set = new HashSet<>(Arrays.asList(new Ponto(0, 0), new Ponto(0, 0), new Ponto(1, 1)));
        verificar(set.size() == 2, "HashSet deveria ter 2 pontos, tem " + set.size() + " (faltou hashCode?)");
    }

    public static void main(String[] args) {
        Runnable[] exercicios = { Exercicios::ex1, Exercicios::ex2, Exercicios::ex3, Exercicios::ex4, Exercicios::ex5 };
        int ok = 0;
        for (int i = 0; i < exercicios.length; i++) {
            try {
                exercicios[i].run();
                System.out.println("[OK]    Exercício " + (i + 1));
                ok++;
            } catch (UnsupportedOperationException e) {
                System.out.println("[TODO]  Exercício " + (i + 1) + " ainda não foi feito");
            } catch (Throwable e) {
                System.out.println("[ERRO]  Exercício " + (i + 1) + ": " + e.getMessage());
            }
        }
        System.out.println(ok + "/" + exercicios.length + " exercícios corretos");
    }
}
