import java.io.*;
import java.util.*;
class rect{
public static void main(String[] args){
while(true){
Scanner reader = new Scanner(System.in);
System.out.println("please enter the length");
double length = reader.nextDouble();
System.out.println("please enter the width");
double width = reader.nextDouble();
double area = width * length;
double circumference = 2*(length + width);

System.out.println("the area is "+area);
System.out.println("the circumference is "+circumference);
}
}
}
