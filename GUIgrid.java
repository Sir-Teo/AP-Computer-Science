import javax.swing.*;    // For JFrame and JPanel
import java.awt.*;       // For Color, Container, and GridLayout 
public class GUIgrid{
   public static void main(String[] args){       
   JFrame theGUI = new JFrame();       
   theGUI.setTitle("Fourth GUI Program");       
   theGUI.setSize(300, 200);       
   theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
   JPanel panel1 = new JPanel();        
   panel1.setBackground(Color.white);       
   JPanel panel2 = new JPanel();        
   panel2.setBackground(Color.black);       
   JPanel panel3 = new JPanel();        
   panel3.setBackground(Color.gray);       
   JPanel panel4 = new JPanel();        
   panel4.setBackground(Color.white); 
   JPanel panel5 = new JPanel();
   panel5.setBackground(Color.green); 
   JPanel panel6 = new JPanel();
   panel6.setBackground(Color.red);     
   Container pane = theGUI.getContentPane();       
   pane.setLayout(new GridLayout(2, 3));       
   pane.add(panel1);
      pane.add(panel2);       
      pane.add(panel3);       
      pane.add(panel4);  
      pane.add(panel5);   
      pane.add(panel6);  
      theGUI.setVisible(true);    }
}