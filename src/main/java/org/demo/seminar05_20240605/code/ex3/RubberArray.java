package org.demo.seminar05_20240605.code.ex3;

import java.util.Iterator;

public class RubberArray implements CustomList {
    private int[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 2;

    public RubberArray() {
        this.array = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void append(Integer element) {
        ensureCapacity();
        array[size++] = element;
    }

    public void appendRange(Integer... elements) {
        ensureCapacity(size + elements.length);
        System.arraycopy(elements, 0, array, size, elements.length);
        size += elements.length;
    }

    @Override
    public void remove(Integer element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                removeAt(i);
                break;
            }
        }
    }

    public void removeAt(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        System.arraycopy(array, position + 1, array, position, size - position - 1);
        size--;
    }

    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return array[index];
    }

    public int size() {
        return size;
    }

    public boolean contains(Integer element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = copyArray(array, newCapacity);
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = Math.max(minCapacity, array.length * 2);
            array = copyArray(array, newCapacity);
        }
    }

    private int[] copyArray(int[] original, int newCapacity) {
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < original.length; i++) {
            newArray[i] = original[i];
        }
        return newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
