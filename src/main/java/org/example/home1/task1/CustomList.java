package org.example.home1.task1;

import org.apache.commons.collections4.list.AbstractListDecorator;
import org.example.home1.task1.data.Animal;

import java.util.ArrayList;
import java.util.Comparator;

public class CustomList<E extends Animal> extends AbstractListDecorator<E> {

    public CustomList() {
        super(new ArrayList<>());
    }

    @Override
    public boolean add(E object) {
        boolean result = super.add(object);
        this.sort(Comparator.comparing(Ordered::getOrder));
        return result;
    }

}
