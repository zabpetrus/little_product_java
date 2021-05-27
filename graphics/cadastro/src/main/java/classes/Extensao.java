package main.java.classes;

import main.java.sources.Marcas;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.LinkedHashSet;

/***************************************************************
 * Esta é uma classe de suporte da classe principal
 * Ela contém os métodos para renderização do painel
 * @author Izabel Santos
 ***************************************************************/

public class Extensao extends JFrame {

    /***********************************************************************
     * @return "Um vetor de String que contem os dados de um Enum das marcas"
     * @see "Vetor de String"
     **********************************************************************/
    protected String[] comboValues(){

        Marcas[] marcas = Marcas.values();
        String[] temp = new String[ marcas.length ];

        try{
            int i = 0;
            for( Marcas item : marcas){
                temp[i] = item.name();
                i = i + 1;
            }
        }catch (Exception e){
            System.out.println("Error in <Extensao> " + e);
        }
        return  temp;
    }

    /**********************************************************************************
     * @return "Retorna uma String que é o nome do arquivo escolhido pelo JFileChooser"
     * @see "String"
     **********************************************************************************/
    protected String obterImagem(){

        JFileChooser fileChooser = new JFileChooser(); //Abre a janela de diretórios do sistema operacional
        fileChooser.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES); //O que exibirá na janela
        fileChooser.setFileFilter( new FileNameExtensionFilter("PNG images", "png"));

        int result = fileChooser.showOpenDialog(this);

        if(result == JFileChooser.CANCEL_OPTION)
            System.exit(1);

        File fileName = fileChooser.getSelectedFile(); //Obtem a origem do arquivo

        //Se são tem arquivo de origem, não faz sentido continuar.
        if((fileName == null) || (fileName.getName().equals("") )){
            JOptionPane.showMessageDialog(this, "Invalid file Name", "Invalid file Name", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        //Já tendo o nome do arquivo de origem, fazemos a cópia dele pra nossa pasta de projeto
        Upload carga = new Upload(fileName); //Move o arquivo e o gera na pasta escolhida

        return ( carga.getImagePath() );  //Retorna o caminho da imagem destino
    }

    /***************************************************************
     * @param produtos  "recebe um objeto tipo LinkedHashSet de produtos "
     * @return "Uma matriz de String para o painel"
     * @see "Matriz de String"
     **************************************************************/
    protected String [][] converterDados (LinkedHashSet<Produto> produtos )
    {
        String[][] temp = new String[produtos.size()][];

        try{
            int i = 0;
            for(Produto produto : produtos){
                String[] aux = new String[] { Integer.toString(produto.getCodigo()), produto.getDescricao(), produto.getReferencia(), produto.getFornecedor(), produto.getImagem(), produto.getMarca(), produto.getObservacao(), Double.toString(produto.getPreco_venda()) };
                temp[i] = aux;
                i++;
            }

        }catch (Exception e){
            System.out.println("Erro em (Extensao file) " + getClass() + " : " + e);
        }
        return temp;
    }


}
