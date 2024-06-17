package org.demo.seminar08_20240617.theoryHashMap;

import java.util.*;

public class Program {

    public static void main(String[] args) {
        List<List<String>> result = groupAnagrams(
                new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
        for (List<String> list : result) {
            System.out.println(list);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
