/*
Project 5.10
Loads an image, draws it, rotates it 90 degrees
counterclockwise, and redraws it.
*/ 

import images.APImage;
import images.Pixel;
import java.util.Scanner;

public class TestRotate{

   public static void main(String[]args){

      // Accept the inputs, create the image, and draw it
      Scanner intReader = new Scanner(System.in);
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter an image file name: ");
      String fileName = reader.nextLine();
      APImage theOriginal = new APImage(fileName);
      theOriginal.draw();

      // Create a blank image, reversing width and height
      int width = theOriginal.getWidth();
      int height = theOriginal.getHeight();
      APImage theNew = new APImage(height, width);

      // Copy pixels from rows to columns
      int newX = 0;
      for (int y = 0; y < height; y++){
         int newY = width - 1;
         for (int x = 0; x < width; x++){
            Pixel p = theOriginal.getPixel(x, y);
            theNew.setPixel(newX, newY, p.clone());
            newY--;
         }
         newX++;
      }
      System.out.print("Press return to continue:");
      reader.nextLine();
      theNew.draw();
   }
}
      