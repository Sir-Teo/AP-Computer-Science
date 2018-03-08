
import javax.swing.*; 
import java.awt.*;
public class GUIWindow413 {
   public static void main(String[] args){      
   JFrame theGUI = new JFrame();
     theGUI.setTitle("project 4-13 contrast illusion");      
     theGUI.setSize(800,400);
     theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
     ColorPanel panel = new ColorPanel(Color.white);
     Container pane = theGUI.getContentPane();
     pane.add(panel);
     theGUI.setVisible(true);    
     }
}