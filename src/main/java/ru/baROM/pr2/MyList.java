package ru.baROM.pr2;

public interface MyList<T> {

    int size();

    boolean isEmpty();

    void add(T item);

    void add(int index, T item);

    boolean delete(int index);

    boolean delete(T item);

    int indexOf(T item);

    boolean contains(T item);
}
