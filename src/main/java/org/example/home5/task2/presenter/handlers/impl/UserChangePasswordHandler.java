package org.example.home5.task2.presenter.handlers.impl;

import org.example.home5.task2.model.BaseRepository;
import org.example.home5.task2.model.domain.User;
import org.example.home5.task2.presenter.handlers.UserOperationHandler;
import org.example.home5.task2.structural.ApplicationContext;

public class UserChangePasswordHandler implements UserOperationHandler {

    private final BaseRepository<User> userRepository;

    public UserChangePasswordHandler() {
        this.userRepository = ApplicationContext.getUserRepository();
    }

    @Override
    public boolean handle(User user) {
        try {
            User dbUser = userRepository.get(user.getLogin());
            dbUser.setPassword(user.getPassword());
            userRepository.save(dbUser);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
