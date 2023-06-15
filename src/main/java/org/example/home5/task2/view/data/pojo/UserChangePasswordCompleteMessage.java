package org.example.home5.task2.view.data.pojo;

import org.example.home5.task2.view.data.enums.FormType;

public class UserChangePasswordCompleteMessage extends ConsoleMessage {
    @Override
    public FormType getFormType() {
        return FormType.CHANGE_PASSWORD_COMPLETE;
    }

    @Override
    public String getCustomText() {
        return "Password successfully changed!";
    }

}
