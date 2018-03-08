package sounds;

/**
 * LICENSE: This is open-source software released under the terms of the<BR>
 * GPL (http://www.gnu.org/licenses/gpl.html).<BR><BR> 
 * 
 * This class represents a sample that contains an integer value.
 */

public class Sample{

    /**
     * The maximum value of a sample.
     */
   static public int MAX_VALUE = 32767;
   
    /**
     * The minimum value of a sample.
     */
   static public int MIN_VALUE = -32768;

   private int value = 0;

    /**
     * Creates a Sample with a value of 0.
     */
   public Sample(){
      this(0);
   }

    /**
     * Creates a Sample from given integer value.
     * @param v the integer value
     */
   public Sample(int v){
      value = v;
   }

    /**
     * Returns the value of the sample.
     * @return the sample's value
     */
   public int getValue(){
      return value;
   }

    /**
     * Resets the sample's  value.
     * @param v the new value
     */
   public void setValue(int v){
      value = v;
   }

    /**
     * Returns the string representation of the of the sample.
     * @return a string containing the value
     */
   public String toString(){
      return "" + value;
   }
   

}