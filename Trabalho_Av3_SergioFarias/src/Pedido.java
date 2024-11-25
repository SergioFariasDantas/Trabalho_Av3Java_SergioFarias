import java.io.*;
import java.util.*;


public abstract class Pedido {

    private Cliente cliente;
    private List<Produto> produtos = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarProduto(Produto produto, int quantidade) throws EstoqueInsuficienteException {
        produto.reduzirEstoque(quantidade);
        produtos.add(produto);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public abstract double calcularTotal();

    @Override
    public String toString() {
        return "Pedido de " + cliente.getNome() + " - Total de produtos: " + produtos.size();
    }
}
