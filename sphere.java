import java.util.Scanner;
class sphere
{
public static void main(String [] args)
{
System.out.println("enter the radius");
Scanner reader = new Scanner(System.in);
double radius = reader.nextDouble();
double diameter = radius * 2;
double surfacearea = 4 * 3.14 * radius * radius;
double circumference = 2 * 3.14 * radius;
double volume = (4/3) * 3.14 * radius * radius * radius;
System.out.println("diameter =" +diameter);
System.out.println("surface area =" +surfacearea );
System.out.println("circumference ="+ circumference);
System.out.println("volume ="+ volume);
}}