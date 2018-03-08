import javax.swing.*;    // For JFrame and JPanel
import java.awt.*; 
class testGUI
{      // For Color and Container public class GUIWindow{
   public static void main(String[] args){       
   JFrame theGUI = new JFrame();       
   theGUI.setTitle("Second GUI Program");       
   theGUI.setSize(300, 200);       
   theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
   JPanel panel = new JPanel();       
   panel.setBackground(Color.pink);       
   Container pane = theGUI.getContentPane();       
   pane.add(panel);
   theGUI.setVisible(true);    
   }
}
