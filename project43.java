import java.util.*;
public class project43
{
public static void main(String [] args)
{
Scanner reader = new Scanner(System.in);
double length = reader.nextDouble();
double money = 0;
while(0==0)
{
if(length>2)
{
money = 2 + 0.5*(length - 2);
break;
}
else if((length>0)&&(length<2))
{
money = 2;
break;
}
else
{
System.out.println("error!! try again");
break;
}
}
System.out.println("the money is " + money);
}
}