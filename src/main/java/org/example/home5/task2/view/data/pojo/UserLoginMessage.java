package org.example.home5.task2.view.data.pojo;

import org.example.home5.task2.model.domain.User;
import org.example.home5.task2.view.data.MessageInput;
import org.example.home5.task2.view.data.enums.FormType;

public class UserLoginMessage extends ConsoleMessage implements MessageInput {
    @Override
    public FormType getFormType() {
        return FormType.USER_LOGIN;
    }

    @Override
    public String getCustomText() {
        return "Input your user data:\nFirst - user login\nSecond - user password\n";
    }

    @Override
    public User getUserFields() {
        var newUser = new User();
        System.out.println("\tWrite down user login:");
        newUser.setLogin(getScanner().nextLine());
        System.out.println("\tWrite down user password:");
        newUser.setPassword(getScanner().nextLine());
        return newUser;
    }
}
