# Simulado — Java e POO

Faça **no papel, sem o Eclipse**, como na prova. Marque o tempo (meta: 60 min). Só depois abra as respostas.

---

## Parte 1 — Teoria (responda em 1 ou 2 frases)

**1.** Qual a diferença entre **classe** e **objeto**?

**2.** O que é **encapsulamento** e como ele é feito em Java?

**3.** Qual a diferença entre **sobrecarga** (overload) e **sobrescrita** (override)?

**4.** Qual a diferença entre **classe abstrata** e **interface**? Cite uma coisa que uma pode e a outra não.

**5.** Para que serve a palavra **`super`**? Dê dois usos.

**6.** O que é **polimorfismo**? Dê um exemplo curto.

**7.** Por que comparar Strings com `==` é um erro? O que usar no lugar?

---

## Parte 2 — Qual a saída?

**8.**
```java
int a = 7, b = 2;
System.out.println(a / b);
System.out.println(a % b);
System.out.println("R: " + a + b);
```

**9.**
```java
int soma = 0;
for (int i = 1; i <= 4; i++) {
    if (i == 3) continue;
    soma += i;
}
System.out.println(soma);
```

**10.**
```java
class Animal {
    String som() { return "..."; }
}
class Gato extends Animal {
    @Override String som() { return "miau"; }
}
// no main:
Animal a = new Gato();
System.out.println(a.som());
```

**11.**
```java
class Conta {
    double saldo;
}
// no main:
Conta c1 = new Conta();
Conta c2 = c1;
c2.saldo = 100;
System.out.println(c1.saldo);
```

**12.** Este código compila? Se não, por quê?
```java
abstract class Forma {
    abstract double area();
}
// no main:
Forma f = new Forma();
```

---

## Parte 3 — Escreva o código

**13.** Escreva a classe `Produto` com:
- atributos **privados** `nome` (String) e `preco` (double);
- construtor que recebe os dois;
- getters para os dois;
- método `aplicarDesconto(double percentual)` que reduz o preço (ex.: 10 → 10% de desconto). Se o percentual for menor que 0 ou maior que 100, não faça nada.

**14.** Crie a classe abstrata `Funcionario` (atributo `nome`, `salarioBase` e método abstrato `double calcularSalario()`) e duas filhas:
- `Professor`: salário = salarioBase + 50 × horasAula;
- `Coordenador`: salário = salarioBase × 1.2.

Depois, no `main`, crie uma `ArrayList<Funcionario>` com um de cada e imprima o salário de todos com um `for`.

**15.** Crie a interface `Autenticavel` com o método `boolean autenticar(String senha)` e faça a classe `Usuario` implementá-la (o usuário guarda uma senha e `autenticar` devolve se a senha bate).

---

## Respostas

<details>
<summary>Clique para ver (só depois de tentar!)</summary>

**1.** Classe é o molde (define atributos e métodos); objeto é uma instância criada a partir dela com `new`, com seus próprios valores.

**2.** É esconder os dados do objeto e só permitir acesso por métodos que validam as regras. Em Java: atributos `private` e métodos públicos (getters/setters ou operações como `depositar`).

**3.** Sobrecarga: mesmo nome de método, **parâmetros diferentes**, na mesma classe (decidido na compilação). Sobrescrita: a subclasse **redefine** um método herdado com a mesma assinatura (`@Override`, decidido na execução).

**4.** Classe abstrata pode ter atributos, construtor e métodos prontos, mas uma classe só estende **uma**. Interface é um contrato (métodos sem corpo, exceto `default`/`static`), e uma classe pode implementar **várias**. Nenhuma das duas pode ser instanciada com `new`.

**5.** Acessar a classe mãe: `super(...)` chama o construtor da mãe (primeira linha do construtor da filha); `super.metodo()` chama a versão da mãe de um método sobrescrito.

**6.** Uma variável do tipo da mãe guarda um objeto da filha, e o método executado é o do objeto real. Ex.: `Animal a = new Gato(); a.som();` executa o `som()` do Gato.

**7.** `==` compara se são o **mesmo objeto** (referência), não o conteúdo. Use `s1.equals(s2)`.

**8.**
```
3
1
R: 72
```
(`7/2` entre `int` corta a parte decimal; e `"R: " + 7` vira texto, depois `+ 2` junta "2".)

**9.** `7` (soma 1 + 2 + 4; o `continue` pula o 3).

**10.** `miau` — polimorfismo: vale o método do objeto real (Gato).

**11.** `100.0` — `c1` e `c2` apontam para o **mesmo** objeto.

**12.** Não compila: classe abstrata não pode ser instanciada. Seria preciso uma subclasse concreta, ex.: `Forma f = new Circulo(2);`.

**13.**
```java
public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }

    public void aplicarDesconto(double percentual) {
        if (percentual < 0 || percentual > 100) return;
        preco = preco - preco * percentual / 100;
    }
}
```

**14.**
```java
import java.util.ArrayList;

abstract class Funcionario {
    protected String nome;
    protected double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();
}

class Professor extends Funcionario {
    private int horasAula;

    public Professor(String nome, double salarioBase, int horasAula) {
        super(nome, salarioBase);
        this.horasAula = horasAula;
    }

    @Override
    public double calcularSalario() { return salarioBase + 50 * horasAula; }
}

class Coordenador extends Funcionario {
    public Coordenador(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double calcularSalario() { return salarioBase * 1.2; }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Funcionario> lista = new ArrayList<>();
        lista.add(new Professor("Ana", 2000, 10));
        lista.add(new Coordenador("Bruno", 3000));
        for (Funcionario f : lista) {
            System.out.println(f.nome + ": " + f.calcularSalario());
        }
    }
}
```
Saída: `Ana: 2500.0` e `Bruno: 3600.0`.

**15.**
```java
interface Autenticavel {
    boolean autenticar(String senha);
}

class Usuario implements Autenticavel {
    private String senha;

    public Usuario(String senha) { this.senha = senha; }

    @Override
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}
```

</details>

**Corrigiu?** Cole aqui no chat as questões que errou ou o código que escreveu nas 13–15 e peça uma revisão.
