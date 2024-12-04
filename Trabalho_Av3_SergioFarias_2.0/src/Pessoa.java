public abstract class Pessoa extends Produtos implements Autorizacao{

    static String nomePessoa;
    boolean autorizacao;

    public Pessoa(String nomeProduto, double preco, int estoque) {
        super(nomeProduto, preco, estoque);
    }

    public boolean isAutorizacao() {
        return autorizacao;
    }

    public Pessoa(String nomeProduto, double preco, int estoque, boolean autorizacao, String nomePessoa) {
        super(nomeProduto, preco, estoque);
        this.autorizacao = autorizacao;
        this.nomePessoa = nomePessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    @Override
    public String toString(){
        return "Nome: " + nomePessoa;
    }


    public void isAutorizacaoDeMudanca(boolean autorizacao) throws PermissaoNaoAutorizadaException{
        if(isAutorizacao() == false){
            throw new PermissaoNaoAutorizadaException("Você não tem autorização para realizar essa ação");
        } else {
            this.estoque = estoque;
            this.preco = preco;
        }
    }
}
