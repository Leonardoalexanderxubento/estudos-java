import java.util.ArrayList;

/*
 * BÁSICO 3 - MÉTODOS, ARRAYS, STRINGS E ArrayList
 *
 * MÉTODO = bloco de código com nome, que pode receber valores (parâmetros)
 * e devolver um resultado (return).
 *
 *     static  tipoDeRetorno  nome(tipo param1, tipo param2) { ... return valor; }
 *
 * void = não devolve nada.
 * (O "static" aqui é porque chamamos direto do main. Nas aulas de POO você
 *  verá métodos SEM static, que pertencem a objetos.)
 */
public class Basico3ArraysStringsMetodos {

    // ---------- Métodos ----------
    static int somar(int a, int b) {
        return a + b;
    }

    static boolean ehPar(int n) {
        return n % 2 == 0;
    }

    static void saudar(String nome) { // void: só faz algo, não devolve
        System.out.println("Olá, " + nome + "!");
    }

    // Método que recebe um array e devolve a média
    static double media(double[] valores) {
        double soma = 0;
        for (double v : valores) soma += v;
        return soma / valores.length;
    }

    public static void main(String[] args) {
        System.out.println("somar(2, 3) = " + somar(2, 3));
        System.out.println("ehPar(4) = " + ehPar(4));
        saudar("Ana");

        // ---------- Arrays: tamanho FIXO, índices começam em 0 ----------
        int[] numeros = {10, 20, 30, 40};
        System.out.println("Primeiro: " + numeros[0]);            // 10
        System.out.println("Último: " + numeros[numeros.length - 1]); // 40
        System.out.println("Tamanho: " + numeros.length);          // 4 (sem parênteses em array!)
        // numeros[4] -> ERRO em execução: ArrayIndexOutOfBoundsException

        numeros[1] = 99; // altera uma posição

        // Percorrer com for tradicional (quando precisa do índice)
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("numeros[" + i + "] = " + numeros[i]);
        }

        // Percorrer com for-each (quando só precisa do valor)
        int maior = numeros[0];
        for (int n : numeros) {
            if (n > maior) maior = n;
        }
        System.out.println("Maior: " + maior); // 99

        // Array criado vazio: começa com zeros
        double[] notas = new double[3];
        notas[0] = 7; notas[1] = 8; notas[2] = 6;
        System.out.println("Média das notas: " + media(notas)); // 7.0

        // ---------- Strings ----------
        String s = "Programação";
        System.out.println("Tamanho: " + s.length());           // 11 (COM parênteses em String!)
        System.out.println("Maiúsculo: " + s.toUpperCase());
        System.out.println("Letra na posição 0: " + s.charAt(0)); // P
        System.out.println("Pedaço 0..4: " + s.substring(0, 4));  // Prog (o 4 não entra)
        System.out.println("Contém 'gram'? " + s.contains("gram")); // true

        // PEGADINHA CLÁSSICA: compare Strings com equals, NUNCA com ==
        String t1 = "java";
        String t2 = new String("java");
        System.out.println("t1 == t2 ? " + (t1 == t2));           // false (objetos diferentes)
        System.out.println("t1.equals(t2) ? " + t1.equals(t2));   // true  (mesmo conteúdo)
        System.out.println("equalsIgnoreCase: " + "JAVA".equalsIgnoreCase(t1)); // true

        // Percorrer letra por letra
        int vogais = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vogais++;
        }
        System.out.println("Vogais sem acento em '" + s + "': " + vogais); // 4 (o 'ã' não conta)

        // ---------- ArrayList: lista que CRESCE (usada demais com POO) ----------
        ArrayList<String> nomes = new ArrayList<>(); // tipo entre < >: só objetos (Integer, não int)
        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Caio");
        System.out.println("Lista: " + nomes);             // [Ana, Bruno, Caio]
        System.out.println("Tamanho: " + nomes.size());    // size(), não length
        System.out.println("Posição 1: " + nomes.get(1));  // Bruno
        nomes.remove("Bruno");
        System.out.println("Depois de remover: " + nomes); // [Ana, Caio]
        for (String nome : nomes) System.out.println("- " + nome);

        // RESUMO do tamanho (cai em prova!):
        //   array.length    (atributo, sem parênteses)
        //   string.length() (método)
        //   lista.size()    (método)
    }
}
