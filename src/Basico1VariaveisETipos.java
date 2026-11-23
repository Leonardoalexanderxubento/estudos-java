/*
 * BÁSICO 1 - ESTRUTURA DE UM PROGRAMA, VARIÁVEIS E TIPOS
 *
 * Todo programa Java tem pelo menos uma classe, e a execução começa no
 * método main. Decore esta linha, ela cai em prova:
 *
 *     public static void main(String[] args)
 *
 * Cada instrução termina com ponto e vírgula ;
 * Blocos ficam entre chaves { }
 * Java diferencia maiúsculas de minúsculas: String != string
 */
public class Basico1VariaveisETipos {

    public static void main(String[] args) {
        // ---------- Tipos primitivos (os que mais caem) ----------
        int idade = 20;            // número inteiro
        double altura = 1.75;      // número com casas decimais (use ponto, não vírgula)
        boolean aprovado = false;  // true ou false
        char letra = 'A';          // UM caractere, aspas SIMPLES

        // ---------- String: texto (é uma classe, não primitivo) ----------
        String nome = "Leonardo";  // aspas DUPLAS

        // + junta textos (concatenação)
        System.out.println("Nome: " + nome + ", idade: " + idade);
        System.out.println("Altura: " + altura + ", letra: " + letra + ", aprovado: " + aprovado);

        // ---------- Operadores aritméticos ----------
        int a = 7, b = 2;
        System.out.println("7 + 2 = " + (a + b)); // 9
        System.out.println("7 - 2 = " + (a - b)); // 5
        System.out.println("7 * 2 = " + (a * b)); // 14
        System.out.println("7 / 2 = " + (a / b)); // 3   <- PEGADINHA: int / int = int (corta a parte decimal)
        System.out.println("7 % 2 = " + (a % b)); // 1   <- resto da divisão (serve para saber se é par: n % 2 == 0)
        System.out.println("7.0 / 2 = " + (7.0 / b)); // 3.5 <- se um dos lados é double, o resultado é double

        // PEGADINHA de prova: sem parênteses, + com String vira texto
        System.out.println("Soma: " + a + b);   // Soma: 72
        System.out.println("Soma: " + (a + b)); // Soma: 9

        // ---------- Conversão (cast) ----------
        double media = (double) a / b;   // converte a para double ANTES de dividir -> 3.5
        int truncado = (int) 9.99;       // corta, não arredonda -> 9
        System.out.println("media = " + media + ", truncado = " + truncado);

        // ---------- Atribuição composta e incremento ----------
        int x = 10;
        x += 5;  // x = x + 5  -> 15
        x -= 3;  // x = x - 3  -> 12
        x *= 2;  // x = x * 2  -> 24
        x++;     // x = x + 1  -> 25
        System.out.println("x = " + x);

        // ---------- Operadores de comparação e lógicos (resultam em boolean) ----------
        System.out.println("10 > 5 ? " + (10 > 5));        // true
        System.out.println("10 == 5 ? " + (10 == 5));      // false   (== compara, = atribui!)
        System.out.println("10 != 5 ? " + (10 != 5));      // true
        System.out.println("true && false = " + (true && false)); // E: só true se os dois forem
        System.out.println("true || false = " + (true || false)); // OU: true se um for
        System.out.println("!true = " + (!true));                 // NÃO: inverte

        // ---------- Constante ----------
        final double PI = 3.14159; // final = não pode mudar depois
        // PI = 3; // <- não compila. Tente descomentar.
        System.out.println("PI = " + PI);

        /*
         * LER DO TECLADO (cai muito em prova). Precisa de: import java.util.Scanner;
         * no topo do arquivo. Exemplo:
         *
         *     Scanner sc = new Scanner(System.in);
         *     System.out.print("Digite sua idade: ");
         *     int idade = sc.nextInt();       // lê um int
         *     double nota = sc.nextDouble();  // lê um double
         *     String nome = sc.next();        // lê uma palavra
         *     sc.nextLine();                  // descarta o "Enter" que sobrou
         *     String frase = sc.nextLine();   // lê a linha inteira
         *     sc.close();
         */
    }
}
