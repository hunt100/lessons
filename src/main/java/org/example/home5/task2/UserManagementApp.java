package org.example.home5.task2;

import org.example.home5.task2.structural.ApplicationContext;
import org.example.home5.task2.structural.ApplicationStarter;

public class UserManagementApp {

    public static void main(String[] args) {
        ApplicationStarter.run(ApplicationContext.getPresenterInstance());
    }

}
