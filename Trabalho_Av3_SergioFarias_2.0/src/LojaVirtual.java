import java.util.*;

public class LojaVirtual {

    private static List<Produtos> produtos = new ArrayList<>();
    private static List<Pedidos> pedidos = new ArrayList<>();


    public static void main(String[] args) {

        Scanner prompt = new Scanner(System.in);
        boolean executandoCadastro = true;


            while(executandoCadastro = true){
            System.out.println("\n==== Menu da Loja Virtual ====");
            System.out.println("1. Cadastre o usuário");
            System.out.println("2 Continuar");

            int opcao = prompt.nextInt();
            prompt.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Qual o tipo de usuário? ");
                    System.out.println("1. Administrador");
                    System.out.println("2. Cliente");

                    int opcao2 = prompt.nextInt();
                    prompt.nextLine();

                        switch(opcao2){
                            case 1:
                                System.out.println("1. Administrador");
                                cadastroAdministrador();
                                break;
                            case 2:
                                System.out.println("2. Cliente");
                                cadastroCliente();
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                                break;
                        }
                    break;
                case 2:
                    executandoCadastro = false;
                    System.out.println("Encaminhando para menu de loja virtual...");
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        prompt.close();

    }

    private static void cadastroAdministrador(){
        Scanner prompt = new Scanner(System.in);
        System.out.println("Digite o nome do administrador: ");
        String nomeAdministrador = prompt.nextLine();
        nomeAdministrador = Administrador.nomePessoa;
    }

    private static void cadastroCliente(){
        Scanner prompt = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = prompt.nextLine();
        nomeCliente = Cliente.nomePessoa;
    }

    private static void opcaoExecucaoAdministrador(){

    }
}
