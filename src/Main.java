import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ImageConverter [input file/directory path] [output directory path]");
            return;
        }

        File inputFileOrDir = new File(args[0]);
        File outputDir = new File(args[1]);

        if (!inputFileOrDir.exists()) {
            System.out.println("Input file/directory does not exist");
            return;
        }

        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        if (inputFileOrDir.isFile()) {
            convertToGrayscale(inputFileOrDir, new File(outputDir, inputFileOrDir.getName()));
        } else {
            File[] files = inputFileOrDir.listFiles();
            for (File file : files) {
                convertToGrayscale(file, new File(outputDir, file.getName()));
            }
        }
    }

    public static void convertToGrayscale(File inputFile, File outputFile) {
        try {
            // Load the original image
            BufferedImage originalImage = ImageIO.read(inputFile);

            // Create a new grayscale image of the same size
            BufferedImage grayscaleImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

            // Convert each pixel of the original image to grayscale
            for (int y = 0; y < originalImage.getHeight(); y++) {
                for (int x = 0; x < originalImage.getWidth(); x++) {
                    // Get the color of the original pixel
                    Color color = new Color(originalImage.getRGB(x, y));

                    // Calculate the grayscale value (average of the red, green, and blue values)
                    int grayValue = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

                    // Set the grayscale value of the new pixel
                    grayscaleImage.setRGB(x, y, new Color(grayValue, grayValue, grayValue).getRGB());
                }
            }

            // Save the grayscale image
            ImageIO.write(grayscaleImage, "jpg", outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void treeNormal(int height){

        for(int i=0;i<height;i++){
            System.out.print("*");
            for(int j=height;j>i;j--){
                System.out.println("-");
            }
        }

    }
}
