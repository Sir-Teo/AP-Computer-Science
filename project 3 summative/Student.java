public class Student {
private String name = ""; 
public double TestScore[][]=new double[5][5]; 
public Student(){
   name = "";
   
}
public void setName (String nm)
{ 
name = nm; 
}
public String getName ()
{ 
return name; 
}
public void setScore (double score1,double score2, double score3,int i)
{                                        
TestScore[i][0] = score1;
TestScore[i][1] = score2;
TestScore[i][2] = score3;
}
public double getScore (int i, int j)
{
return TestScore[i][j];
}
public double getAverage(int i)
{
double average = ((TestScore[i][0] + TestScore[i][1] + TestScore[i][2])/3);
return average;
}
public String getGrade(double average)
{
String Grade = "";
if(average>=90.0&&average<=100.0)
Grade = "A";
else if(average>=80.0&&average<90.0)
Grade = "B";
else if(average>=70.0&&average<80.0)
Grade = "C";
else if(average>=60.0&&average<70.0)
Grade = "D";
else if(average>=0&&average<60.0)
Grade = "F";
else
Grade = "invalid score, no grade!!";
return Grade;
}

}