package org.example.home5.task2.presenter.handlers.impl;

import org.example.home5.task2.model.BaseRepository;
import org.example.home5.task2.model.domain.User;
import org.example.home5.task2.presenter.handlers.UserOperationHandler;
import org.example.home5.task2.structural.ApplicationContext;

public class UserRegistrationHandler implements UserOperationHandler {

    private final BaseRepository<User> userRepository;

    public UserRegistrationHandler() {
        this.userRepository = ApplicationContext.getUserRepository();
    }

    @Override
    public boolean handle(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
