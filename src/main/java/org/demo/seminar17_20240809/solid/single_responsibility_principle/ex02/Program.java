package org.demo.seminar17_20240809.solid.single_responsibility_principle.ex02;

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

    public ImageSize getSize() {
        return new ImageSize(width, height);
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

    public void sendToEmail(String email, String text, String subject) {
        // Реализация отправки на email
    }

    public void uploadToSftpServer(String sftp, int port, UUID token, User user) {
        // Реализация загрузки на SFTP сервер
    }

    public void loadFileFromUrl(String url) {
        // Реализация загрузки файла из URL
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

class EmailService {
    private String email;
    private String text;
    private String subject;
    private Attach[] attach;

    public EmailService(String email, String text, String subject, Attach... attach) {
        this.email = email;
        this.text = text;
        this.subject = subject;
        this.attach = attach;
    }

    public void sendTo(String email, String text, String subject) {
        // Реализация отправки на email
    }
}

class SftpService {
    private final String ftp;
    private final int port;
    private final User user;
    private final Attach[] attach;
    private final UUID key;

    public SftpService(String ftp, int port, User user, UUID token, Attach... attach) {
        this.ftp = ftp;
        this.port = port;
        this.user = user;
        this.attach = attach;
        this.key = token;
    }

    public void upload() {
        // Реализация загрузки на SFTP сервер
    }
}

class SomeService {
    private String url;

    public SomeService(String url) {
        this.url = url;
    }

    public Image getImage() {
        return Image.createImage(100, 500);
    }
}
