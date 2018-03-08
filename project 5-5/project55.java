import images.APImage; 
import images.Pixel; 
import java.util.Scanner;
   public class project55{
   public static void main(String[]args){  
   System.out.println(" input filter value R, G, B");  
   Scanner reader = new Scanner(System.in); 
            
   APImage image = new APImage("image.jpg");  
   image.draw();
   int inpred = reader.nextInt();
   int inpgreen = reader.nextInt();
   int inpblue = reader.nextInt(); 
      for (Pixel p : image){
         int red = p.getRed();
         int green = p.getGreen();
         int blue = p.getBlue();        
         if ((blue+inpblue)>=255) 
         {
          p.setBlue(255);
          }
          else if ((red+inpred)>=255) 
         {
          p.setRed(255);
          } 
          else if ((green+inpgreen)>=255) 
         {
          p.setGreen(255);
          }
          
          else 
          {
          p.setRed(red+inpred);
          p.setGreen(green+inpgreen);
          p.setBlue(blue+inpblue);
          
          }
         }
        
         System.out.print("Press return to continue:");
         reader.nextLine();
         image.draw();
      }
   }