package org.example.home5.task2.view.data.pojo;

import org.example.home5.task2.view.data.enums.FormType;

public class WelcomeMessage extends ConsoleMessage {
    @Override
    public FormType getFormType() {
        return FormType.WELCOME;
    }

    @Override
    public String getCustomText() {
        return "\tThe program can do following: \n\t1 - register user,\n\t2 - log in into existing account,\n\t3 - change password for user.";
    }

}
