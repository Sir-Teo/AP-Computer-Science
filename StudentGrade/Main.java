import java.util.*;
public class Main{
    public static void main(String [] arguments){

        int [][] G_scores = generateScores();

        String subjects [] = {"Math", "CS", "Chemistry", "Science", "physics"};
        int scores[][] = {{98,98,96,0},
                          {76,87,98,0},
                          {99,95,87,0},
                          {23,43,66,0},
                          {99,34,77,0}};
                          //must use "0" in the 4th column
        
        StudentGrade ben = new StudentGrade("Ben", scores, subjects);
        ben.printGrades();

        StudentGrade teo = new StudentGrade("Teo", G_scores, subjects);
        teo.printGrades();
    }

    //maybe this could be a test method?
    public static int[][] generateScores(){
        int [][] scores = new int[5][4];

        for (int i = 0; i < 5; i++)
            for (int j = 0 ; j < 3; j++)
                scores[i][j] = (int)(Math.random()*100);

        return scores;
    }
}