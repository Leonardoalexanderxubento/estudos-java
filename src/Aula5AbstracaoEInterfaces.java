import java.util.Arrays;
import java.util.List;

/*
 * AULA 5 - ABSTRAÇÃO E INTERFACES
 *
 * CLASSE ABSTRATA: não pode ser instanciada (new Animal() não compila).
 *   - pode ter atributos, construtor e métodos prontos
 *   - métodos abstract OBRIGAM a filha a implementar
 *   - uma classe só pode estender UMA
 *
 * INTERFACE: um contrato, "sabe fazer X".
 *   - só assinaturas (e métodos default, desde o Java 8)
 *   - uma classe pode implementar VÁRIAS
 *
 * Regra prática:
 *   "É UM" com código em comum  -> classe abstrata
 *   "SABE FAZER" / capacidade    -> interface
 */
public class Aula5AbstracaoEInterfaces {

    interface Nadador {
        String nadar();
    }

    interface Voador {
        String voar();

        // default: implementação pronta que a classe pode usar ou sobrescrever
        default String pousar() { return "pousou"; }
    }

    static abstract class Animal {
        private final String nome;

        Animal(String nome) { this.nome = nome; }

        public String getNome() { return nome; }

        public abstract String som(); // cada animal TEM que dizer o seu

        // método concreto que usa o abstrato (padrão "template method")
        public String apresentar() { return nome + " faz " + som(); }
    }

    static class Cachorro extends Animal implements Nadador {
        Cachorro(String nome) { super(nome); }
        @Override public String som() { return "au au"; }
        @Override public String nadar() { return getNome() + " nada cachorrinho"; }
    }

    static class Pato extends Animal implements Nadador, Voador { // várias interfaces!
        Pato(String nome) { super(nome); }
        @Override public String som() { return "quack"; }
        @Override public String nadar() { return getNome() + " boia"; }
        @Override public String voar() { return getNome() + " voa baixo"; }
    }

    // Avião não é Animal, mas também voa: interface une tipos sem parentesco.
    static class Aviao implements Voador {
        @Override public String voar() { return "avião voa alto"; }
    }

    public static void main(String[] args) {
        // new Animal("x"); // <- não compila: Animal é abstrata
        List<Animal> animais = Arrays.asList(new Cachorro("Rex"), new Pato("Donald"));
        for (Animal a : animais) System.out.println(a.apresentar());

        List<Voador> voadores = Arrays.asList(new Pato("Patinho"), new Aviao());
        for (Voador v : voadores) System.out.println(v.voar() + " e " + v.pousar());

        for (Animal a : animais) {
            if (a instanceof Nadador) {
                System.out.println(((Nadador) a).nadar()); // cast: "confia, é Nadador"
            }
        }
    }
}
