import javax.swing.*; 
import java.awt.*;
public class ColorPanel 
extends JPanel{
   public ColorPanel(Color backColor){       
   setBackground(backColor);
   }
   public void paintComponent(Graphics g)
   {      
   super.paintComponent(g);
   Color black = Color.black;
   Color gray = Color.gray;
   g.setColor(black);
   g.fillRect(0,0,400,400);
   g.setColor(gray);
   g.fillRect(150,150,100,100);
   g.fillRect(550,150,100,100);
   }
   }