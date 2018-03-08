
import javax.swing.*; 
import java.awt.*;
public class GUIWindow36 {
   public static void main(String[] args){      
   JFrame theGUI = new JFrame();
     theGUI.setTitle("project 3-6 illusion");      
     theGUI.setSize(600,600);
     theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
     ColorPanel panel = new ColorPanel(Color.white);
     Container pane = theGUI.getContentPane();
     pane.add(panel);
     theGUI.setVisible(true);    
     }
}