package main.java.classes;

import javax.swing.*;

/***************************************************************
 * Classe de suporte e validação dos dados
 * @author Izabel Santos
 **************************************************************/
public class Cadastrar {

    private final Produto produto = new Produto();
    private static String error = "";
    private boolean failure = true;
    private int ev_codigo;
    private final String cad_referencia;
    private final String cad_descricao;
    private final String cad_imagem;
    private final String cad_fornecedor;
    private final String cad_marca;
    private final String cad_observacao;
    private double ev_preco;


    public Cadastrar ( String codigo, String referencia, String descricao, String imagem, String fornecedor, String marca, String observacao, String preco_venda) {

        try{ ev_codigo = Integer.parseInt(codigo);
        }catch  (Exception err){ error = error + "Codigo invalido.\n"; }

        try{  ev_preco =  Double.parseDouble(preco_venda);
        }catch  (Exception err){ error = error + "Preco invalido.\n"; }

        if(referencia.isBlank()){
            error = error + "O campo referencia nao pode estar vazio.\n ";
        }

        if(descricao.isBlank()){
            error = error + "O campo descricao nao pode estar vazio.\n";
        }
        if(fornecedor.isBlank()){
            error = error + "Você precisa inserir um fornecedor.\n";
        }

        try{
            if(marca.isBlank()){
                error = error + "A marca precisa ser inserida\n";
            }
        }catch (Exception e){
            error = error + "Marca invalida\n";
        }



        try{
            if(observacao.isBlank()){
                error = error + "O campo de Observações está vazio. Custa colocar alguma coisa aqui?\n";
            }
        }catch (Exception e){
            error = error + "Erro do campo.";
        }

        if(error.length() > 1){
            JOptionPane.showMessageDialog(null, error);
            error = "";
        }else
        {
            failure = false;
        }

        this.cad_descricao = descricao;
        this.cad_fornecedor = fornecedor;
        this.cad_imagem = imagem;
        this.cad_marca = marca;
        this.cad_observacao = observacao;
        this.cad_referencia = referencia;
    }
    /***************************************************************
     * Essa função é que salva os dados
     * @see "Matriz de String"
     **************************************************************/
    public void novoProduto(){

        //Failure é uma chave que verifica se tudo está ok.
        if(!failure){
            this.produto.setCodigo(ev_codigo);
            this.produto.setReferencia(cad_referencia);
            this.produto.setDescricao(cad_descricao);
            this.produto.setImagem(cad_imagem);
            this.produto.setFornecedor(cad_fornecedor);
            this.produto.setMarca(cad_marca);
            this.produto.setObservacao(cad_observacao);
            this.produto.setPreco_venda(ev_preco);

            exibirProdutos(produto);
            Salvar.salvarProduto(produto);
        }
        else
        {
            System.out.println("Não tem nada aqui!");
        }
    }

    /***************************************************************
     * Exibe uma lista de produtos recebidos por argumentos
     * @param data - Uma lista de produtos
     * @see "LinkedHashSet de Produtos"
     **************************************************************/
    public void exibirProdutos( Produto... data ) {

        if(data != null){
            for(Produto produto : data ){
                System.out.println(produto.getCodigo());
                System.out.println(produto.getDescricao());
                System.out.println(produto.getReferencia());
                System.out.println(produto.getFornecedor());
                System.out.println(produto.getImagem());
                System.out.println(produto.getMarca());
                System.out.println(produto.getObservacao());
                System.out.println(produto.getPreco_venda());
            }
        }

    }
}

