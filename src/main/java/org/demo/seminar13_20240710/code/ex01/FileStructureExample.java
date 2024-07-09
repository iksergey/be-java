package org.demo.seminar13_20240710.code.ex01;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileStructureExample {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        createInputFile(inputFileName);

        convertAndSaveFile(inputFileName, outputFileName);
    }

    private static void createInputFile(String fileName) {
        List<String> lines = Arrays.asList(
                "Иван", "Иванов", "",
                "Петр", "Петров", "",
                "Мария", "Сидорова");

        try {
            Files.write(Paths.get(fileName), lines);
            System.out.println("Исходный файл создан: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла: " + e.getMessage());
        }
    }

    private static void convertAndSaveFile(String inputFileName, String outputFileName) {
        try {
            List<String> inputLines = Files.readAllLines(Paths.get(inputFileName));
            List<String> outputLines = new ArrayList<>();

            for (int i = 0; i < inputLines.size(); i += 3) {
                if (i + 1 < inputLines.size()) {
                    String name = inputLines.get(i);
                    String surname = inputLines.get(i + 1);
                    outputLines.add(name + ";" + surname + ";");
                }
            }

            Files.write(Paths.get(outputFileName), outputLines);
            System.out.println("Преобразованный файл сохранен: " + outputFileName);
        } catch (IOException e) {
            System.err.println("Ошибка при обработке файлов: " + e.getMessage());
        }
    }
}
