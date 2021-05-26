package main.java.classes;

import javax.imageio.ImageIO;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/***************************************************************
  Classe responsável pelo Upload de Arquivos
 * @author Izabel Santos
 **************************************************************/
public class Upload {

    private String destino;

    public Upload (File fileName) {

        //O arquivo é obtido por fileChooser.getSelectedFile();
        //E é recebido por argumento
        try{

            ImageIO.read(fileName); //Esse método só funciona dentro de um Try/Catch
            String origem = fileName.getPath(); //Obter o path do arquivo
            String nomedearquivo = new SimpleDateFormat("yyyyMMddHHmm").format(new Date()); //Um nome usando a data
            destino = "src/main/java/contents/img/" + nomedearquivo + ".png"; //carregar a imagem para a pasta assets/img
            File file = new File(origem); //Gerando um novo arquivo
            if(file.renameTo( new File(destino))){ //copiando o imagem para a nova
                System.out.println("Ok!"); //O console mostra um ok;
            }
        }
        catch (Exception e){
            System.out.println("Erro em " + getClass() + " : " + e); //O console mostra o erro
        }
    }
    /***************************************************************
     * Classe que retorna o caminho de destino da imagem
     * @return o uma String que é o destino do arquivo carregado
     * @see String
     **************************************************************/
    public String getImagePath() {
        return this.destino;
    }
}
