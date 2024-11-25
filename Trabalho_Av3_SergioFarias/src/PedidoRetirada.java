public class PedidoRetirada extends Pedido {
    public PedidoRetirada(Cliente cliente) {
        super(cliente);
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Produto produto : getProdutos()) {
            total += produto.getPreco();
        }
        return total;
    }
}
