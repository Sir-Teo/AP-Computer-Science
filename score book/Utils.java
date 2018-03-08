package sample;

import java.util.Random;

public final class Utils {

    public static String randomGenerator(int length, int type) {  // 1 mixed, 2 alphabets, 3 numbers
        String chars = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String numbers = "1234567890";
        String characters = "";
        switch (type) {
            case 1:
                characters = chars + numbers;
                break;
            case 2:
                characters = chars;
                break;
            case 3:
                characters = numbers;
                break;
            default:
                characters = chars + numbers;
        }
        Random rng = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public static boolean isBetween(Double x, int lower, int upper) {
        return lower <= x && x < upper;
    }
}
