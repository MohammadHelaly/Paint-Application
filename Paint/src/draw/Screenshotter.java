package draw;

import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.util.Random;

public class Screenshotter {

    private static Screenshotter instance = null;

    private Screenshotter() {

    }

    public static Screenshotter createScreenshotter() {
        if (instance == null) {
            instance = new Screenshotter();
        }

        return instance;

    }

public static String generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(90000) + 10000; // Generates a random 5-digit number
        return String.valueOf(randomNumber);
    }
    
    public void captureScreenshot() {
        try {
            Robot robot = new Robot();
            Dimension screenDims = Board.toolkit.getScreenSize();
            Rectangle rect = new Rectangle(0, 0, screenDims.width, screenDims.height);
            BufferedImage screenshot = robot.createScreenCapture(rect);
            String newFileName = "Screenshot" + "-" + generateRandomNumber() + ".jpg";
            ImageIO.write(screenshot, "JPG", new File(newFileName));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}