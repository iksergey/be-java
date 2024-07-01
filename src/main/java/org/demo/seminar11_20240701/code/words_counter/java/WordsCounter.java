package org.demo.seminar11_20240701.code.words_counter.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordsCounter {
    public static void main(String[] args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("../words.txt")));

        Map<String, Long> wordFrequency = Arrays.stream(
                content.toLowerCase().split("[\\s,\\?!\\.\\-–—]+"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        String result = wordFrequency
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue()
                        .compareTo(entry1.getValue()))
                // .limit(5)
                .map(entry -> entry.getKey() + ";" + entry.getValue() + ";")
                .collect(Collectors.joining("\n"));

        Files.write(Paths.get("../result_java.csv"), result.getBytes());

        System.out.println("Результат записан в файл result.csv");
    }
}
