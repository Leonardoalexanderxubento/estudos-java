import java.util.ArrayList;
import java.util.Arrays;

/*
 * SOLUÇÕES dos exercícios básicos. Só olhe depois de tentar!
 */
public class ExerciciosBasico {

    // EXERCÍCIO 1 (Básico 1): média de duas notas.
    static double media(double n1, double n2) {
        return (n1 + n2) / 2;
    }

    // EXERCÍCIO 2 (Básico 2): situação do aluno.
    static String situacao(double media) {
        if (media >= 6) return "APROVADO";
        else if (media >= 4) return "RECUPERACAO";
        else return "REPROVADO";
    }

    // EXERCÍCIO 3 (Básico 2): maior de três números.
    static int maiorDeTres(int a, int b, int c) {
        int maior = a;
        if (b > maior) maior = b;
        if (c > maior) maior = c;
        return maior;
    }

    // EXERCÍCIO 4 (Básico 2): fatorial com laço.
    static long fatorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) resultado *= i;
        return resultado;
    }

    // EXERCÍCIO 5 (Básico 3): quantos números pares existem no array.
    static int contarPares(int[] numeros) {
        int contador = 0;
        for (int n : numeros) {
            if (n % 2 == 0) contador++;
        }
        return contador;
    }

    // EXERCÍCIO 6 (Básico 3): inverter uma String.
    static String inverter(String texto) {
        String invertido = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            invertido += texto.charAt(i);
        }
        return invertido;
    }

    // EXERCÍCIO 7 (Básico 3): nomes que começam com a letra dada.
    static ArrayList<String> filtrarPorInicial(ArrayList<String> nomes, char inicial) {
        ArrayList<String> resultado = new ArrayList<>();
        for (String nome : nomes) {
            if (nome.charAt(0) == inicial) resultado.add(nome);
        }
        return resultado;
    }

    // ===================== CORRETOR (não precisa mexer) =====================

    static void verificar(boolean condicao, String mensagem) {
        if (!condicao) throw new AssertionError(mensagem);
    }

    static boolean perto(double a, double b) { return Math.abs(a - b) < 1e-9; }

    static void ex1() {
        verificar(perto(media(7, 8), 7.5), "media(7, 8) deveria ser 7.5, deu " + media(7, 8));
        verificar(perto(media(5, 6), 5.5), "media(5, 6) deveria ser 5.5 (cuidado com divisão inteira), deu " + media(5, 6));
    }

    static void ex2() {
        verificar("APROVADO".equals(situacao(6)), "situacao(6) deveria ser APROVADO, deu " + situacao(6));
        verificar("RECUPERACAO".equals(situacao(4)), "situacao(4) deveria ser RECUPERACAO, deu " + situacao(4));
        verificar("RECUPERACAO".equals(situacao(5.9)), "situacao(5.9) deveria ser RECUPERACAO, deu " + situacao(5.9));
        verificar("REPROVADO".equals(situacao(3.9)), "situacao(3.9) deveria ser REPROVADO, deu " + situacao(3.9));
    }

    static void ex3() {
        verificar(maiorDeTres(1, 2, 3) == 3, "maiorDeTres(1, 2, 3) deveria ser 3");
        verificar(maiorDeTres(9, 2, 3) == 9, "maiorDeTres(9, 2, 3) deveria ser 9");
        verificar(maiorDeTres(1, 8, 3) == 8, "maiorDeTres(1, 8, 3) deveria ser 8");
        verificar(maiorDeTres(-5, -2, -9) == -2, "maiorDeTres(-5, -2, -9) deveria ser -2");
    }

    static void ex4() {
        verificar(fatorial(0) == 1, "fatorial(0) deveria ser 1, deu " + fatorial(0));
        verificar(fatorial(5) == 120, "fatorial(5) deveria ser 120, deu " + fatorial(5));
        verificar(fatorial(10) == 3628800, "fatorial(10) deveria ser 3628800, deu " + fatorial(10));
    }

    static void ex5() {
        verificar(contarPares(new int[] {1, 2, 3, 4, 6}) == 3, "{1,2,3,4,6} tem 3 pares");
        verificar(contarPares(new int[] {1, 3, 5}) == 0, "{1,3,5} tem 0 pares");
        verificar(contarPares(new int[] {}) == 0, "array vazio tem 0 pares");
    }

    static void ex6() {
        verificar("avaj".equals(inverter("java")), "inverter(\"java\") deveria ser \"avaj\", deu " + inverter("java"));
        verificar("".equals(inverter("")), "inverter(\"\") deveria ser \"\"");
    }

    static void ex7() {
        ArrayList<String> nomes = new ArrayList<>(Arrays.asList("Ana", "Bruno", "Amanda", "Carlos"));
        ArrayList<String> r = filtrarPorInicial(nomes, 'A');
        verificar(r.equals(Arrays.asList("Ana", "Amanda")), "com 'A' deveria dar [Ana, Amanda], deu " + r);
        verificar(filtrarPorInicial(nomes, 'Z').isEmpty(), "com 'Z' deveria dar lista vazia");
    }

    public static void main(String[] args) {
        Runnable[] exercicios = {
            ExerciciosBasico::ex1, ExerciciosBasico::ex2, ExerciciosBasico::ex3, ExerciciosBasico::ex4,
            ExerciciosBasico::ex5, ExerciciosBasico::ex6, ExerciciosBasico::ex7 };
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
