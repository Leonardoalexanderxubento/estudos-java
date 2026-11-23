import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/*
 * AULA 6 - COMPOSIÇÃO + equals/hashCode
 *
 * COMPOSIÇÃO: "TEM UM". Um Pedido TEM itens; não É um item.
 * Prefira composição a herança: é mais flexível e menos acoplada.
 *
 * equals/hashCode: por padrão, == e equals comparam REFERÊNCIA.
 * Para comparar por CONTEÚDO, sobrescreva os dois. Regra de ouro:
 * se a.equals(b), então a.hashCode() == b.hashCode().
 * Sem isso, HashSet e HashMap se comportam errado.
 */
public class Aula6ComposicaoEEquals {

    static final class Produto {
        private final String nome;
        private final double preco;

        Produto(String nome, double preco) { this.nome = nome; this.preco = preco; }

        public double getPreco() { return preco; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Produto)) return false;
            Produto p = (Produto) o;
            return Double.compare(preco, p.preco) == 0 && nome.equals(p.nome);
        }

        @Override
        public int hashCode() { return Objects.hash(nome, preco); }

        @Override
        public String toString() { return nome + " R$" + preco; }
    }

    static class Item {
        private final Produto produto;  // Item TEM UM Produto
        private final int quantidade;

        Item(Produto produto, int quantidade) {
            if (quantidade <= 0) throw new IllegalArgumentException("Quantidade deve ser positiva");
            this.produto = produto;
            this.quantidade = quantidade;
        }

        double subtotal() { return produto.getPreco() * quantidade; }
    }

    static class Pedido {
        private final List<Item> itens = new ArrayList<>(); // Pedido TEM VÁRIOS Itens

        void adicionar(Produto p, int qtd) { itens.add(new Item(p, qtd)); }

        double total() {
            double t = 0;
            for (Item i : itens) t += i.subtotal(); // delega para as partes
            return t;
        }
    }

    public static void main(String[] args) {
        Produto cafe = new Produto("Café", 10);
        Produto pao = new Produto("Pão", 0.5);

        Pedido pedido = new Pedido();
        pedido.adicionar(cafe, 2);
        pedido.adicionar(pao, 10);
        System.out.println("Total: " + pedido.total()); // 25.0

        Produto outroCafe = new Produto("Café", 10);
        System.out.println("cafe == outroCafe ? " + (cafe == outroCafe));           // false
        System.out.println("cafe.equals(outroCafe) ? " + cafe.equals(outroCafe));   // true

        Set<Produto> set = new HashSet<>();
        set.add(cafe);
        set.add(outroCafe); // igual pelo equals/hashCode -> não duplica
        System.out.println("Itens no set: " + set.size()); // 1
        // Experimente apagar o hashCode() e rode de novo: o set terá 2.
    }
}
