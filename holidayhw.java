import java.util.*;
import java.io.*;
public class holidayhw
{
   public static void main(String [] args) throws IOException
   {
   Scanner reader = new Scanner(new File("AccountData"));
   int Account [] = new int [4];
   double Beginning_Balance [] = new double [4];
   String owner [] = new String[4];
   String owner2 [] = new String[4];
   double Ending_balance [] = new double [4];
   for(int i=0;i<4;i++)
         {
         Account[i] = reader.nextInt();
         Beginning_Balance [i] = reader.nextDouble();
         owner [i] = reader.next();
         if(reader.hasNextInt())
            {
            owner2[i]="";
            continue;
            }
         else
            {
            owner2[i]= reader.next();
            }
         }
         for(int j=0;j<4;j++)
            {
            Ending_balance[j]=Beginning_Balance[j]*1.1;
            }
            PrintWriter writer = new PrintWriter(new File("AccountReport.txt"));
            writer.println("Account\tOwner\tBeginning Balance\t Ending balance\n\n");
         for(int i=0;i<4;i++)
         {
         writer.println(Account[i]+"\t"+owner[i]+" "+owner2[i]+"\t"+Beginning_Balance[i]+"\t"
         +Ending_balance[i]);
         }
         writer.close();


      }

   }