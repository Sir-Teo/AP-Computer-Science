/* the following program generate 10 random number
from 1 to 10
   then these 10 numbers are used in step B*/
import java.util.*;
class generator{
   public static void main(String [] args){
   Random generator = new Random();
   int randomnum = 0;
   int sum = 0;
   for(int i = 0; i<10;i++)
   {
   randomnum = generator.nextInt(10);
   System.out.print(randomnum+1+" ");
   }
   }
}
      
