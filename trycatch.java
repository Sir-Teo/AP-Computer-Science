class trycatch
{
public static void main(String[]args)
{
int dividend = 1;
int divisor = 0;
try{
int quotient = dividend / divisor; 
System.out.println("Successful division");
}
catch (ArithmeticException e){
System.out.println("Error1: " + e.toString());
}
}
}