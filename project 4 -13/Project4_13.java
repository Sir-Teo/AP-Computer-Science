package com.company.cs;

import javax.swing.*;
import java.awt.*;

public class Project4_13 {

    public static void main(String[] args) {
        JFrame GUI = new JFrame();
        GUI.setTitle("Project4-13");
        GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GUI.setSize(800, 400);
        Square newSquare = new Square();
        GUI.add(newSquare);   //Added!!
        GUI.setVisible(true);
    }

}

class Square extends JPanel {
    public Square() {
        setBackground(Color.white);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 400, 400);
        g.setColor(Color.gray);
        g.fillRect(150, 150, 100, 100);
        g.setColor(Color.gray);
        g.fillRect(550, 150, 100, 100);
    }
}



