import java.awt.*;
import java.util.Scanner;
public class foo {

public static void main(String [] arguments)
{
   System.out.println("type in the base pay and the hours worked");
   Scanner reader = new Scanner (System.in);
   double a;//the base pay
   int b;//the hours worked
   a = reader.nextDouble();
   b = reader.nextInt();
   double c = a * b ;//the salary paid when the employees work less or equal to 40hrs
   double d = a * (b-40) *1.5 + 40 * a;
   if (a<8.00||b>60)
   {
   System.out.println("error");
   }
   if (a>=8.00&&b<=60&&b>=40)
   {
   System.out.println(d);
   }
   else if (a>=8.00&&b<40&&b>=0)
   {
   System.out.println(c);
   }
   else
   {
   System.out.println("error");
   }
   }
   }
   