/*
Project 5.11
Changes the volume of a sound clip, while keeping sample values
within the valid range.
*/

import sounds.APSoundClip;  
import sounds.Sample;
import java.util.Scanner;

public class TestVolume{

   public static void main(String[]args){
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter a volume factor: ");
      double factor = reader.nextDouble();
      APSoundClip clip = new APSoundClip("money.wav");
      clip.draw();
      clip.play();
      for (Sample s : clip){
         int newValue = (int) (s.getValue() * factor);
         if (newValue > 0)
            newValue = Math.min(newValue, Sample.MAX_VALUE);
         else if (newValue < 0)
            newValue = Math.max(newValue, Sample.MIN_VALUE);
         s.setValue(newValue);
      }
   }
}
      