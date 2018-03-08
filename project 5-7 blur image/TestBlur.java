/*
Project 5.7
Loads an image, draws it, blurs it, and redraws it.
*/ 

import images.APImage;
import images.Pixel;
import java.util.Scanner;

public class TestBlur{

   public static void main(String[]args){

      // Accept the inputs, create the image, and draw it
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter an image file name: ");
      String fileName = reader.nextLine();
      APImage theOriginal = new APImage(fileName);
      theOriginal.draw();

      // Create a copy of the image to blur
      APImage newImage = theOriginal.clone();

      // Visit all pixels except for those on the perimeter
      for (int y = 1; y < theOriginal.getHeight() - 1; y++)
         for (int x = 1; x < theOriginal.getWidth() - 1; x++){

            // Obtain info from the old pixel and its neighbors
            Pixel old = theOriginal.getPixel(x, y);
            Pixel left = theOriginal.getPixel(x - 1, y);
            Pixel right = theOriginal.getPixel(x + 1, y);
            Pixel top = theOriginal.getPixel(x, y - 1);
            Pixel bottom = theOriginal.getPixel(x, y + 1);
            int redAve = (old.getRed() + left.getRed() + right.getRed() + 
                          top.getRed() + bottom.getRed()) / 5;
            int greenAve = (old.getGreen() + left.getGreen() + right.getGreen() + 
                            top.getGreen() + bottom.getGreen()) / 5;
            int blueAve = (old.getBlue() + left.getBlue() + right.getBlue() + 
                           top.getBlue() + bottom.getBlue()) / 5;

            // Reset new pixel to that info
            Pixel newPixel = newImage.getPixel(x, y);
            newPixel.setRed(redAve);
            newPixel.setGreen(greenAve);
            newPixel.setBlue(blueAve);
         }
      System.out.print("Press return to continue:");
      reader.nextLine();
      newImage.draw();
   }
}
      