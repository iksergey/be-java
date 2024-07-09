package org.demo.summary06_20240628.code;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class StringListProcessor {

    public static void main(String[] args) {
        List<String> namesList = List.of("Анна", "Иван", "Екатерина", "Александр", "Ольга", "Алексей");
        String[] namesArray = namesList.toArray(new String[namesList.size()]);

//        List<Integer> nameLengths = processStrings(namesList, str -> str.length());
//        System.out.println("Длины имен (список): " + nameLengths);

        List<String> namesStartingWithA = filterStrings(namesList, str -> str.startsWith("А"));
        System.out.println("Имена, начинающиеся на 'А': " + namesStartingWithA);

        int[] arrayLengths = processStringArray(namesArray, arr -> {
            int[] lengths = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                lengths[i] = arr[i].length();
            }
            return lengths;
        });
        System.out.println("Длины имен (массив): " + Arrays.toString(arrayLengths));

        String[] longNames = filterStrings(namesList, str -> str.length() > 5).toArray(new String[0]);
        int[] longNameLengths = processStringArray(longNames, arr -> {
            int[] lengths = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                lengths[i] = arr[i].length();
            }
            return lengths;
        });
        System.out.println("Длины имен длиннее 5 букв (массив): " + Arrays.toString(longNameLengths));
    }

    public static List<Integer> processStrings(List<String> strings, StringProcessor processor) {
        List<Integer> results = new ArrayList<>();
        for (String str : strings) {
//            results.add(processor.process(str));
        }
        return results;
    }

    public static List<String> filterStrings(List<String> strings, StringPredicate predicate) {
        List<String> filteredList = new ArrayList<>();
        for (String str : strings) {
            if (predicate.test(str)) {
                filteredList.add(str);
            }
        }
        return filteredList;
    }

    public static int[] processStringArray(String[] strings, StringArrayProcessor processor) {
        return processor.processArray(strings);
    }

}

@FunctionalInterface
interface StringPredicate {
    boolean test(String input);
}

@FunctionalInterface
interface StringArrayProcessor {
    int[] processArray(String[] input);
}
