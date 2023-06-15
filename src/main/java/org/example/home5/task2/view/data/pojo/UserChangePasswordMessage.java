package org.example.home5.task2.view.data.pojo;

import org.example.home5.task2.view.data.enums.FormType;

public class UserChangePasswordMessage extends ConsoleMessage {
    @Override
    public FormType getFormType() {
        return FormType.CHANGE_PASSWORD;
    }

    @Override
    public String getCustomText() {
        return "Input:\n1 - your login\n2 - your new password";
    }
}
