package com.company.cs;

import javax.swing.*;
import java.awt.*;

public class Project4_11 {

    public static void description() {
        System.out.print("A checkerboard consists of an 8-by-8 grid of black and red squares in which no two squares of the same color are adjacent. Write a graphics program that displays a checkerboard.");
    }

    public static void main(String[] args) {
        JFrame GUI = new JFrame();
        GUI.setTitle("Project4-11");
        Container pane = GUI.getContentPane();
        pane.setLayout(new GridLayout(8, 8));

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) pane.add(new PreparedPanel(Color.red));
                    else pane.add(new PreparedPanel(Color.black));
                } else {
                    if (j % 2 == 0) pane.add(new PreparedPanel(Color.black));
                    else pane.add(new PreparedPanel(Color.red));
                }
            }
        }
        GUI.pack();                            //Added!!
        GUI.setVisible(true);
    }
}


class PreparedPanel extends JPanel {

    public PreparedPanel(Color getColor) {
        setBackground(getColor);
        setPreferredSize(new Dimension(50, 50));
    }

}
