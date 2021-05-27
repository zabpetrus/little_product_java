package main.java.prototipos.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pidgeot extends Canvas {

    BufferedImage bufferedImage;
    private final String path = "src/main/java/contents/img/" + "produto.png";

    public void paint( Graphics g ){

        try{
            Toolkit t = Toolkit.getDefaultToolkit();
            Image i = t.getImage("produto.png");
            g.drawImage(i, 0, 0, this);
        }catch (Exception err){
            System.out.println("An error");
        }
    }
}
