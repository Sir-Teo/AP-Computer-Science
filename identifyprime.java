import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class identifyprime {

    public static void main(String[] args) throws IOException {
        int number = 0;
        StringBuilder result = new StringBuilder();

        // Read the file
        Scanner reader = new Scanner(new File("numberlist"));

        while (reader.hasNextInt()) {
            number = reader.nextInt();

            if (number <= 0) {
                result.append("Number must be larger than 0 ! The invalid input number " + number + "\r\n");
            } else if (judgement(number)) {
                result.append(number + " is a prime number" + "\r\n");
            } else {
                result.append(number + " is NOT a prime number" + "\r\n");
            }
        }

        // Write result to a file
        PrintWriter writer = new PrintWriter("numberlist");
        writer.write(result.toString());
        writer.close();
        System.out.print(result.toString());
    }

    protected static boolean judgement(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}