import java.io.*;
import java.util.*;

public class LojaVirtual {

    private static List<Produtos> produtos = new ArrayList<>();
    private static List<Pedidos> pedidos = new ArrayList<>();


    public static void main(String[] args) {

        inicializaCadastro();

        Scanner prompt = new Scanner(System.in);
        boolean executandoCadastro = true;

        int opcao = prompt.nextInt();
        prompt.nextLine();

        while(executandoCadastro = true){
            System.out.println("\n==== Menu da Loja Virtual ====");
            System.out.println("1. Cadastre o usuário");
            System.out.println("2 Sair da loja");

            switch (opcao) {
                case 1:
                    System.out.println("Qual o tipo de usuário? ");
                        switch(opcao){
                            case 1:
                                System.out.println("1. Administrador");
                                cadastroAdministrador;
                                break;
                            case 2:
                                System.out.println("2. Cliente");
                                cadastroCliente;
                                break;
                        }
                    break;
                case 2:
                    System.out.println("Volte em breve! :)");
                    break;
                    executandoCadastro = false;

            }
        }
        prompt.close();

        inicializarProdutos();

        boolean executandoPedido = true;

        public void execucaodeOpcoes(int opcao){

        }

    }

    private static void cadastroAdministrador(Scanner prompt){
        System.out.println("Digite o nome do administrador: ");
        String nomeAdministrador = prompt.nextLine();
        Administrador administrador = new Administrador(nomeAdministrador);
    }

    private static void cadastroCliente(Scanner prompt){
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = prompt.nextLine();
        Cliente cliente = new Cliente(nomeCliente);
    }
}
