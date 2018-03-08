/*********************************************************************

* *project 1

** Copyright

* Teo zeng 

* *

* AP Computer Science Java Period 1

* *

* Starting Date:september 10th Due Date:september 9th

* *

* This program will identify whose program listing it is through the

* use of comments. It will also identify who the output belongs to

* through the use of println statements.

*********************************************************************/
import java.util.*;
import java.io.*;

//import some essensial package for the program

class project1

//the name of the program is project1

   {
   public static void main(String [] args) throws IOException
   
// must throw the exception in input/output

      {
      int runner_time[] = new int[17]; 
      String runner_name[] = new String [17];
      int a; 
      int b;
      int max = 300;
      String max_name = "name";
      
//initialize vairables, arrays

      Scanner reader = new Scanner(new File("runnerlist"));
      
//the scanner should read the data from the file, runnerlist

      for(int i=1;i<=16;i++)
      
//create a loop, the loop should run 16 times

         {
         runner_name[i]=reader.next();
         runner_time[i]=reader.nextInt();
         
         
//the next name and the number should be read by the above statement

         a = runner_time[i];
         b = runner_time[i-1];
         
//a and b are assign to the array with an index of i and i-1

         if(a<b&&b<max)
            {
            max = a;
            max_name = runner_name[i];
            }
            
// judgement: if a>b, then a will be assigned to the max value, same as the correspondent name

         else if(b<a&&a<max)
            {
            max = b;
            max_name = runner_name[i-1];
            }
            
//judegement: if b>a, then b will be assigned to the max value, same as the correspondent name

         }
         System.out.println("the fastest runner is " + max_name);
         System.out.println("the score is " + max);
         System.out.println("****************************\n**project1\n*Teo zeng\n*AP ComputerScience Period 1\n*Due date: September 29th\n***************************");
         
//print out the result, max name and max score

      }
   }



