package org.demo.seminar11_20240703.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapToJson {
    public static void main(String[] args) {
        Map<String, List<String>> item = new HashMap<>();
        item.put("ключ1", List.of("элемент11", "элемент12", "элемент13"));
        item.put("ключ2", List.of("элемент21", "элемент22", "элемент23"));
        item.put("ключ3", List.of("элемент31", "элемент32", "элемент33"));

        List<Map<String, List<String>>> itemList = List.of(item);
        List<String> jsonStrings = convertToJsonStrings(itemList);
        jsonStrings.forEach(System.out::println);
    }

    static List<String> convertToJsonStrings(List<Map<String, List<String>>> list) {
        return list.stream()
                .map(MapToJson::mapToJson)
                .collect(Collectors.toList());
    }

    static String mapToJson(Map<String, List<String>> map) {
        return map.entrySet().stream()
                .map(entry -> "\"" + entry.getKey() + "\": " +
                        listToJsonArray(entry.getValue()))
                .collect(Collectors.joining(", ", "{", "}"));
    }

    static String listToJsonArray(List<String> list) {
        return list.stream()
                .map(item -> "\"" + item + "\"")
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
