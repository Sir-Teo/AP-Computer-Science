import javax.swing.*; import java.awt.*;
public class ColorPanel extends JPanel{
   public ColorPanel(Color backColor){       
   setBackground(backColor);
   }
   public void paintComponent(Graphics g){      
   super.paintComponent(g);
   g.drawLine(100,100,500,100);
   g.drawLine(100,500,500,500);
   g.drawLine(100,100,50,50);
   g.drawLine(100,100,50,150);
   g.drawLine(500,100,550,50);
   g.drawLine(500,100,550,150);
   g.drawLine(100,500,150,450);
   g.drawLine(100,500,150,550);
   g.drawLine(500,500,450,450);
   g.drawLine(500,500,450,550);
   }
   }