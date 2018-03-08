/*
Project 5.8
Obtains a shrink factor from the user,
loads an image, draws it, shrinks it,
and redraws it.
*/ 


import images.APImage;
import images.Pixel;
import java.util.Scanner;

public class TestShrink{

   public static void main(String[]args){

      // Accept the inputs, create the image, and draw it
      Scanner intReader = new Scanner(System.in);
      System.out.print("Enter an integer shrink factor: ");
      int factor = intReader.nextInt();
      Scanner stringReader = new Scanner(System.in);
      System.out.print("Enter an image file name: ");
      String fileName = stringReader.nextLine();
      APImage theOriginal = new APImage(fileName);
      theOriginal.draw();

      // Create a blank image to receive the pixels
      int width = theOriginal.getWidth();
      int height = theOriginal.getHeight();
      APImage newImage = new APImage(width / factor, height / factor);

      // Skip over pixels by factor
      int oldY = 0;
      int newY = 0;
      while (oldY < height - factor){
         int oldX = 0;
         int newX = 0;
         while (oldX < width - factor){
            Pixel oldP = theOriginal.getPixel(oldX, oldY);
            Pixel newP = oldP.clone();
            newImage.setPixel(newX, newY, newP);
            oldX += factor;
            newX++;
         }
         oldY += factor;
         newY++;
      }
      System.out.print("Press return to continue:");
      stringReader.nextLine();
      newImage.draw();
   }
}
      