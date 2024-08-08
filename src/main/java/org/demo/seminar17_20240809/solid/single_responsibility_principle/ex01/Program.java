package org.demo.seminar17_20240809.solid.single_responsibility_principle.ex01;

import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        // Пример использования можно добавить здесь
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

    public void sendToEmail(String email, String text, String subject) {
        // Реализация отправки на email
    }

    public void uploadToSftpServer(String sftp, int port, UUID token, User user) {
        // Реализация загрузки на SFTP сервер
    }

    public ImageSize getSize() {
        return new ImageSize(width, height);
    }

    public void loadFileFromUrl(String url) {
        // Реализация загрузки файла из URL
    }

    public void saveToFile(String path) {
        // Реализация сохранения в файл
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

class User {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
