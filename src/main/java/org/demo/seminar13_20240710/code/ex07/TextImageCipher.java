package org.demo.seminar13_20240710.code.ex07;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextImageCipher {
    private static int maxTextLength = 0;
    private static int bitsPerChar = 16;
    private static int imageSize;

    public static void main(String[] args) {
        String text = "hello world";
        maxTextLength = text.length();
        imageSize = (int) Math.ceil(Math.sqrt(maxTextLength * bitsPerChar));
        encodeTextToImage(text, "encoded_image.png");
        String decodedText = decodeImageToText("encoded_image.png");
        System.out.println("Исходный текст: " + text);
        System.out.println("Декодированный текст: " + decodedText);
    }

    public static void encodeTextToImage(String text, String outputFileName) {
        if (text.length() > maxTextLength) {
            throw new IllegalArgumentException("Текст не должен превышать " + maxTextLength + " символов");
        }

        StringBuilder binaryString = new StringBuilder();
        for (char c : text.toCharArray()) {
            String binary = String.format("%" + bitsPerChar + "s", Integer.toBinaryString(c)).replace(' ', '0');
            binaryString.append(binary);
        }

        BufferedImage image = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        int index = 0;
        for (int y = 0; y < imageSize; y++) {
            for (int x = 0; x < imageSize; x++) {
                if (index < binaryString.length()) {
                    Color color = binaryString.charAt(index) == '1' ? Color.BLACK : Color.WHITE;
                    g2d.setColor(color);
                    g2d.fillRect(x, y, 1, 1);
                    index++;
                } else {
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(x, y, 1, 1);
                }
            }
        }

        g2d.dispose();

        try {
            ImageIO.write(image, "png", new File(outputFileName));
            System.out.println("Изображение сохранено: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении изображения: " + e.getMessage());
        }
    }

    public static String decodeImageToText(String inputFileName) {
        StringBuilder binaryString = new StringBuilder();
        try {
            BufferedImage image = ImageIO.read(new File(inputFileName));

            for (int y = 0; y < imageSize; y++) {
                for (int x = 0; x < imageSize; x++) {
                    int rgb = image.getRGB(x, y);
                    binaryString.append((rgb & 0xFF) == 0 ? "1" : "0");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении изображения: " + e.getMessage());
            return "";
        }

        StringBuilder decodedText = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i += bitsPerChar) {
            String charBits = binaryString.substring(i, Math.min(i + bitsPerChar, binaryString.length()));
            if (charBits.length() == bitsPerChar) {
                int charCode = Integer.parseInt(charBits, 2);
                decodedText.append((char) charCode);
            }
        }

        return decodedText.toString().trim();
    }
}
