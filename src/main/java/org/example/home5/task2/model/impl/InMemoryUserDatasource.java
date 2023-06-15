package org.example.home5.task2.model.impl;

import org.example.home5.task2.model.DataSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class InMemoryUserDatasource implements DataSource {

    private final Map<Class<?>, Set<Object>> objects = new HashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public <T> Set<T> extract(Class<T> clazz) {
        return (Set<T>) objects.get(clazz);
    }

    @Override
    public <T> void put(Class<T> clazz, T instance) {
        objects.computeIfAbsent(clazz, clazzInstances -> new HashSet<>()).add(instance);
    }

}
