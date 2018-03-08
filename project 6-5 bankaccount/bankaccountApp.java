import java.util.*;                                     
class bankaccountApp                         //import essential packages           
{
   public static void main (String [] args)
   {
      Scanner reader = new Scanner(System.in);  //use scannar for imput
      bankaccount account1 = new bankaccount(); //create three instances of bank account
      bankaccount account2 = new bankaccount();
      bankaccount account3 = new bankaccount();
      String inpname = "";                      //initialize the important variables
      double withdraw = 0;                      // withdraw
      double deposit = 0;                       // deposit
      int a;                                    // count variable
      String name;                              // name
      double balance;                           // balance
      System.out.println("welcome to the bank, please first create three accounts");  //will appear when the program starts
      System.out.println("Now, enter the first owner's name");        //ask for the first account name
      name = reader.next();                                           //name equals the input from user
      account1.SetName(name);                                         //store the name in the variable
      System.out.println("enter the first owner's initial balance");  //ask for the first account's balance
      balance = reader.nextDouble();                                  //balance equals input from user
      account1.SetBalance(balance);                                   //store the balance in the variable
      System.out.println("enter the second owner's name");            //same for the first account
      name = reader.next();
      account2.SetName(name);
      System.out.println("enter the second owner's initial balance");
      balance = reader.nextDouble();
      account2.SetBalance(balance);
      System.out.println("enter the third owner's name");     //same for the first account
      name = reader.next();
      account3.SetName(name); 
      System.out.println("enter the third owner's initial balance");
      balance = reader.nextDouble();
      account3.SetBalance(balance);
      System.out.println(account1.toString());   //print out the status of account1
      System.out.println(account2.toString());   //print out the status of account2
      System.out.println(account3.toString());   //print out the status of account3
      String accname1 = account1.GetName();      //store the name in variables
      String accname2 = account2.GetName();     
      String accname3 = account3.GetName();
   
      while(true)
      {
         System.out.println("type in the account name you want to withdraw/deposit:");  //ask for account typed in
         System.out.println(" account 1: "+accname1+"\n account 2: " + accname2+"\n account 3: " +accname3); //print out the current account names
         inpname = reader.next();         //store the next input name
         if(inpname.equals(accname1))     //if the user enters the first account
         {
            System.out.println("options:\n [1]withdraw money\n [2]deposit money");//give the user some options
            a = reader.nextInt();                                                 //amount of money
            if(a==1) //if the user enters 1
            {
               System.out.println("enter the money you want to withdraw");//ask the user the enter the money
               withdraw = reader.nextDouble();                            //store the variables
               account1.Withdraw(withdraw);                               //user the withdraw method
            }
            else
            {
               System.out.println("enter the money you want to deposit"); //if the user enters 2
               deposit = reader.nextDouble();
               account1.Deposit(deposit);
            }
         }
         else if(inpname.equals(accname2))                             //if the user enters account 2, the rest is the same as previous case
         {
            System.out.println("options:\n [1]withdraw money\n [2]deposit money");
            a = reader.nextInt();
            if(a==1)
            {
               System.out.println("enter the money you want to withdraw");
               withdraw = reader.nextDouble();
               account2.Withdraw(withdraw);
            }
            else
            {
               System.out.println("enter the money you want to deposit");
               deposit = reader.nextDouble();
               account2.Deposit(deposit);
            }
         }  
         else if(inpname.equals(accname3))                           //if the user enters account 3, the rest is same
         {
            System.out.println("options:\n [1]withdraw money\n [2]deposit money");
            a = reader.nextInt();
            if(a==1)
            {
               System.out.println("enter the money you want to withdraw");
               withdraw = reader.nextDouble();
               account1.Withdraw(withdraw);
            }
            else
            {
               System.out.println("enter the money you want to deposit");
               deposit = reader.nextDouble();
               account3.Deposit(deposit);
            }
         }
         else 
         {
            System.out.println("wrong input, try again!!:)");//if the suer typed wrong account name
            continue;
         }
         System.out.println(account1.toString());   //when the previous process was ended, print out all the account status
         System.out.println(account2.toString());
         System.out.println(account3.toString());
         System.out.println("options:\n [1]continue withdraw/deposit\n [2]Exit program");//give more options
         a = reader.nextInt();
         if(a==1)         //continue the loop
            continue;
         else             //end the program
            System.out.println("good bye, have a nice day");
         break;
      }
   }
}
