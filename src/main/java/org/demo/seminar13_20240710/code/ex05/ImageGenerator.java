package org.demo.seminar13_20240710.code.ex05;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageGenerator {
    public static void main(String[] args) {
        int width = 300;
        int height = 300;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = image.createGraphics();

        GradientPaint gp = new GradientPaint(
                0, 0, Color.RED, width, height, Color.BLUE);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.drawString("hello world", 50, height / 2);

        g2d.dispose();

        try {
            File outputFile = new File("generated_image.png");
            ImageIO.write(image, "png", outputFile);
            System.out.println("сохранено: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("ошибка сохранения: " + e.getMessage());
        }
    }
}
