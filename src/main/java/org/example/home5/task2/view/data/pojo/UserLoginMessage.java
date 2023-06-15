package org.example.home5.task2.view.data.pojo;

import org.example.home5.task2.view.data.enums.FormType;

public class UserLoginMessage extends ConsoleMessage {
    @Override
    public FormType getFormType() {
        return FormType.USER_LOGIN;
    }

    @Override
    public String getCustomText() {
        return "Input your user data:\nFirst - user login\nSecond - user password\n";
    }
}
