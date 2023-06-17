package org.example.home5.task2.structural;

/*
    Single responsibility
    Все классы, которые могут запускаться в коде (например Presenter-ы или даже что-то другое) реализуют этот интерфейс
    У всех кто реализует этот интерфейс всего одна задача: быть запущенным через ApplicationStarter
 */
public interface Performable {

    void perform();

}
