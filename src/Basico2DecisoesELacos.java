/*
 * BÁSICO 2 - DECISÕES (if, switch) E LAÇOS (for, while, do-while)
 *
 * if/else  -> escolher um caminho
 * switch   -> escolher entre vários valores fixos
 * for      -> repetir um número CONHECIDO de vezes
 * while    -> repetir ENQUANTO uma condição for verdadeira
 * do-while -> igual ao while, mas executa PELO MENOS uma vez
 */
public class Basico2DecisoesELacos {

    public static void main(String[] args) {
        // ---------- if / else if / else ----------
        double nota = 6.5;
        if (nota >= 7) {
            System.out.println("Aprovado");
        } else if (nota >= 5) {
            System.out.println("Recuperação"); // <- este
        } else {
            System.out.println("Reprovado");
        }

        // Combinando condições
        int idade = 17;
        boolean temAutorizacao = true;
        if (idade >= 18 || temAutorizacao) {
            System.out.println("Pode entrar");
        }

        // Operador ternário: if/else em uma linha -> condição ? seVerdadeiro : seFalso
        String situacao = nota >= 6 ? "passou" : "não passou";
        System.out.println("Situação: " + situacao);

        // ---------- switch ----------
        int dia = 3;
        switch (dia) {
            case 1:
                System.out.println("Domingo");
                break; // sem break, ele continua executando os cases de baixo!
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terça"); // <- este
                break;
            default:
                System.out.println("Outro dia");
        }

        // ---------- for: início; condição; passo ----------
        System.out.print("for de 1 a 5: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Somar de 1 até 10 (padrão "acumulador" - cai muito)
        int soma = 0;
        for (int i = 1; i <= 10; i++) {
            soma += i;
        }
        System.out.println("Soma de 1 a 10 = " + soma); // 55

        // Contando de trás para frente, de 2 em 2
        System.out.print("Contagem regressiva: ");
        for (int i = 10; i >= 0; i -= 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // ---------- while ----------
        int n = 1;
        while (n < 100) {
            n *= 2;
        }
        System.out.println("Primeira potência de 2 >= 100: " + n); // 128

        // ---------- do-while: roda uma vez antes de testar ----------
        int k = 50;
        do {
            System.out.println("do-while rodou com k = " + k); // roda mesmo k já sendo > 10
            k++;
        } while (k < 10);

        // ---------- break e continue ----------
        System.out.print("Ímpares até 9, parando no 7: ");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) continue; // pula para a próxima volta
            if (i > 7) break;         // sai do laço
            System.out.print(i + " ");
        }
        System.out.println();

        // ---------- laço dentro de laço (tabuada) ----------
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i + "x" + j + "=" + (i * j) + "  ");
            }
            System.out.println();
        }
    }
}
