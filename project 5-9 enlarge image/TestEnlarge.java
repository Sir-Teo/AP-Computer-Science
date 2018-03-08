/*
Project 5.9
Obtains a shrink factor from the user,
loads an image, draws it, shrinks it,
and redraws it.
*/

import images.APImage;
import images.Pixel;
import java.util.Scanner;

public class TestEnlarge{

public static void main(String[]args){

// Accept the inputs, create the image, and draw it 
Scanner intReader = new Scanner(System.in); 
System.out.print("Enter an integer growth factor: "); 
int factor = intReader.nextInt(); 
Scanner stringReader = new Scanner(System.in); 
System.out.print("Enter an image file name: "); 
String fileName = stringReader.nextLine(); 
APImage theOriginal = new APImage(fileName); 
theOriginal.draw(); // Create a blank image to receive the pixels 
int oldWidth = theOriginal.getWidth(); 
int oldHeight = theOriginal.getHeight(); 
APImage newImage = new APImage(oldWidth * factor, oldHeight * factor); 
// Add new pixels by factor 
int oldY = 0; 
int newY = 0; 
while (oldY < oldHeight)
{ 
for 
(int i = 1; i <= factor; i++)
{ int oldLeft = 0; 
int oldRight = oldWidth - 1; 
int newLeft = 0; 
int newRight = newImage.getWidth() - 1; 
while (oldLeft < oldRight)
{ 
Pixel leftPixel = theOriginal.getPixel(oldLeft, oldY); 
Pixel rightPixel = theOriginal.getPixel(oldRight, oldY); 
for (int j = 1; j <= factor; j++)
{ newImage.setPixel(newLeft, newY, leftPixel.clone()); 
newImage.setPixel(newRight, newY, rightPixel.clone()); 
newLeft++; 
newRight--; 
} 
oldLeft += 1; 
oldRight--; 
} 
newY++; 
} 
oldY++; 
} 
System.out.print("Press return to continue:"); 
stringReader.nextLine(); 
newImage.draw();
}
}