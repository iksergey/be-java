package org.demo.seminar17_20240809.solid.open_closed_principle.ex03;

public class Program {
    public static void main(String[] args) {
        Image image = Image.createImage(28, 9);
        ImageExtensions.saveToBMP(image, "image.bmp");
        ImageExtensions.saveToJPG(image, "image.jpg");
        ImageExtensions.saveToPNG(image, "image.png");
    }
}

abstract class Attach {
}

class Image extends Attach {
    private int width;
    private int height;

    private Image(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Image createImage(int width, int height) {
        return new Image(width, height);
    }

    public ImageSize getSize() {
        return new ImageSize(width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

class ImageExtensions {
    public static void saveToBMP(Image image, String path) {
        // Реализация сохранения в BMP
    }

    public static void saveToJPG(Image image, String path) {
        // Реализация сохранения в JPG
    }

    public static void saveToPNG(Image image, String path) {
        // Реализация сохранения в PNG
    }
}

class ImageSize {
    private int x;
    private int y;

    public ImageSize(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
