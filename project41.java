import java.util.*;
public class project41
{
public static void main(String [] args)
{
Scanner reader = new Scanner(System.in);
int input1 = reader.nextInt();
int input2 = reader.nextInt();
int big = 0;
int small = 0;
if(input1>input2)
{
big = input1;
small = input2;
}
else if(input1==input2)
{
big = input1;
small = input2;
}
else
{
big = input2;
small = input1;
}
int answer = big/small;
int residual = big%small;
System.out.println("equals " + answer + " r " + residual);
}
}