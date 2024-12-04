import java.util.*;

public abstract class Pedidos {

    String instrucoesDeEntrega;

    private Pessoa pessoa;
    private List<Produtos> produtos = new ArrayList<>();

    public Pedidos (Pessoa pessoa){
        this.pessoa = pessoa;
    }

    public Pedidos(String instrucoesDeEntrega) {
        this.instrucoesDeEntrega = instrucoesDeEntrega;
    }

    public String getInstrucoesDeEntrega() {
        return instrucoesDeEntrega;
    }

    public void adicionarProduto(Produtos produtos, int quantidade) throws EstoqueInsuficienteException{
        produtos.reduzirEstoque(quantidade);
        this.produtos.add(produtos);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }
}
