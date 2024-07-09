### Чтение из текстового файла

### 1. Использование BufferedReader

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {
    public static void main(String[] args) {
        String fileName = "example.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
```

### 2. Использование Files.readAllLines()

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class ReadFileExample2 {
    public static void main(String[] args) {
        String fileName = "example.txt";
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
```

### Запись в текстовый файл

### 1. Использование BufferedWriter

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileExample {
    public static void main(String[] args) {
        String fileName = "output.txt";
        String content = "Это пример записи в файл.\nВторая строка.";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Файл успешно записан.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}
```

### 2. Использование Files.write()

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteFileExample2 {
    public static void main(String[] args) {
        String fileName = "output.txt";
        List<String> lines = Arrays.asList("Первая строка", "Вторая строка", "Третья строка");
        
        try {
            Files.write(Paths.get(fileName), lines);
            System.out.println("Файл успешно записан.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}
```

### Files

Files - это утилитный класс в пакете java.nio.file, предоставляющий статические методы для операций с файлами и директориями.

- Основные возможности:
  - Чтение и запись файлов
  - Копирование и перемещение файлов
  - Создание и удаление файлов и директорий
  - Получение атрибутов файлов

Пример: `Files.readAllLines()`, `Files.write()`

### Paths

Paths - фабричный класс для создания объектов Path, представляющих пути к файлам или директориям.

- Основное назначение:
  - Создание объектов Path из строковых путей
  - Преобразование путей между различными форматами

Пример: `Paths.get("example.txt")`

### BufferedWriter

BufferedWriter - класс для эффективной записи текста в файл с использованием буфера.

- Ключевые особенности:
  - Буферизация для повышения производительности
  - Методы для записи строк и символов

Пример: `new BufferedWriter(new FileWriter("file.txt"))`

### BufferedReader

BufferedReader - класс для эффективного чтения текста из файла с использованием буфера.

- Ключевые особенности:
  - Буферизация для повышения производительности
  - Методы для чтения строк и символов

Пример: `new BufferedReader(new FileReader("file.txt"))`

### FileInputStream и FileOutputStream

- FileInputStream: для чтения байтов из файла
- FileOutputStream: для записи байтов в файл

Используются для работы с бинарными данными.

### FileReader и FileWriter

- FileReader: для чтения символов из файла
- FileWriter: для записи символов в файл

Удобны для работы с текстовыми файлами, но не поддерживают указание кодировки.

### RandomAccessFile

Класс для чтения и записи в произвольные позиции файла.

- Особенности:
  - Поддержка произвольного доступа к данным
  - Возможность чтения и записи в одном объекте

### Scanner

Класс для разбора текстовых данных из различных источников, включая файлы.

- Возможности:
  - Чтение и разбор данных различных типов
  - Использование регулярных выражений для разделения ввода

### try-with-resources`

В Java с версии 7 был введён механизм автоматического закрытия ресурсов с помощью конструкции `try-with-resources`. Это позволяет избежать необходимости явно закрывать ресурсы в блоке `finally`. Вот как можно переписать ваш пример с использованием `try-with-resources`:

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Example {
    public static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } 
    }

    public static void main(String[] args) {
        String path = "example.txt";
        try {
            String firstLine = readFirstLineFromFile(path);
            System.out.println("Первая строка файла: " + firstLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
