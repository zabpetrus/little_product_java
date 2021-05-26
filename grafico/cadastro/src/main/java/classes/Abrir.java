package main.java.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.regex.Pattern;

/***************************************************************
 * Essa classe é responsável por abrir um arquivo e retornar
 * todos os dados dele
 * @author Izabel Santos
 **************************************************************/
public class Abrir {

    private static final String path = "src/main/java/contents/scripts/";
    private static final LinkedHashSet<Produto> texto = new LinkedHashSet<>();
    private static final String nomearquivo = "produtos.txt";
    protected Produto produto = new Produto();

    public Abrir() {

        try{
            String pathname = path + nomearquivo;
            BufferedReader bufReader = new BufferedReader(new FileReader(pathname));
            LinkedList<String> listOfLines = new LinkedList<>();
            int numero = 1;
            String line = bufReader.readLine();
            while (line != null) {
                if(line.length() != 0){

                    //Testando. A leitura tem linhas em branco
                    listOfLines.add(line);

                    //Obtendo o codigo do produto
                    if (line.contains("Codigo") ) {
                        String cod = (line.replace("Codigo: ", "").strip());

                        boolean isNumber = Pattern.matches("[0-9]+", cod);
                        if(isNumber) {
                            numero = Integer.parseInt(cod);
                        }
                        produto.setCodigo(numero);
                    }
                    //Obtendo a referencia
                    if (line.contains("Referencia")) {
                        String referencia = line.replace("Referencia:", "");
                        produto.setReferencia(referencia);
                    }

                    //Obter a Descricao
                    if (line.contains("Descricao")) {
                        String descricao = line.replace("Descricao:", "");
                        produto.setDescricao(descricao);
                    }

                    //Obtendo o path da imagem
                    if (line.contains("Imagem")) {
                        String imagem = line.replace("Imagem:", "");
                        produto.setImagem(imagem);
                    }

                    //Obtendo o texto Fornecedor
                    if (line.contains("Fornecedor")) {
                        String fornecedor = line.replace("Fornecedor:", "");
                        produto.setFornecedor(fornecedor);
                    }

                    //Obter Obsercação
                    if (line.contains("Observacao")) {
                        String observacao = line.replace("Observacao:", "");
                        produto.setObservacao(observacao);
                    }

                    //Obtendo o Preco
                    if (line.contains("Marca")) {
                        String marca = line.replace("Marca:", "");
                        produto.setMarca(marca);
                    }

                    //Obtendo o Preco e este é o último da lista.
                    //A sequencia da leitura das linhas deve ser obedecida
                    //Se uma linha for ignorada, já era!

                    if (line.contains("Preco")) {
                        String preco = line.replace("Preco:", "");
                        produto.setPreco_venda(Double.parseDouble(preco));
                        texto.add(produto);
                        produto = new Produto();
                    }
                }
                line = bufReader.readLine();
            }
            bufReader.close();

        }
        catch (Exception e){
            System.out.println("Erro em " + getClass() + " : " + e);
        }
    }

    /***************************************************************
     * @return "Um LinkedHashSet de Produtos que contém todos os produtos "
     * @see "LinkedHashSet de Produtos"
     **************************************************************/
    public LinkedHashSet<Produto> getListaProdutos() {
        return texto;
    }

}
