package main.java.prototipos.main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Foto extends JPanel {

    private BufferedImage image;
    private final String path = "src\\main\\java\\com\\blackmagazine\\contents\\img\\" + "produto.png";

    JFrame frame;
    // Not needed or useful!
    //JPanel panel = new JPanel();
    BufferedImage img;
    Graphics g;

    public static void main(String[] args) {
        Foto testMain = new Foto();
        testMain.createFrame();
        testMain.drawGraphics();
    }

    public void createFrame() {
        Foto main = new Foto();
        frame = new JFrame("TEST");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(main.panel);
        frame.getContentPane().add(main);
        frame.setVisible(true);
    }

    public void drawGraphics() {
        //panel.add(new TestMain());
        add(new Foto());
        img = new BufferedImage(800, 450, BufferedImage.TYPE_INT_RGB);
        g = img.createGraphics();
        g.drawString("TEST STRING 2", 250, 250);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, 800, 450);
        // all JComponent instances are image observers
        //g.drawImage(img, 0, 0, null);
        g.drawImage(img, 0, 0, this);
        g.setColor(Color.WHITE);
        // NEW! Otherwise invisible
        g.setColor(Color.RED);
        g.drawString("TEST STRING", 200, 100);
        g.setColor(Color.BLACK);
        g.drawRect(150, 100, 10, 70);
    }

}
