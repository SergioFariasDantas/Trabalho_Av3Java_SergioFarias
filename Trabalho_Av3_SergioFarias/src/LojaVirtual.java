import java.io.*;
import java.util.*;

public class LojaVirtual {

    private static List<Produto> produtos = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {

        inicializarProdutos();

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\n==== Menu da Loja Virtual ====");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Criar Pedido");
            System.out.println("3. Exibir Pedidos");
            System.out.println("4. Salvar Pedidos em Arquivo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarProdutos();
                    break;
                case 2:
                    criarPedido(scanner);
                    break;
                case 3:
                    exibirPedidos();
                    break;
                case 4:
                    salvarPedidosEmArquivo();
                    break;
                case 5:
                    executando = false;
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void inicializarProdutos() {
        produtos.add(new Eletronico("Notebook", 3000, 10));
        produtos.add(new Eletronico("Smartphone", 1500, 20));
        produtos.add(new Vestuario("Camiseta", 50, 30));
        produtos.add(new Vestuario("Calça Jeans", 120, 15));
    }

    private static void listarProdutos() {
        System.out.println("\n==== Lista de Produtos ====");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i));
        }
    }

    private static void criarPedido(Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente);

        System.out.println("Escolha o tipo de pedido:");
        System.out.println("1. Pedido Online");
        System.out.println("2. Pedido para Retirada");
        int tipoPedido = scanner.nextInt();
        scanner.nextLine();

        Pedido pedido = (tipoPedido == 1) ? new PedidoOnline(cliente) : new PedidoRetirada(cliente);

        boolean adicionandoProdutos = true;
        while (adicionandoProdutos) {
            listarProdutos();
            System.out.print("Escolha um produto pelo número (ou 0 para finalizar): ");
            int escolhaProduto = scanner.nextInt();
            scanner.nextLine();

            if (escolhaProduto == 0) {
                adicionandoProdutos = false;
            } else if (escolhaProduto > 0 && escolhaProduto <= produtos.size()) {
                Produto produto = produtos.get(escolhaProduto - 1);
                System.out.print("Quantidade desejada: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                try {
                    pedido.adicionarProduto(produto, quantidade);
                    System.out.println("Produto adicionado ao pedido.");
                } catch (EstoqueInsuficienteException e) {
                    System.err.println("Erro: " + e.getMessage());
                }
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        pedidos.add(pedido);
        System.out.println("Pedido criado com sucesso!");
        System.out.println("Total do pedido: R$" + pedido.calcularTotal());
    }

    private static void exibirPedidos() {
        System.out.println("\n==== Lista de Pedidos ====");
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
                for (Produto produto : pedido.getProdutos()) {
                    System.out.println("   - " + produto);
                }
            }
        }
    }

    private static void salvarPedidosEmArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pedidos.txt"))) {
            for (Pedido pedido : pedidos) {
                writer.write(pedido.toString());
                writer.newLine();
                for (Produto produto : pedido.getProdutos()) {
                    writer.write("   - " + produto.toString());
                    writer.newLine();
                }
            }
            System.out.println("Pedidos salvos em arquivo com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os pedidos: " + e.getMessage());
        }

    }
}