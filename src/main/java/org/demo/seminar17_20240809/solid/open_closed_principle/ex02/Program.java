package org.demo.seminar17_20240809.solid.open_closed_principle.ex02;

public class Program {
    public static void main(String[] args) {
        Image[] pictures = new Image[] {
                Image.createImage(28, 9, new SaveToBMP()),
                Image.createImage(19, 90, new SaveToJPG()),
                Image.createImage(15, 6, new SaveToPNG()),
        };

        for (Image pic : pictures) {
            pic.saveTo("filename_" + System.currentTimeMillis());
        }
    }
}

interface ISave {
    void save(String path, Image image);
}

class SaveToBMP implements ISave {
    @Override
    public void save(String path, Image image) {
        String tempPath = path + ".bmp";
        // Реализация сохранения в BMP
    }
}

class SaveToJPG implements ISave {
    @Override
    public void save(String path, Image image) {
        String tempPath = path + ".jpg";
        // Реализация сохранения в JPG
    }
}

class SaveToPNG implements ISave {
    @Override
    public void save(String path, Image image) {
        String tempPath = path + ".png";
        // Реализация сохранения в PNG
    }
}

abstract class Attach {
}

class Image extends Attach {
    private int width;
    private int height;
    private ISave saveOption;

    private Image(int width, int height, ISave saveOption) {
        this.width = width;
        this.height = height;
        this.saveOption = saveOption;
    }

    public static Image createImage(int width, int height, ISave saveOption) {
        return new Image(width, height, saveOption);
    }

    public ImageSize getSize() {
        return new ImageSize(width, height);
    }

    public void saveTo(String path) {
        saveOption.save(path, this);
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
