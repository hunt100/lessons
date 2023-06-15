package org.example.home5.task2.presenter;

import org.example.home5.task2.presenter.handlers.UserOperationHandler;
import org.example.home5.task2.presenter.handlers.impl.UserChangePasswordHandler;
import org.example.home5.task2.presenter.handlers.impl.UserLoginHandler;
import org.example.home5.task2.presenter.handlers.impl.UserRegistrationHandler;
import org.example.home5.task2.view.data.enums.FormType;

import java.util.HashMap;
import java.util.Map;

public class UserHandlerFactory {

    private final Map<FormType, UserOperationHandler> userHandlers;

    public UserHandlerFactory() {
        this.userHandlers = new HashMap<>();
        this.userHandlers.put(FormType.USER_REGISTRATION, new UserRegistrationHandler());
        this.userHandlers.put(FormType.USER_LOGIN, new UserLoginHandler());
        this.userHandlers.put(FormType.CHANGE_PASSWORD, new UserChangePasswordHandler());
    }

    public UserOperationHandler getHandler(FormType formType) {
        return userHandlers.get(formType);
    }

}
