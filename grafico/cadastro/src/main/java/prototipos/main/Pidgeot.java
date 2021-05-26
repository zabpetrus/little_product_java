package main.java.prototipos.main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Pidgeot extends Canvas {

    BufferedImage bufferedImage;
    private String path = "src/main/java/contents/img/" + "produto.png";

    public void paint( Graphics g ){

        try{
            Toolkit t = Toolkit.getDefaultToolkit();
            Image i = t.getImage("produto.png");
            g.drawImage(i, 0, 0, this);
        }catch (Exception err){
            System.out.println("An error");
        }
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("damdajodiewr");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 210);
        frame.setVisible(true);

        Pidgeot pidgeot = new Pidgeot();
        frame.add(pidgeot);

    }
}
