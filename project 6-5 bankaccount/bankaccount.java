class bankaccount
{
 String name;
private double money;
public bankaccount()
{
name = "";
money = 0;
}
public void SetName(String nm)
{
name = nm;
}
public String GetName()
{
return name;
}
public void SetBalance(double balance)
{
money = balance;
}
public double GetBalance (double balance)
{
return balance;
}
public void Deposit(double deposit)
{
money = money + deposit;
}
public void Withdraw(double withdrawal)
{
money = money - withdrawal;
}
public String toString()
{
String str;
str = "Name:   "+name + "\n" +
"balance:   " + money;
return str;
}
}