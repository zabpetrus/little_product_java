package main.java.prototipos.main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class SuperFoto extends JPanel {

    private BufferedImage image;
    private final String path = "src\\main\\java\\contents\\img\\" + "produto.png";

    JFrame frame;
    // Not needed or useful!
    //JPanel panel = new JPanel();
    BufferedImage img;
    Graphics g;

    public static void main(String[] args) {
        SuperFoto testMain = new SuperFoto();
        testMain.createFrame();
        testMain.drawGraphics();
    }

    public void createFrame() {
        SuperFoto main = new SuperFoto();
        frame = new JFrame("TEST");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(main.panel);
        frame.getContentPane().add(main);
        frame.setVisible(true);
    }

    public void drawGraphics() {
        //panel.add(new TestMain());
        add(new SuperFoto());
        //img = new BufferedImage(800, 450, BufferedImage.TYPE_INT_RGB);
        try{
            image = ImageIO.read(new File(path));
        }catch (Exception e) {
            System.out.println("Love and Peace");
        }
        g = img.createGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, 800, 450);
        // all JComponent instances are image observers
        g.drawImage(img, 0, 0, this);

    }


}