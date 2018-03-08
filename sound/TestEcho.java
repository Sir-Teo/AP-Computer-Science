/*
Project 5.14
Generates a new sound clip with an echo in a given clip.
*/

import sounds.*;
import java.util.Scanner;

public class TestEcho{

   public static void main(String[]args){
   
      // Obtain the inputs
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter a file name: ");
      String fileName = reader.nextLine();
      APSoundClip clip = new APSoundClip(fileName);
            
      // Echo the samples into newClip
      APSoundClip newClip = clip.clone();
      int delay = 8000;
      int pos = delay + 1;
      while (pos < clip.getLength()){
         Sample echoedSample = clip.getSample(pos - delay);
         int echoedValue = (int)(0.6 * echoedSample.getValue());
         Sample currentSample = newClip.getSample(pos);
         currentSample.setValue(currentSample.getValue() + echoedValue);
         pos++;
      }

      // Display the original and the new clips
      clip.draw();
      newClip.draw();
   }
}
      