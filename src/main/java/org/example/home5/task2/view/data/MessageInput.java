package org.example.home5.task2.view.data;

import org.example.home5.task2.model.domain.User;
/*
    Liskov substitution Principle
    Базовый класс или наследники обладают некоторым функционалом,
    которым не обладает второй. И при замене друг друга код не должен нарушаться.
    3 класса наследника ConsoleMessage имеют логику с вводом данных из консоли, таким образом базовый класс
    имеет общую логику, а особую специальную логику я вынес в отдельный интерфейс для ввода и реализовал только
    в выбранных 3 классах
 */
public interface MessageInput {

    User getUserFields();

}
