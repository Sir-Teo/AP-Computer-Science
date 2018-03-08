/*
Project 5.15
Reverses the samples in a clip so it can be played backwards.
The first sample is left in its position.
*/

import sounds.APSoundClip;
import sounds.Sample;

public class TestReverse{

   public static void main(String[]args){
      APSoundClip clip = new APSoundClip("money.wav");
      clip.draw();
      int length = clip.getLength();
      int left = 1;
      int right = length - 1;
      while (left < right){
          Sample leftSample = clip.getSample(left);
          Sample rightSample = clip.getSample(right);
          clip.setSample(left, rightSample);
          clip.setSample(right, leftSample);
          left++;
          right--;
      }
   }
}