import images.APImage;
import images.Pixel;

import java.util.Scanner;


public class Project55MCL {

    public static void main(String[] args) {
        // Read file
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the image name you want to import: "); // Resources/Project4_11/img.png
        String imageName = reader.nextLine();

        // Init!
        APImage image = new APImage(imageName);
        boolean flag = true;
        int[] adjust = {0, 0, 0};

        while (flag) {
            System.out.print("Enter the color value (RGB) you want to convert (use positive if you want to add or reduce(in range -10~10), use comma to separate value, nothing for no change): ");
            String i = reader.nextLine();
            if (!i.isEmpty())
                adjust = parseColorValue(i);
            if (adjust[0] == -11) {
                System.out.println("The should be in range -10~10 !");
            } else {
                flag = false; // Moving on
            }
        }

        // Clone and show
        APImage origin = image.clone();
        origin.draw();

        // make changes
        for (Pixel p : image) {
            int[] originValue = {p.getRed(), p.getGreen(), p.getBlue()};
            int[] newColor = new int[3];
            for (int i = 0; i <= 2; i++) {
                int raw = originValue[i] + (originValue[i] / 10) * adjust[i];
                if (raw < 0) {
                    raw = 0;
                } else if (raw > 255) {
                    raw = 255;
                }
                newColor[i] = raw;
            }
            p.setRed(newColor[0]);
            p.setGreen(newColor[1]);
            p.setBlue(newColor[2]);
        }

        System.out.print("Press return to continue:");
        reader.nextLine();
        image.draw();
    }

    public static int[] parseColorValue(String line) {
        String[] array = line.split(",");
        int[] RGB = new int[3];
        for (int i = 0; i < 2; i++) {
            if (RGB[i] <= 10 && RGB[i] >= -10) {
                RGB[i] = Integer.parseInt(array[i]);
            } else {
                RGB[0] = -11; // Set as flag
                break;
            }
        }
        return RGB;
    }

}
