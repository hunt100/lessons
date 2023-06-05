package org.example.home4.task4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class DataContainer<T> {

    private final T[] elements;
    private int cursor;

    public DataContainer(T[] elements) {
        this.elements = elements;
        cursor = 0;
    }

    public void add(T element) {
        if (cursor >= elements.length) {
            throw new IllegalArgumentException("Data container is full, no elements more!");
        }
        elements[cursor++] = element;
    }

    public T get(int index) {
        return elements[index];
    }

    public void sort(Comparator<T> comparator) {
        Arrays.sort(elements, comparator);
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        Iterator<T> it = Arrays.stream(elements).iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            T element = it.next();
            sb.append(element == this ? "(this Collection)" : element);
            if (!it.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
        }
    }
}
