public class Cliente extends Pessoa{

    public Cliente(String nomeProduto, double preco, int estoque, boolean autorizacao, String nomePessoa) {
        super(nomeProduto, preco, estoque, autorizacao, nomePessoa);
    }

    @Override
    public boolean isAutorizacao() {
        return super.isAutorizacao() == false;
    }
}
