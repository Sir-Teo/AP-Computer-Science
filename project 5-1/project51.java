import images.APImage; 
import images.Pixel; 
import java.util.Scanner;
import java.util.Random;
   public class project51{
   public static void main(String[]args){       
   Scanner reader = new Scanner(System.in);       
   APImage image = new APImage("image.jpg");   
   Random random = new Random();
   int color1red = random.nextInt(255);
   int color1blue = random.nextInt(255);
   int color1green = random.nextInt(255);
   int color2red = random.nextInt(255);
   int color2blue = random.nextInt(255);
   int color2green = random.nextInt(255);
   image.draw();
      for (Pixel p : image){
         int red = p.getRed();
         int green = p.getGreen();
         int blue = p.getBlue();
         int average = (red + green + blue) / 3;          
         if (average < 128){             
         p.setRed(color1red);             
         p.setGreen(color1green);             
         p.setBlue(color1blue);
         }else{             
         p.setRed(color2red);             
         p.setGreen(color2green);             
         p.setBlue(color2blue);          
         }
         }
         System.out.print("Press return to continue:");
         reader.nextLine();
         image.draw();
      }
   }