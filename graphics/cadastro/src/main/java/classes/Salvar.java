package main.java.classes;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedHashSet;

/***************************************************************
 * Essa classe é responsável pelo salvamento dos dados
 * @author Izabel Santos
 **************************************************************/
public class Salvar {

    private static final String path = "src\\main\\java\\contents\\scripts\\";

    /***************************************************************
     * Essa função salva um produto e adiciona no arquivo
     * @param produto  "recebe um objeto tipo Produto"
     ***************************************************************/
    public static void salvarProduto( Produto produto ){

        LinkedHashSet<String> fila = new LinkedHashSet<>();
        fila.add("Codigo: " + produto.getCodigo()  );
        fila.add("Referencia: " + produto.getReferencia());
        fila.add("Descricao: " + produto.getDescricao());
        fila.add("Imagem: " + (produto.getImagem()).replace("src/main/java/contents/img/", ""));
        fila.add("Fornecedor: " + produto.getFornecedor());
        fila.add("Marca: " + produto.getMarca());
        fila.add("Observacao: " + produto.getObservacao());
        fila.add("Preco: " + produto.getPreco_venda());
        fila.add("\n");

        Abrir foo = new Abrir();
        LinkedHashSet<Produto> aux = foo.getListaProdutos();


        for(Produto temp2 : aux ){
            if(temp2 != null){
                if(temp2.compareTo(produto) > 0){
                    JOptionPane.showMessageDialog(null, "Já tem parça!");
                    System.exit(1);
                }
            }
        }

        try{
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(path + "produtos.txt", true));
            for(String produtos : fila){
                if(produtos.isEmpty()){
                    throw new Exception("Sem conteúdo válido!");

                }
                myWriter.write(produtos);
                myWriter.newLine();
            }
            myWriter.close();
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com sucesso!");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ops! Houve um erro!" + e);
        }
    }
}
