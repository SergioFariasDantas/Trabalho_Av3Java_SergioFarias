public abstract class Produto {

    private String nome;
    private double preco;
    private int estoque;

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public void reduzirEstoque(int quantidade) throws EstoqueInsuficienteException {
        if (quantidade > estoque) {
            throw new EstoqueInsuficienteException("Estoque insuficiente para o produto: " + nome);
        }
        estoque -= quantidade;
    }

    @Override
    public String toString() {
        return nome + " - Preço: R$" + preco + " - Estoque: " + estoque;
    }
}
