package org.example.home5.task2.view.data.pojo;

import org.example.home5.task2.view.data.enums.FormType;

public class UserLoginSuccessMessage extends ConsoleMessage {
    @Override
    public FormType getFormType() {
        return FormType.LOGIN_SUCCESS;
    }

    @Override
    public String getCustomText() {
        return "User successfully authenticated!";
    }
}
