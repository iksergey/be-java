package org.demo.summary06_20240628.code;

import java.util.Arrays;

public class StringProcessor {

    public static void main(String[] args) {
        String[] words = new String[] { "String", "Processor", "12345" };

        int[] nums = logic(words, data -> {
            int[] res = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                res[i] = data[i].length();
            }
            return res;
        });

        nums = logic(words, data -> {
            int[] res = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                int count = 0;
                for (int j = 0; j < data[i].length(); j++) {
                    if ("aeiouy".indexOf(data[i].toLowerCase().charAt(j)) != -1) {
                        count++;
                    }
                }
                res[i] = count;
            }
            return res;
        });

        System.out.println(Arrays.toString(nums));
    }

    static int[] logic(String[] items, ArrayStringProcessor op) {
        return op.process(items);
    }
}

// String[] -> int[]
@FunctionalInterface
interface ArrayStringProcessor {
    int[] process(String[] data);
}
