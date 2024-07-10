package org.demo.seminar13_20240710.code.ex08;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageToGrayscale {
    public static void main(String[] args) {
        String inputImagePath = "image.png";
        String outputImagePath = "grayscale_image.jpg";

        try {
            System.out.println(Files.exists(Paths.get(inputImagePath)));
            File inputFile = new File(inputImagePath);
            BufferedImage colorImage = ImageIO.read(inputFile);

            int width = colorImage.getWidth();
            int height = colorImage.getHeight();
            BufferedImage grayscaleImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = colorImage.getRGB(x, y);

                    int r = (rgb >> 16) & 0xFF;
                    int g = (rgb >> 8) & 0xFF;
                    int b = rgb & 0xFF;

                    int gray = (int) (0.299 * r + 0.587 * g + 0.114 * b);

                    int grayRGB = (gray << 16) | (gray << 8) | gray;
                    grayscaleImage.setRGB(x, y, grayRGB);
                }
            }

            File outputFile = new File(outputImagePath);
            ImageIO.write(grayscaleImage, "jpg", outputFile);

            System.out.println("Изображение успешно преобразовано в черно-белое и сохранено.");

        } catch (IOException e) {
            System.out.println("Произошла ошибка при обработке изображения: " + e.getMessage());
        }
    }
}
