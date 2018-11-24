import java.util.*;

class StudentGrade{

    private int grades[][] = new int[5][4];
    private String name = "";
    private String[] letters = new String[5];
    private String[] subjects = new String[5];
    // row 1 -> Math
    // row 2 -> CS
    // row 3 -> blahblahblah

    public StudentGrade(String name){
        this.name = name;
    }

    public StudentGrade(String name, int[][] grades){
        this.name = name;
        this.grades = grades;
    } 

    public StudentGrade(String name, int[][] grades, String[] subjects){
        this.name = name;
        this.grades = grades;
        this.subjects = subjects;
    } 

    public void computeAverage(){
        for(int i = 0; i < 5;i++){
            double sum = 0;
            for (int j = 0; j < 3; j++){
                sum += this.grades[i][j];
            }
            this.grades[i][3] = (int)sum/3;
        }
    }

    public void computeLetters(){
        for (int i = 0; i < 5; i++){
            String letter = "";
            if (this.grades[i][3] < 60){
                letter = "F";
            }
            if (this.grades[i][3] >= 60){
                letter = "D";
            }
            if (this.grades[i][3] >= 70){
                letter = "C";
            }
            if (this.grades[i][3] >= 80){
                letter = "B";
            }
            if (this.grades[i][3] >= 90){
                letter = "A";
            }
            this.letters[i] = letter;
        }
    }
    
    public void printGrades(){
        // make these two funcitons into this procedure so that less would be written in Main.java
        computeAverage();
        computeLetters();

        Formatter formatter = new Formatter(System.out);
        System.out.println(this.name + ":");
        System.out.println("|---------------------------------------------------------------------|");
        System.out.println("|Subject:    |Test1     |Test2     |Final Test    |Average     |Grade |");
        System.out.println("|---------------------------------------------------------------------|");
        formatter.format("|%-12s| %-9d| %-9d| %-13d| %-11d| %-5s|\n", this.subjects[0], this.grades[0][0], this.grades[0][1], this.grades[0][2], this.grades[0][3], this.letters[0]);
        System.out.println("|---------------------------------------------------------------------|");
        formatter.format("|%-12s| %-9d| %-9d| %-13d| %-11d| %-5s|\n", this.subjects[1], this.grades[1][0], this.grades[1][1], this.grades[1][2], this.grades[1][3], this.letters[1]);
        System.out.println("|---------------------------------------------------------------------|");
        formatter.format("|%-12s| %-9d| %-9d| %-13d| %-11d| %-5s|\n", this.subjects[2], this.grades[2][0], this.grades[2][1], this.grades[2][2], this.grades[2][3], this.letters[2]);
        System.out.println("|---------------------------------------------------------------------|");
        formatter.format("|%-12s| %-9d| %-9d| %-13d| %-11d| %-5s|\n", this.subjects[3], this.grades[3][0], this.grades[3][1], this.grades[3][2], this.grades[3][3], this.letters[3]);
        System.out.println("|---------------------------------------------------------------------|");
        formatter.format("|%-12s| %-9d| %-9d| %-13d| %-11d| %-5s|\n", this.subjects[4], this.grades[4][0], this.grades[4][1], this.grades[4][2], this.grades[4][3], this.letters[4]);
        System.out.println("|---------------------------------------------------------------------|\n\n");
    }  
}