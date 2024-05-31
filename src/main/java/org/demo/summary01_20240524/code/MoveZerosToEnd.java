package org.demo.summary01_20240524.code;

import java.util.Arrays;
import java.util.Random;

public class MoveZerosToEnd {
    int[] arr;
    Random random;
    int size;

    public MoveZerosToEnd(int count) {
        arr = new int[count];
        random = new Random();
        size = count;
    }

    public void moveZerosToEnd() {
        int[] result = new int[size];
        int index = 0;

        for (int num : arr) {
            if (num != 0) {
                result[index++] = num;
            }
        }
        arr = result;
    }

    public void fillRandomArray(int max) {
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(max);
        }
    }

    public String printArray() {
        return Arrays.toString(arr);
    }

    public void moveZerosToEnd(boolean flag) {
        int nonZeroIndex = 0;

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != 0) {
                arr[nonZeroIndex++] = arr[index];
            }
        }

        while (nonZeroIndex < arr.length) {
            arr[nonZeroIndex++] = 0;
        }
    }

}
