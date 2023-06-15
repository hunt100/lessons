package org.example.home5.task2.view.data.pojo;

import org.example.home5.task2.view.data.enums.FormType;

public class UserRegistrationCompleteMessage extends ConsoleMessage {
    @Override
    public FormType getFormType() {
        return FormType.USER_REGISTRATION_COMPLETE;
    }

    @Override
    public String getCustomText() {
        return "\t New user successfully added\n";
    }
}
