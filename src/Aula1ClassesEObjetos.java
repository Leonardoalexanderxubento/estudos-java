/*
 * AULA 1 - CLASSES E OBJETOS
 *
 * Classe = molde (o "projeto" de uma casa).
 * Objeto = algo construído a partir do molde (cada casa de verdade).
 *
 * Uma classe tem:
 *   - atributos (dados):       nome, saldo
 *   - construtor (nasce):      new ContaBancaria("Ana")
 *   - métodos (comportamento): depositar(), getSaldo()
 *
 * Rodar: veja o README.
 */
public class Aula1ClassesEObjetos {

    static class ContaBancaria {
        String titular;   // atributo
        double saldo;     // começa em 0.0 automaticamente

        // Construtor: mesmo nome da classe, sem tipo de retorno.
        ContaBancaria(String titular) {
            this.titular = titular; // "this" = o próprio objeto sendo criado
        }

        void depositar(double valor) {
            saldo += valor;
        }
    }

    public static void main(String[] args) {
        ContaBancaria a = new ContaBancaria("Ana");
        ContaBancaria b = new ContaBancaria("Bruno");

        a.depositar(100);
        b.depositar(50);
        a.depositar(20);

        // Cada objeto tem seus PRÓPRIOS atributos.
        System.out.println(a.titular + " tem " + a.saldo); // Ana tem 120.0
        System.out.println(b.titular + " tem " + b.saldo); // Bruno tem 50.0

        // Variáveis guardam REFERÊNCIAS: c e a apontam para o MESMO objeto.
        ContaBancaria c = a;
        c.depositar(1);
        System.out.println("Depois de c.depositar(1), a tem " + a.saldo); // 121.0

        // == compara referências, não conteúdo.
        System.out.println("a == c ? " + (a == c)); // true
        System.out.println("a == b ? " + (a == b)); // false

        // PROBLEMA desta versão: qualquer um pode fazer a.saldo = -999.
        // A Aula 2 (encapsulamento) resolve isso.
    }
}
