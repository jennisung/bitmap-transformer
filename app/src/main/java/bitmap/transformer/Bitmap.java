package bitmap.transformer;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class Bitmap {
    private BufferedImage baldyImage;

    public Bitmap(String filePath) throws IOException {
        File imageFile = new File(filePath);
        baldyImage = ImageIO.read(imageFile);
    }

    public void applyTransform(String transformName) {
        if ("invert".equals(transformName)) {
            invertTransform();
        } else if ("blackAndWhite".equals(transformName)) {
            blackAndWhiteTransform();
        } else if ("rotate".equals(transformName)) {
            rotateTransform();
        } else {
            System.err.println("Error: Unknown transform: " + transformName);
        }
    }

    public void writeToFile(String outputFilePath) throws IOException {
        File outputFile = new File(outputFilePath);
        ImageIO.write(baldyImage, "bmp", outputFile);
    }


//    reference: https://stackoverflow.com/questions/13571914/method-colorint-rgb-seems-to-be-unknown
    private void invertTransform() {
        int width = baldyImage.getWidth();
        int height = baldyImage.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = baldyImage.getRGB(x, y);
                Color color = new Color(rgb);

                int red = 255 - color.getRed();
                int green = 255 - color.getGreen();
                int blue = 255 - color.getBlue();

                baldyImage.setRGB(x, y, new Color(red, green, blue).getRGB());
            }
        }
    }

//    reference: https://stackoverflow.com/questions/13571914/method-colorint-rgb-seems-to-be-unknown
    private void blackAndWhiteTransform() {
        int width = baldyImage.getWidth();
        int height = baldyImage.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = baldyImage.getRGB(x, y);
                Color color = new Color(rgb);

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                int blackAndWhite = (red + green + blue) / 3;

                baldyImage.setRGB(x, y, new Color(blackAndWhite, blackAndWhite, blackAndWhite).getRGB());
            }
        }
    }

    // reference chatGbt
    private void rotateTransform() {
        int width = baldyImage.getWidth();
        int height = baldyImage.getHeight();
        BufferedImage rotatedImage = new BufferedImage(height, width, baldyImage.getType());

        for (int yAxis = 0; yAxis < height; yAxis++) {
            for (int xAxis = 0; xAxis < width; xAxis++) {
                int newXAxis = height - yAxis - 1;
                int newYAxis = xAxis;
                rotatedImage.setRGB(newXAxis, newYAxis, baldyImage.getRGB(xAxis, yAxis));
            }
        }

        baldyImage = rotatedImage;
    }

}




