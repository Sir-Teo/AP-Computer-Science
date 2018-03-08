package com.company.cs;

import javax.swing.*;
import java.awt.*;

public class Project3_6 {

    public static void main(String[] args) {
        JFrame GUI = new JFrame();
        GUI.setTitle("Project4-13");
        GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GUI.setSize(400, 300);
        Line newSquare = new Line();
        GUI.add(newSquare);   //Added!!
        GUI.setVisible(true);
    }

}

class Line extends JPanel {
    public Line() {
        setBackground(Color.white);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawLine(100,100,300,100); //1
        g.drawLine(100,200,300,200); //2
        // 1
        // Front
        g.drawLine(100,100, 80,80);
        g.drawLine(100,100,80,120);
        // End
        g.drawLine(300,100, 320,120);
        g.drawLine(300,100,320,80);
        // 2
        // Front
        g.drawLine(100,200, 120,220);
        g.drawLine(100,200,120,180);
        // End
        g.drawLine(300,200, 280,180);
        g.drawLine(300,200,280,220);
    }
}



