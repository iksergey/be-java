package org.demo.seminar11_20240703.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {
    public static void main(String[] args) {

        Map<String, List<String>> item = new HashMap<>();
        // item.entrySet().stream().map(null)
        item.put("ключ1", List.of("элемент11", "элемент12", "элемент13"));
        item.put("ключ2", List.of("элемент21", "элемент22", "элемент23"));
        item.put("ключ3", List.of("элемент31", "элемент32", "элемент33"));
        System.out.println(getJson(item));
    }

    static String getJson(Map<String, List<String>> el) {
        String res = "{\n";
        for (Map.Entry<String, List<String>> item : el.entrySet()) {
            String pair = "    \"" + item.getKey() + "\": [\n";

            for (int i = 0; i < item.getValue().size(); i++) {
                pair += "        \"" + item.getValue().get(i) + "\",\n";
            }
            pair = pair.substring(0, pair.length() - 2);
            res += pair + "\n    ],\n";
        }
        return res.substring(0, res.length() - 2) + "\n}";
    }
}
