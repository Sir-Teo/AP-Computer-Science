import java.util.*;
import java.io.*;
public class HWtest
{
   public static void main(String [] args) throws IOException
   {
   /*List<String> name = new ArrayList<String>();
   Scanner reader = new Scanner(new File("AccountData"));
   for(int i=0;i<30;i++)
   {
   List.add(reader.next());
   }
   PrintWriter writer = new PrintWriter(new File("AccountReport.txt"));
   writer.println(list.get(i));
   writer.close();
   */
      List<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) list.add(i, "Item" + (i + 1));
        for (int i = 0; i < list.size(); i++) 
        System.out.println(list.get(i));     
    }
}