# Estudos de Java — do zero à POO

Aulas curtas (código comentado que você **roda e modifica**), exercícios com **corretor automático** e um **simulado de prova**. Feito para estudar no **Eclipse**.

## Plano de 4 dias (prova dia 27)

| Dia | O que fazer | Tempo |
|-----|-------------|-------|
| **23** | Básico 1, 2 e 3 → [ExerciciosBasico](src/ExerciciosBasico.java) até **7/7** | ~3 h |
| **24** | Aulas 1, 2 e 3 (classes, encapsulamento, herança) → [Exercicios](src/Exercicios.java) 1 e 2 | ~3 h |
| **25** | Aulas 4, 5 e 6 (polimorfismo, abstração/interface, composição) → Exercicios 3, 4 e 5 | ~3 h |
| **26** | [SIMULADO](SIMULADO.md) **no papel**, corrigir, revisar só o que errou | ~2 h |
| **27** | Prova. Releia só os comentários "PEGADINHA" das aulas antes de entrar. | — |

Atrasou um dia? Corte a Aula 6 — é a que menos cai.

## Roteiro das aulas

| Arquivo | Conteúdo |
|---------|----------|
| [Basico1VariaveisETipos](src/Basico1VariaveisETipos.java) | `main`, `int`/`double`/`boolean`/`char`/`String`, operadores, cast, `Scanner` |
| [Basico2DecisoesELacos](src/Basico2DecisoesELacos.java) | `if`/`else`, `switch`, `for`, `while`, `do-while`, `break`/`continue` |
| [Basico3ArraysStringsMetodos](src/Basico3ArraysStringsMetodos.java) | métodos, arrays, métodos de `String`, `equals`, `ArrayList` |
| [Aula1ClassesEObjetos](src/Aula1ClassesEObjetos.java) | classe, objeto, construtor, `this`, referência |
| [Aula2Encapsulamento](src/Aula2Encapsulamento.java) | `private`, getters, validação |
| [Aula3Heranca](src/Aula3Heranca.java) | `extends`, `super`, `@Override`, `protected` |
| [Aula4Polimorfismo](src/Aula4Polimorfismo.java) | sobrescrita vs. sobrecarga |
| [Aula5AbstracaoEInterfaces](src/Aula5AbstracaoEInterfaces.java) | `abstract`, `interface`, `default`, cast |
| [Aula6ComposicaoEEquals](src/Aula6ComposicaoEEquals.java) | composição, `equals`, `hashCode` |

Soluções em [solucoes/](solucoes/) — só depois de tentar.

## Como abrir no Eclipse

1. Baixe o repositório: botão verde **Code → Download ZIP** no GitHub e extraia (ou `git clone`).
2. No Eclipse: **File → Import → General → Existing Projects into Workspace → Next**.
3. Em **Select root directory**, escolha a pasta extraída `estudos-java` → **Finish**.
4. Abra um arquivo em `src` (ex.: `Basico1VariaveisETipos.java`), clique com o botão direito no código → **Run As → Java Application**. A saída aparece na aba **Console**.
5. Para os exercícios: edite `ExerciciosBasico.java` ou `Exercicios.java`, salve (**Ctrl+S**) e rode do mesmo jeito.

A pasta `solucoes/` fica fora da compilação de propósito (tem classes com o mesmo nome dos exercícios). Para ler, é só abrir o arquivo.

Atalhos úteis: **Ctrl+Shift+F** formata o código, **Ctrl+Espaço** autocompleta, digite `sysout` + **Ctrl+Espaço** para gerar `System.out.println()`, e o menu **Source → Generate Getters and Setters / Generate Constructor using Fields**.

## Como estudar (o que realmente funciona)

1. **Antes** de rodar uma aula, adivinhe a saída de cada `println`. Depois rode e compare. Errou? É ali que você aprende.
2. Faça os experimentos dos comentários (descomentar linhas que não compilam etc.). Ler o erro do compilador ensina muito.
3. Os exercícios são o principal. Se travar mais de 15 min, releia a aula; se continuar, olhe a solução, **apague** e escreva de novo sozinho.
4. Na prova você escreve **no papel**: no simulado, nada de Eclipse.
5. Cole seu código no chat com o Claude e peça uma revisão — passar no corretor não quer dizer que está bem escrito.
