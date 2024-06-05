package org.demo.seminar05_20240605.code.ex3;

public interface CustomList extends GenericList<Integer> {
    void append(Integer element);

    void appendRange(Integer... elements);

    void remove(Integer element);

    void removeAt(int position);

    Integer get(int index);

    int size();

    boolean contains(Integer element);
}
