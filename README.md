# Estudos de Java — Programação Orientada a Objetos

Seis aulas curtas (código comentado que você **roda e modifica**) e cinco exercícios com **corretor automático**. Sem Maven, sem IDE: só o JDK.

## Roteiro

| # | Arquivo | Conceito | Pergunta que a aula responde |
|---|---------|----------|------------------------------|
| 1 | [Aula1ClassesEObjetos](src/Aula1ClassesEObjetos.java) | Classe, objeto, construtor, `this`, referência | Qual a diferença entre o molde e a coisa? |
| 2 | [Aula2Encapsulamento](src/Aula2Encapsulamento.java) | `private`, getters, validação | Como impedir que alguém estrague os dados do objeto? |
| 3 | [Aula3Heranca](src/Aula3Heranca.java) | `extends`, `super`, `@Override`, `protected` | Como reaproveitar código entre tipos parecidos? |
| 4 | [Aula4Polimorfismo](src/Aula4Polimorfismo.java) | Sobrescrita vs. sobrecarga, listas de tipos mistos | Como um código só funciona para vários tipos? |
| 5 | [Aula5AbstracaoEInterfaces](src/Aula5AbstracaoEInterfaces.java) | `abstract`, `interface`, `default`, cast | Quando usar classe abstrata e quando usar interface? |
| 6 | [Aula6ComposicaoEEquals](src/Aula6ComposicaoEEquals.java) | Composição, `equals`, `hashCode` | "É um" ou "tem um"? Quando dois objetos são iguais? |

Depois: [Exercicios.java](src/Exercicios.java) → soluções em [solucoes/](solucoes/Exercicios.java) (só depois de tentar!).

## Como rodar

Precisa de JDK 11 ou mais novo (`javac -version`). Na pasta do repositório:

```powershell
javac -encoding UTF-8 -d out src/*.java
```

```powershell
java -cp out Aula1ClassesEObjetos
```

Troque o nome da classe para rodar outra aula. Para corrigir os exercícios (recompile antes, sempre que editar):

```powershell
javac -encoding UTF-8 -d out src/*.java; java -cp out Exercicios
```

Saída esperada no começo: `0/5 exercícios corretos`. Seu objetivo: `5/5`.

> Erro `UnsupportedClassVersionError`? Seu `java` é mais velho que seu `javac` (ex.: Java 8 no PATH). Use o `java` da mesma pasta do `javac`.

## Como estudar

1. Leia a aula de cima a baixo, **antes** de rodar adivinhe a saída de cada `println`.
2. Rode e compare.
3. Faça os experimentos sugeridos nos comentários (descomentar linhas que não compilam, apagar o `hashCode()`...). Ler o erro do compilador ensina muito.
4. Faça o exercício da aula. Travou? Releia a aula. Ainda travou? Compare com a solução:
   `git diff --no-index src/Exercicios.java solucoes/Exercicios.java`

## Próximos passos

Quando chegar em 5/5: crie seu próprio mini-sistema (biblioteca, estacionamento, loja) usando as 6 ideias juntas, depois estude coleções (`List`, `Map`), exceções próprias e testes com JUnit.
