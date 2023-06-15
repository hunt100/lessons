package org.example.home5.task2.presenter.handlers.impl;

import org.example.home5.task2.model.BaseRepository;
import org.example.home5.task2.model.domain.User;
import org.example.home5.task2.presenter.handlers.UserOperationHandler;
import org.example.home5.task2.structural.ApplicationContext;

public class UserLoginHandler implements UserOperationHandler {

    private final BaseRepository<User> userRepository;

    public UserLoginHandler() {
        this.userRepository = ApplicationContext.getUserRepository();
    }

    @Override
    public boolean handle(User user) {
        try {
            User dbUser = userRepository.get(user.getLogin());
            return dbUser.getPassword().equals(user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
