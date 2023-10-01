package uk.ac.ucl.model;

import org.apache.taglibs.standard.tag.el.sql.SetDataSourceTag;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.util.Base64;
import javax.imageio.ImageIO;

public class ImageProcessing {

    /*public void readingImage(String pathOfImage) {
        try {
            // Read the input image file
            //"/home/uras/tennis.png"
            File input = new File(pathOfImage);
            BufferedImage image = ImageIO.read(input);

            // Convert the image to grayscale
            BufferedImage gray = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            for (int i = 0; i < image.getWidth(); i++) {
                for (int j = 0; j < image.getHeight(); j++) {
                    Color c = new Color(image.getRGB(i, j));
                    int grayValue = (int) (0.2126 * c.getRed() + 0.7152 * c.getGreen() + 0.0722 * c.getBlue());
                    Color grayColor = new Color(grayValue, grayValue, grayValue);
                    gray.setRGB(i, j, grayColor.getRGB());
                }
            }

            // Save the result as a new image file
            String fileName = pathOfImage.split("/")[pathOfImage.split("/").length-1].split("\\.")[0];
            String imageType = pathOfImage.split("\\.")[pathOfImage.split("\\.").length-1];
            String outputFileName = fileName + "." + imageType;
            File output = new File(outputFileName);
            ImageIO.write(gray, imageType, output);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        ImageProcessing img = new ImageProcessing();
        img.readingImage("/home/uras/tennis.png");
    }*/

    public String getImageAsBase64(String imagePath) {
        String imageType = imagePath.split("\\.")[imagePath.split("\\.").length-1];
        if(imageType.equals("jpg") || imageType.equals("png")) {
            String base64Image = "";
            try {
                BufferedImage image = ImageIO.read(new File(imagePath));
                int maxWidth = 200;
                int maxHeight = 200;
                int width = image.getWidth();
                int height = image.getHeight();
                if (width > maxWidth || height > maxHeight) {
                    double scale = Math.min((double) maxWidth / width, (double) maxHeight / height);
                    width = (int) (width * scale);
                    height = (int) (height * scale);
                }
                BufferedImage scaledImage = new BufferedImage(width, height, image.getType());
                Graphics2D graphics = scaledImage.createGraphics();
                graphics.drawImage(image, 0, 0, width, height, null);
                graphics.dispose();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(scaledImage, imageType, baos);
                byte[] imageBytes = baos.toByteArray();
                base64Image = Base64.getEncoder().encodeToString(imageBytes);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            return base64Image;
        }
        return null;
    }

}
