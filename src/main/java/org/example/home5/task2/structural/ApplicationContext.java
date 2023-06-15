package org.example.home5.task2.structural;

import org.example.home5.task2.model.BaseRepository;
import org.example.home5.task2.model.DataSource;
import org.example.home5.task2.model.domain.User;
import org.example.home5.task2.model.impl.BaseRepositoryImpl;
import org.example.home5.task2.model.impl.InMemoryUserDatasource;
import org.example.home5.task2.presenter.UserHandlerFactory;
import org.example.home5.task2.presenter.UserPresenter;
import org.example.home5.task2.presenter.impl.UserPresenterImpl;
import org.example.home5.task2.view.UserView;
import org.example.home5.task2.view.impl.ConsoleUserView;

public class ApplicationContext {

    private static final DataSource DATA_SOURCE = new InMemoryUserDatasource();
    private static final BaseRepository<User> USER_REPOSITORY = new BaseRepositoryImpl(DATA_SOURCE);
    private static final UserView USER_VIEW = new ConsoleUserView();
    private static final UserHandlerFactory USER_HANDLER_FACTORY = new UserHandlerFactory();
    private static UserPresenter userPresenter;
    private static final Object MUTEX = new Object();

    private ApplicationContext() {
    }

    public static UserPresenter getPresenterInstance() {
        if(userPresenter == null) {
            synchronized (MUTEX) {
                userPresenter = new UserPresenterImpl(USER_VIEW, USER_HANDLER_FACTORY);
            }
        }
        return userPresenter;
    }

    public static BaseRepository<User> getUserRepository() {
        return USER_REPOSITORY;
    }
}
