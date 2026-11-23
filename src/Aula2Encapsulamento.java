/*
 * AULA 2 - ENCAPSULAMENTO
 *
 * Ideia: o objeto protege os próprios dados. Ninguém de fora mexe direto
 * no atributo; só pelos métodos, que validam as regras.
 *
 * Modificadores de acesso:
 *   private   -> só dentro da própria classe
 *   (nenhum)  -> mesmo pacote
 *   protected -> mesmo pacote + subclasses
 *   public    -> todo mundo
 *
 * Regra prática: atributos private, métodos public só quando precisar.
 */
public class Aula2Encapsulamento {

    static class ContaBancaria {
        private final String titular; // final: não muda depois do construtor
        private double saldo;

        ContaBancaria(String titular) {
            if (titular == null || titular.trim().isEmpty()) {
                throw new IllegalArgumentException("Titular obrigatório");
            }
            this.titular = titular;
        }

        // "getter": deixa LER, sem deixar ESCREVER
        public double getSaldo() { return saldo; }
        public String getTitular() { return titular; }

        // Não existe setSaldo(): o saldo só muda por operações válidas.
        public void depositar(double valor) {
            if (valor <= 0) throw new IllegalArgumentException("Depósito deve ser positivo");
            saldo += valor;
        }

        public void sacar(double valor) {
            if (valor <= 0) throw new IllegalArgumentException("Saque deve ser positivo");
            if (valor > saldo) throw new IllegalStateException("Saldo insuficiente");
            saldo -= valor;
        }
    }

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("Ana");
        conta.depositar(100);
        conta.sacar(30);
        System.out.println(conta.getTitular() + ": " + conta.getSaldo()); // 70.0

        // conta.saldo = -999;  // <- não compila! Tente descomentar.

        try {
            conta.sacar(1000);
        } catch (IllegalStateException e) {
            System.out.println("Bloqueado: " + e.getMessage());
        }

        try {
            new ContaBancaria("");
        } catch (IllegalArgumentException e) {
            System.out.println("Bloqueado: " + e.getMessage());
        }

        System.out.println("Saldo continua correto: " + conta.getSaldo()); // 70.0
    }
}
