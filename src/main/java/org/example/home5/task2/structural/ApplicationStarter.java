package org.example.home5.task2.structural;

public class ApplicationStarter {

    public static <T extends Performable> void run(T performer) {
        performer.perform();
    }

}
