import javax.swing.*; 
import java.awt.*;
public class project36 extends JPanel
{
   public ColorPanel(Color backColor)
   {       
   setBackground(backColor);
   }
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

   public void paintComponent(Graphics g){       
   super.paintComponent(g);       
   int x = getWidth() / 2 - 60;       
   int y = getHeight() / 2;       
   g.setColor(Color.blue);       
   g.drawRect(x, y, 120, 20);       
   g.setColor(Color.red);       
   Font font = new Font("Courier", Font.BOLD, 14);       
   g.setFont(font);       
   g.drawString("Hello world!", x + 10, y + 15);    }
 }