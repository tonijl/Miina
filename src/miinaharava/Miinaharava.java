package miinaharava;


import java.awt.Cursor;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Miinaharava {
    public static void main(String args[]){
        JFrame f = new JFrame();
        Ohjaus s = new Ohjaus();
        f.add(s);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400,400);
                // Transparent 16 x 16 pixel cursor image.

    }
}
