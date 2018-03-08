
import java.util.Scanner; 
import java.util.Random;
public class LuckyWithClass 
{    
public static void main (String [] args) 
{
      Scanner reader = new Scanner(System.in);       
      int die1, die2,       
      // two dice           
      dollars,          
      // initial number of dollars (input)           
      count,            
      // number of rolls to reach depletion           
      maxDollars,       
      // maximum amount held by the gambler           
      countAtMax;       
      // count when the maximum is achieved
      // Request the input       
      System.out.print("How many dollars do you have? ");       
      dollars = reader.nextInt();
      // Initialize variables       
      maxDollars = dollars;       
      countAtMax = 0;       
      count = 0;
      Dice dice = new Dice();
      // Loop until the money is gone       
      while (dollars > 0){          
      count++;       
         dice.roll();
         //roll the dice
         die1 = dice.getNumber1();
         // 1-6           
         die2 = dice.getNumber2();
         // 1-6                              
         // Calculate the winnings or losses          
         if (die1 + die2 == 7)             
         dollars += 4;
         else
               dollars -= 1; 
         // If this is a new maximum, remember it          
         if (dollars > maxDollars){             
         maxDollars = dollars;             
         countAtMax = count;
            }
         }
      // Display the results
      System.out.println          
      ("You are broke after " + count + " rolls.\n" +           
      "You should have quit after " + countAtMax +           
      " rolls when you had $" + maxDollars + ".");    
      }
}
class Dice
{
private int number1, number2;
public void roll()
{
Random generator = new Random();
number1 = generator.nextInt(6);
number2 = generator.nextInt(6);
}
public int getNumber1()
{
return number1;
}
public int getNumber2()
{
return number2;
}
}

