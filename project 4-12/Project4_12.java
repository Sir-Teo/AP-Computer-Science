

import javax.swing.*;
import java.awt.*;

public class Project4_12 {


    public static void main(String[] args) {
        JFrame GUI = new JFrame();
        Integer row = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of Row you want to display", 2));
        Integer col = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of Col you want to display", 2));
        GUI.setTitle("Project4-12");
        Container pane = GUI.getContentPane();

        pane.setLayout(new GridLayout(row, col));

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
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


