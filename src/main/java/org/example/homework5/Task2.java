package org.example.homework5;


import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/*
Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова

Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
 */
public class Task2 {

    public static void main(String[] args) {
        String[] persons = new String[]{
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        };

        Arrays.stream(persons)
                .collect(Collectors.groupingBy(s -> s.split(" ")[0], Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));

    }
}
