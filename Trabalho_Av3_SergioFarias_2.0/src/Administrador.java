public class Administrador extends Pessoa{

    public Administrador(String nomeProduto, double preco, int estoque, boolean autorizacao, String nomePessoa) {
        super(nomeProduto, preco, estoque, autorizacao, nomePessoa);
    }


    @Override
    public boolean isAutorizacao(){
        return super.isAutorizacao() == true;
    }
}
