package org.demo.seminar05_20240605.code.ex3;

@SuppressWarnings("unchecked")
// public interface GenericList<T> extends Iterable<T>, Iterator<T> {
public interface GenericList<T> {
    void append(T element);

    void appendRange(T... elements);

    void remove(T element);

    void removeAt(int position);

    T get(int index);

    int size();

    boolean contains(T element);
}