/*
Project 5.12
Splices two sound clips to form a third one.
*/

import sounds.*;
import java.util.Scanner;

public class TestSplice{

   public static void main(String[]args){
   
      // Obtain the inputs
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter a file name: ");
      String fileName = reader.nextLine();
      APSoundClip clip1 = new APSoundClip(fileName);
      System.out.print("Enter a file name: ");
      fileName = reader.nextLine();
      APSoundClip clip2 = new APSoundClip(fileName);
      
      // Compute the new length and create the output clip
      int silenceLength = (int)(0.1 * clip1.getSamplingRate());
      int newLength = clip1.getLength() + clip2.getLength() + silenceLength;
      APSoundClip newClip = new APSoundClip(newLength);
      
      // Splice the samples into newClip
      int pos = 0;
      for (Sample s : clip1){
         newClip.getSample(pos).setValue(s.getValue());
         pos++;
      }
      pos += silenceLength;
      for (Sample s : clip2){
         newClip.getSample(pos).setValue(s.getValue());
         pos++;
      }
      
      // Show the new clip
      newClip.draw();
   }
}
      