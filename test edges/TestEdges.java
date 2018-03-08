import images.APImage; 
import images.Pixel; 
import java.util.Scanner;
public class TestEdges{
   public static void main(String[]args){
         // Accept the inputs, create the image, and draw it
      Scanner intReader = new Scanner(System.in);       
      System.out.print("Enter an integer threshold: ");       
      int threshold = intReader.nextInt();       
      Scanner stringReader = new Scanner(System.in);       
      System.out.print("Enter an image file name: ");       
      String fileName = stringReader.nextLine();       
      APImage theOriginal = new APImage(fileName);       
      theOriginal.draw();
         // Create a blank image to receive the edges
      int width = theOriginal.getWidth();
      int height = theOriginal.getHeight();       
      APImage theSketch = new APImage(width, height);
      // Visit all pixels except for the left column and       
      // bottom row
      for (int y = 0; y < height - 1; y++)
         for (int x = 1; x < width; x++){
            // Obtain info for a pixel and its left and bottom             
            // neighbors
            Pixel oldPixel = theOriginal.getPixel(x, y);             
            Pixel leftPixel = theOriginal.getPixel(x - 1, y);             
            Pixel bottomPixel = theOriginal.getPixel(x, y + 1);
            int oldAve = (oldPixel.getRed() +oldPixel.getGreen() + oldPixel.getBlue()) / 3;             int leftAve = (leftPixel.getRed() +                            leftPixel.getGreen() +                            leftPixel.getBlue()) / 3;             int bottomAve = (bottomPixel.getRed() +                              bottomPixel.getGreen() +                              bottomPixel.getBlue()) / 3;
               // If difference is below threshold, reset to white
            Pixel newPixel = theSketch.getPixel(x, y);             
            if (Math.abs(oldAve - leftAve) <= threshold ||                 
            Math.abs(oldAve - bottomAve) <= threshold){                
            newPixel.setRed(255);                
            newPixel.setGreen(255);                
            newPixel.setBlue(255);
               }
            }
         theSketch.draw();
      }
}
