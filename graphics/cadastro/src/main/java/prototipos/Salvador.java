package main.java.prototipos;

import main.java.classes.Produto;
import main.java.classes.Salvar;

/**********************************************************
 * classe de teste da classe Salvar arquivo
 * Salva um objeto do tipo Produto no arquivo de texto *
 ********************************************************/
public class Salvador {
    public static void main(String[] args) {

        Produto produto = new Produto();
        produto.setCodigo(999);
        produto.setDescricao("Caneca Star Wars");
        produto.setFornecedor("Industrias Tabajara");
        produto.setImagem("produto.png");
        produto.setMarca("Cia das Canecas");
        produto.setObservacao("Caneca de cor preta");
        produto.setPreco_venda(6.99);
        produto.setReferencia("sdfsdfsd");

        Salvar.salvarProduto(produto);

    }
}
