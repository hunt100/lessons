package org.example.homework4;

import java.util.LinkedList;

public class Task2 {
    /*
    2) Реализуйте очередь с помощью LinkedList со следующими методами:
    enqueue() - помещает элемент в конец очереди,
    dequeue() - возвращает первый элемент из очереди и удаляет его,
    first() - возвращает первый элемент из очереди, не удаляя.

    Пример:
    [1, 2, 3, 4, 5, 6, 7]
    spisok.enqueue(8)
    [1, 2, 3, 4, 5, 6, 7,8]
    spisok.dequeue
    1
    [2, 3, 4, 5, 6, 7,8]
    spisok.first()
    2
    [2, 3, 4, 5, 6, 7,8]
     */
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        myLinkedList.enqueue(8);
        System.out.println(myLinkedList);

        myLinkedList.dequeue();
        System.out.println(myLinkedList);

        System.out.println(myLinkedList.first());
    }

    public static class MyLinkedList<E> extends LinkedList<E> {

        public void enqueue(E element) {
            this.addLast(element);
        }

        public void dequeue() {
            this.removeFirst();
        }

        public E first() {
            return this.getFirst();
        }

    }
}
