package org.example.home5.task2.model;

import java.util.Set;

public interface DataSource {

    <T> Set<T> extract(Class<T> clazz);

    <T> void put(Class<T> clazz, T instance);

}
