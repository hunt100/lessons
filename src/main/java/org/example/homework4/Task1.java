package org.example.homework4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Task1 {
    /*
    1) Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.
     */
    public static void main(String[] args) {
        List<Integer> integerList = new LinkedList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        System.out.println(reverse(integerList));

        List<String> strList = new LinkedList<>();
        strList.add("qwe");
        strList.add("asd");
        strList.add("zxc");
        System.out.println(reverse(strList));
    }

    public static <T> List<T> reverse(List<T> initial) {
        List<T> reversedList = new LinkedList<>();
        LinkedList<T> castedList = (LinkedList<T>) initial;
        Iterator<T> descIterator = castedList.descendingIterator();
        while (descIterator.hasNext()) {
            reversedList.add(descIterator.next());
        }
        return reversedList;
    }
}
