package org.demo.summary05_20240621.code.seed;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Data {
    public static void seed(String path) {
        try {
            File file = new File(path);
            if (file.exists())
                return;

            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getName());
                FileWriter writer = new FileWriter(file);
                writer.write("\nВася\nПупкин\n\nМаша\nМолина\n\nJohn\nDue\n");
                writer.close();
                System.out.println("Данные записаны в файл.");
            } else {
                System.out.println("Не удалось создать файл.");
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка.");
            e.printStackTrace();
        }
    }
}
