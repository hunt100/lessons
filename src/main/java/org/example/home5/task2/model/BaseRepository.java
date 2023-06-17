package org.example.home5.task2.model;

/*
    Single responsibility
    Единая ответственность: репозиторий работает с datasource-ом и является прослойкой
    и лишь сообщает datasource-y, хочет программа получить T, или сохранить объект в datasource T
 */
public interface BaseRepository<T> {

    T get(String uid);

    void save(T t);

}
