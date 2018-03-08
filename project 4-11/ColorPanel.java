import javax.swing.*; 
import java.awt.*;
public class ColorPanel 
extends JPanel{
   public ColorPanel(Color backColor){       
   setBackground(backColor);
   }
   public void paintComponent(Graphics g)
   {      
   int x = 0;
   int y = 0;
   super.paintComponent(g);
   Color black = Color.black;
   Color red = Color.red;
   for (int k=0;k<4;k++)
   {
   x = 0;
   for(int i=0;i<4;i++)
   {
   g.setColor(black);
   g.fillRect(x,y,100,100);
   x = x + 100;
   g.setColor(red);
   g.fillRect(x,y,100,100);
   x = x + 100;
   }
   y = y + 100;
   x = 0;
   for(int j=0;j<4;j++)
   {
   g.setColor(red);
   g.fillRect(x,y,100,100);
   x = x + 100;
   g.setColor(black);
   g.fillRect(x,y,100,100);
   x = x + 100;
   }
   y = y +100;
   x = 0;
   
   }
   }
      
  }