package org.demo.seminar13_20240710.code.ex06;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PixelPainter {
    public static void main(String[] args) {
        int width = 300;
        int height = 200;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        g2d.dispose();

        int[] pixels = ((java.awt.image.DataBufferInt) image.getRaster().getDataBuffer()).getData();

        int color = Color.RED.getRGB();
        for (int i = 0; i < Math.min(width, height); i++) {
            int index = i * width + i;
            if (index < pixels.length) {
                pixels[index] = color;
            }
        }

        setPixel(image, 50, 50, Color.BLUE);
        setPixel(image, 100, 100, Color.GREEN);
        setPixel(image, 150, 150, Color.YELLOW);

        try {
            File outputFile = new File("pixel_image.png");
            ImageIO.write(image, "png", outputFile);
            System.out.println("сохранено: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка сохранения: " + e.getMessage());
        }
    }

    private static void setPixel(BufferedImage image, int x, int y, Color color) {
        image.setRGB(x, y, color.getRGB());
    }
}
