class PedidoOnline extends Pedido implements Descontavel {
        public PedidoOnline(Cliente cliente) {
            super(cliente);
        }

        @Override
        public double calcularTotal() {
            double total = 0;
            for (Produto produto : getProdutos()) {
                total += produto.getPreco();
            }
            return total - calcularDesconto(total);
        }

        @Override
        public double calcularDesconto(double preco) {
            return preco * 0.1;
        }
    }


