package org.example.home5.task2.view.data.pojo;

import org.example.home5.task2.model.domain.User;
import org.example.home5.task2.view.data.MessageInput;
import org.example.home5.task2.view.data.enums.FormType;

public class UserChangePasswordMessage extends ConsoleMessage implements MessageInput {
    @Override
    public FormType getFormType() {
        return FormType.CHANGE_PASSWORD;
    }

    @Override
    public String getCustomText() {
        return "Input:\n1 - your login\n2 - your new password";
    }

    @Override
    public User getUserFields() {
        var newUser = new User();
        System.out.println("\tWrite down user login:");
        newUser.setLogin(getScanner().nextLine());
        System.out.println("\tWrite down user new password:");
        newUser.setPassword(getScanner().nextLine());
        return newUser;
    }
}
