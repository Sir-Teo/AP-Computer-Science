/*
Project 5.13
Composes two sound clips to form a third one.
*/

import sounds.*;
import java.util.Scanner;

public class TestCompose{

   public static void main(String[]args){
   
      // Obtain the inputs
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter a file name: ");
      String fileName = reader.nextLine();
      APSoundClip clip1 = new APSoundClip(fileName);
      System.out.print("Enter a file name: ");
      fileName = reader.nextLine();
      APSoundClip clip2 = new APSoundClip(fileName);
      
      // Make clip1 the smaller file and clip2 the larger file
      if (clip1.getLength() > clip2.getLength()){
         APSoundClip temp = clip1;
         clip1 = clip2;
         clip2 = temp;
      }
      
      // Compose the samples into newClip
      APSoundClip newClip = clip2.clone();
      int pos = 0;
      for (Sample clip1Sample : clip1){
         Sample clip2Sample = clip2.getSample(pos);
         int newValue = clip1Sample.getValue() + clip2Sample.getValue();
         newClip.getSample(pos).setValue(newValue);
         pos++;
      }
      
      // Show the new clip
      newClip.draw();
   }
}
      