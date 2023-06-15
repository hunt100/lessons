package org.example.home5.task2.view.data.pojo;

import org.example.home5.task2.view.data.enums.FormType;

public class UserRegistrationMessage extends ConsoleMessage {
    @Override
    public FormType getFormType() {
        return FormType.USER_REGISTRATION;
    }

    @Override
    public String getCustomText() {
        return "Input your user data:\nFirst - user name\nSecond - user login (must be unique)\nThird - user password\n";
    }
}
