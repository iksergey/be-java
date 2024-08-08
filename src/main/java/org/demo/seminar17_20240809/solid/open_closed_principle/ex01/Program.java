package org.demo.seminar17_20240809.solid.open_closed_principle.ex01;

public class Program {
    public static void main(String[] args) {
        Image image = Image.createImage(28, 9);
        image.saveToBMP("image.bmp");
        image.saveToJPG("image.jpg");
        image.saveToPNG("image.png");
    }
}

abstract class Attach {
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

    public void saveToBMP(String path) {
        // Реализация сохранения в BMP
    }

    public void saveToJPG(String path) {
        // Реализация сохранения в JPG
    }

    public void saveToPNG(String path) {
        // Реализация сохранения в PNG
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
