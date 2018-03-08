import java.util.Scanner;
class rightangle
{
public static void main(String [] arg)
{
while(3>0)
{
System.out.println("input the three sides of a triangle");
Scanner reader = new Scanner(System.in);
double a = reader.nextDouble();
double b = reader.nextDouble();
double c = reader.nextDouble();
if(a*a+b*b==c*c||c*c+a*a==b*b||b*b+c*c==a*a)
{
System.out.println("right triangle");
}
else
{
System.out.println("error ! not right triangle");
}
}
}
}


