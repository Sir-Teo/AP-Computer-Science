import java.util.*;
class Studentmain
{
public static void main(String [] args)
{
Student Bill = new Student();
Student Kelly = new Student();
Student Gary = new Student();
Bill.setName("Bill");
Kelly.setName("Kelly");
Gary.setName("Gary");
Bill.setScore(93,95,90,0);// three Math scores, in column 0
Bill.setScore(40,60,50,1);// English scores, in column 1
Bill.setScore(85,80,90,2);//CS scores, in column 2
Bill.setScore(70,80,75,3);//Chemistry scores, in column 3
Bill.setScore(60,65,70,4);//Economic scores, in column 4
Kelly.setScore(95,95,95,0);// three Math scores, in column 0
Kelly.setScore(80,85,90,1);// English scores, in column 1
Kelly.setScore(85,80,90,2);//CS scores, in column 2
Kelly.setScore(70,80,75,3);//Chemistry scores, in column 3
Kelly.setScore(79,81,85,4);//Economic scores, in column 4
Gary.setScore(93,95,90,0);// three Math scores, in column 0
Gary.setScore(40,60,50,1);// English scores, in column 1
Gary.setScore(85,80,90,2);//CS scores, in column 2
Gary.setScore(70,80,75,3);//Chemistry scores, in column 3
Gary.setScore(60,65,70,4);//Economic scores, in column 4
double[][] AverageScore = new double[3][5];
String[][] Grade = new String[3][5]; 
for(int i=0; i<=4;i++)
{
AverageScore[0][i] = Bill.getAverage(i);//store bill's average at column0
AverageScore[1][i] = Kelly.getAverage(i);//store kelly's average at column 1
AverageScore[2][i] = Gary.getAverage(i);//store gary's average at column 2
}
for(int i=0;i<=4;i++)
{
Grade[0][i] = Bill.getGrade(Bill.getAverage(i));//column 0 for bill
Grade[1][i] = Kelly.getGrade(Kelly.getAverage(i));//column 1 for kelly
Grade[2][i] = Gary.getGrade(Gary.getAverage(i));//column 28 
}
for( int j=0;j<=2;j++)
{
for(int i=0;i<=4;i++)
AverageScore[j][i] = Math.round(AverageScore[j][i]);
}
System.out.println("Student name: Bill");
System.out.println("Subject:    Test1    Test2    Test3    Average    Grade");
System.out.println("Math        "+Bill.getScore(0,0)+"     "+Bill.getScore(0,1)+"     "
                                 +Bill.getScore(0,2)+"     "+AverageScore[0][0]+"       "
                                 +Grade[0][0]+"\n"+
                   "English     "+Bill.getScore(1,0)+"     "+Bill.getScore(1,1)+"     "
                                 +Bill.getScore(1,2)+"     "+AverageScore[0][1]+"       "
                                 +Grade[0][1]+"\n"+
                   "CS          "+Bill.getScore(2,0)+"     "+Bill.getScore(2,1)+"     "
                                 +Bill.getScore(2,2)+"     "+AverageScore[0][2]+"       "
                                 +Grade[0][2]+"\n"+
                   "Chemistry   "+Bill.getScore(3,0)+"     "+Bill.getScore(3,1)+"     "
                                 +Bill.getScore(3,2)+"     "+AverageScore[0][3]+"       "
                                 +Grade[0][3]+"\n"+
                   "Economics   "+Bill.getScore(4,0)+"     "+Bill.getScore(4,1)+"     "
                                 +Bill.getScore(4,2)+"     "+AverageScore[0][4]+"       "
                                 +Grade[0][4]+"\n");
System.out.println("\nStudent name: Kelly");
System.out.println("Subject:    Test1    Test2    Test3    Average    Grade");
System.out.println("Math        "+Kelly.getScore(0,0)+"     "+Kelly.getScore(0,1)+"     "
                                 +Kelly.getScore(0,2)+"     "+AverageScore[1][0]+"       "
                                 +Grade[1][0]+"\n"+
                   "English     "+Kelly.getScore(1,0)+"     "+Kelly.getScore(1,1)+"     "
                                 +Kelly.getScore(1,2)+"     "+AverageScore[1][1]+"       "
                                 +Grade[1][1]+"\n"+
                   "CS          "+Kelly.getScore(2,0)+"     "+Kelly.getScore(2,1)+"     "
                                 +Kelly.getScore(2,2)+"     "+AverageScore[1][2]+"       "
                                 +Grade[1][2]+"\n"+
                   "Chemistry   "+Kelly.getScore(3,0)+"     "+Kelly.getScore(3,1)+"     "
                                 +Kelly.getScore(3,2)+"     "+AverageScore[1][3]+"       "
                                 +Grade[1][3]+"\n"+
                   "Economics   "+Kelly.getScore(4,0)+"     "+Kelly.getScore(4,1)+"     "
                                 +Kelly.getScore(4,2)+"     "+AverageScore[1][4]+"       "
                                 +Grade[1][4]+"\n");
System.out.println("\nStudent name: Gary");
System.out.println("Subject:    Test1    Test2    Test3    Average    Grade");
System.out.println("Math        "+Gary.getScore(0,0)+"     "+Gary.getScore(0,1)+"     "
                                 +Gary.getScore(0,2)+"     "+AverageScore[2][0]+"       "
                                 +Grade[2][0]+"\n"+
                   "English     "+Gary.getScore(1,0)+"     "+Gary.getScore(1,1)+"     "
                                 +Gary.getScore(1,2)+"     "+AverageScore[2][1]+"       "
                                 +Grade[2][1]+"\n"+
                   "CS          "+Gary.getScore(2,0)+"     "+Gary.getScore(2,1)+"     "
                                 +Gary.getScore(2,2)+"     "+AverageScore[2][2]+"       "
                                 +Grade[2][2]+"\n"+
                   "Chemistry   "+Gary.getScore(3,0)+"     "+Gary.getScore(3,1)+"     "
                                 +Gary.getScore(3,2)+"     "+AverageScore[2][3]+"       "
                                 +Grade[2][3]+"\n"+
                   "Economics   "+Gary.getScore(4,0)+"     "+Gary.getScore(4,1)+"     "
                                 +Gary.getScore(4,2)+"     "+AverageScore[2][4]+"       "
                                 +Grade[2][4]+"\n");
}
}
