package test;

import main.java.classes.Produto;
import org.junit.Test;

public class Salvar {

    @Test
    public static void main(String[] args) {

        Produto produto = new Produto();

        produto.setCodigo(4);
        produto.setReferencia("Saia floral");
        produto.setDescricao("Saia floral e listrada");
        produto.setImagem("imagem2.png");
        produto.setFornecedor("Solo Levelling LTDA");
        produto.setMarca("Soo Wong");
        produto.setObservacao("Mais uma tentativa");
        produto.setPreco_venda(200.00);

    }
}
