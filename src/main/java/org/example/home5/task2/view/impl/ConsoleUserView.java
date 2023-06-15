package org.example.home5.task2.view.impl;

import org.example.home5.task2.model.domain.User;
import org.example.home5.task2.view.UserView;
import org.example.home5.task2.view.data.enums.FormType;
import org.example.home5.task2.view.data.pojo.*;

import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleUserView implements UserView {

    private final Scanner scanner;
    private final Map<FormType, ConsoleMessage> messagesFactory;

    public ConsoleUserView() {
        this.scanner = new Scanner(System.in);
        this.messagesFactory = new EnumMap<>(FormType.class);
        messagesFactory.put(FormType.WELCOME, new WelcomeMessage());
        messagesFactory.put(FormType.USER_REGISTRATION, new UserRegistrationMessage());
        messagesFactory.put(FormType.USER_REGISTRATION_COMPLETE, new UserRegistrationCompleteMessage());
        messagesFactory.put(FormType.USER_LOGIN, new UserLoginMessage());
        messagesFactory.put(FormType.LOGIN_SUCCESS, new UserLoginSuccessMessage());
        messagesFactory.put(FormType.CHANGE_PASSWORD, new UserChangePasswordMessage());
        messagesFactory.put(FormType.CHANGE_PASSWORD_COMPLETE, new UserChangePasswordCompleteMessage());
    }

    @Override
    public void showForm(FormType type) {
        messagesFactory.get(type).printMessage();
    }

    @Override
    public void showError(FormType type) {
        messagesFactory.get(type).printErrorMessage();
    }

    @Override
    public User getUserFields(FormType type) {
        var newUser = new User();
        switch (type) {
            case USER_REGISTRATION: {
                System.out.println("\tWrite down user name:");
                newUser.setName(scanner.nextLine());
            }
            case USER_LOGIN, CHANGE_PASSWORD: {
                System.out.println("\tWrite down user login:");
                newUser.setLogin(scanner.nextLine());

                System.out.println("\tWrite down user "+ (type.equals(FormType.CHANGE_PASSWORD) ? "new " : "") + "password:");
                newUser.setPassword(scanner.nextLine());
                break;
            }
            default: throw new UnsupportedOperationException("Not supported operation");
        }
        return newUser;
    }

    @Override
    public <T> void showResult(T result) {
        System.out.println(result);
    }

    @Override
    public int getOperationInput() {
        try {
            int input = Integer.parseInt(scanner.nextLine());
            if (input < 1 || input > 3) {
                throw new UnsupportedOperationException();
            }
            return input;
        } catch (Exception e) {
            throw new IllegalArgumentException("Wrong input");
        }
    }
}
