/*
 * AULA 3 - HERANÇA
 *
 * "Gerente É UM Funcionário" -> Gerente extends Funcionario.
 * A subclasse herda atributos e métodos e pode:
 *   - ADICIONAR coisas novas (bonus)
 *   - SOBRESCREVER métodos (@Override) para mudar o comportamento
 *   - chamar a versão da classe mãe com super
 *
 * Java só permite herdar de UMA classe. Toda classe herda de Object.
 */
public class Aula3Heranca {

    static class Funcionario {
        private final String nome;
        protected final double salarioBase; // protected: subclasses enxergam

        Funcionario(String nome, double salarioBase) {
            this.nome = nome;
            this.salarioBase = salarioBase;
        }

        public String getNome() { return nome; }

        public double salario() { return salarioBase; }

        // toString vem de Object; sobrescrever deixa o println legível.
        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" + nome + ", " + salario() + ")";
        }
    }

    static class Gerente extends Funcionario {
        private final double bonus;

        Gerente(String nome, double salarioBase, double bonus) {
            super(nome, salarioBase); // obrigatório: constrói a parte "Funcionario" primeiro
            this.bonus = bonus;
        }

        @Override // o compilador avisa se você errar a assinatura
        public double salario() {
            return super.salario() + bonus; // reaproveita a regra da mãe
        }
    }

    static class Estagiario extends Funcionario {
        Estagiario(String nome) {
            super(nome, 1500);
        }
        // Não sobrescreve nada: usa salario() herdado.
    }

    public static void main(String[] args) {
        Funcionario f = new Funcionario("Carlos", 3000);
        Gerente g = new Gerente("Ana", 5000, 2000);
        Estagiario e = new Estagiario("Bia");

        System.out.println(f); // Funcionario(Carlos, 3000.0)
        System.out.println(g); // Gerente(Ana, 7000.0)
        System.out.println(e); // Estagiario(Bia, 1500.0)

        // instanceof: "este objeto É UM ...?"
        System.out.println("g é Funcionario? " + (g instanceof Funcionario)); // true
        System.out.println("f é Gerente? " + (f instanceof Gerente));         // false

        // CUIDADO: herança é acoplamento forte. Use só quando "É UM" for
        // verdade sempre. Para "TEM UM", use composição (Aula 6).
    }
}
