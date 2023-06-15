package org.example.home5.task2.model;

public interface BaseRepository<T> {

    T get(String login);

    void save(T t);

}
