import java.util.Scanner;
class momentum
{
   public static void main (String [] args)
   {
     Scanner reader = new Scanner(System.in);
     double mass = reader.nextDouble();
     double velocity = reader.nextDouble();
     System.out.println("The momentum is " + mass * velocity);
     System.out.println("The kinetic energy is " + 0.5 * mass * velocity * velocity);
   }
} 