package org.demo.seminar05_20240605.code.ex3;

public interface CustomList {
    void append(int element);

    void appendRange(int... elements);

    void remove(int element);

    void removeAt(int position);

    int get(int index);

    int size();

    boolean contains(int element);
}