import java.util.Scanner;
public class decimaltobinary {

public static void main(String [] arguments)
{
System.out.println("input the decimal number");
Scanner reader = new Scanner (System.in);
int decimal = reader.nextInt();
int count = 0;
int binary = 0;
while(decimal>0)
{
int power = (int) Math.pow(10,count);
if (decimal % 2==1)
{
 decimal = decimal - 1 ;
 decimal = decimal/2;
 binary = binary + 1 * power;
count = count + 1;
}
else
{
decimal = decimal/2;
count = count + 1;
}
}
System.out.println("The equivalent binary is " + binary);
}}