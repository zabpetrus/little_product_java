package main.java.prototipos;

import main.java.classes.Produto;
import main.java.classes.Salvar;

public class Salvador {
    public static void main(String[] args) {

        Produto produto = new Produto();
        produto.setCodigo(999);
        produto.setDescricao("oasjdoaijdioas");
        produto.setFornecedor("adasdasdas");
        produto.setImagem("asdasdasd");
        produto.setMarca("saasdasdsa");
        produto.setObservacao("dadasdasd");
        produto.setPreco_venda(6.99);
        produto.setReferencia("sdfsdfsd");

        Salvar.salvarProduto(produto);

    }
}
