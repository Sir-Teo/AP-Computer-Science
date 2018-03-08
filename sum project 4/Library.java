import java.util.*;
public class Library {
   String address = "";
   String[] BookName = {"","","","","","","","","",""};
   String[] TempName = {"","","","","","","","","",""};
   String[] Owned = {"","","","","","","","","",""};
   int count = 0;
   int BookIndex = 0;
   boolean[] BookStatus = new boolean[10]; //true is unborrowed; false is borrowed
   
      public Library (String adrs){
      address = adrs;
      for(boolean elements: BookStatus)
      elements = true;
      }

      public void addBook(String bookname){
         BookName[BookIndex] = bookname;
         BookStatus[BookIndex] = true;
         BookIndex++;
      }
      
      public void Borrow(String bookname){
         boolean find = false;//true, the book is found; false, the book is not
         for(int i=0;i<10;i++){
            if(bookname.equals(BookName[i])){
               find = true;
               if(BookStatus[i] == false){
               System.out.println("the book is already borrowed");
               }
               else
               BookStatus[i] = false;
               TempName[i] = BookName[i];
               Owned[count] = BookName[i];
               BookName[i] = "Borrowed";
               count++;
            }
         }
         if(find == false){
         System.out.println("you entered the wrong name, please type it again");
         }
      }     
      
      public void Return(String bookname){
         boolean find = false;
         for(int i=0;i<10;i++){
            if(bookname.equals(TempName[i])){
            find = true;
               if(BookStatus[i] == true)
               System.out.println(" error! the book is not borrowed, dont return it");
               else{
                  for(int j=0;j<10;j++){
                        if(Owned[j].equals(bookname)){ 
                        Owned[j] = "";     
                        BookStatus[i] = true;
                        BookName[i] = TempName[i]; 
                     } 
                  }  
               }      
            }
         }
         if(find == false){
         System.out.println("you entered the wrong name, please type it again");
         }
      }   
         
         
      public String getBookName(int index){
      return BookName[index];
      } 
               
      public String AvailableBooks(){
         String str = "\nThis is " + address + "\nAvailable Books: " 
          + "\n[1] " + BookName[0] + "\t[2] " + BookName[1]           
          + "\t[3] " + BookName[2] + "\n[4] " + BookName[3]
          + "\t[5] " + BookName[4] + "\t[6] " + BookName[5];
         return str;
      }   
      
      public String getOwnedBooks(){
         String str = "\n your books borrowed in " + address + "\n[1]" + Owned[0] + "\n[2]" + Owned[1] + 
                                          "\n[3]" + Owned[2] + "\n[4]" + Owned[3] + "\n[5]" + Owned[4] + "\n[6]" + Owned[5];
         return str;
      }
      
public static void main(String[] args) {
   boolean Repeat = false;
   // Create two libraries
   Library Library1 = new Library("10 Main St. Library (Library 1)"); 
   Library Library2 = new Library("228 Liberty St. Library (Library 2)");
   // Add books to it
   Library1.addBook("happydog"); 
   Library1.addBook("teo"); 
   Library1.addBook("SAT"); 
   Library1.addBook("biology");
   Library2.addBook("Physics"); 
   Library2.addBook("CS"); 
   Library2.addBook("Econ"); 
   Library2.addBook("Statistics");
   
   System.out.println("***CS Project Library System***");
   System.out.println(Library1.AvailableBooks());
   System.out.println(Library2.AvailableBooks());
   Scanner reader = new Scanner(System.in);
   String option = "0";
   String inpName = "";
   while(Repeat == false){
      System.out.println("Options (please enter numbers):" + "\n[1] Borrow Books from Library 1\n[2] Borrow Books from Library 2"+
                                      "\n[3] Return Books to Library 1  \n[4] Return Books to Library 2 \n[5] Add a book in Library 1"+
                                      "\n[6] Add a book in library 2    \n[7] Exit");
      option = reader.next();
      
      if(option.equals("1")){
         System.out.println("enter the exact book name you want to borrow");
         inpName = reader.next();
         Library1.Borrow(inpName);
      }

      else if(option.equals("2")){
         System.out.println("enter the exact book name you want to borrow");
         inpName = reader.next();
         Library2.Borrow(inpName);
      }
      
      else if(option.equals("3")){
         System.out.println("enter the exact book name you want to Return");
         inpName = reader.next();
         Library1.Return(inpName);
      }
      
      else if(option.equals("4")){
         System.out.println("enter the exact book name you want to Return");
         inpName = reader.next();
         Library2.Return(inpName);
      }
      
      else if(option.equals("5")){
         System.out.println("enter the book name:");
         inpName = reader.next();
         Library1.addBook(inpName);
      }
      
      else if(option.equals("6")){
         System.out.println("enter the book name:");
         inpName = reader.next();
         Library2.addBook(inpName);
      }
      
      else if(option.equals("7"))
      break;
      
      else{
         System.out.println("error, only numbers");
         continue;
      }
      
      System.out.println("\n"+ Library1.AvailableBooks() + "\n"+ Library2.AvailableBooks() 
                        +"\n"+ Library1.getOwnedBooks()  + "\n" + Library2.getOwnedBooks());
      }
   } 
} 