package org.example.home5.task2.model.impl;

import org.example.home5.task2.model.BaseRepository;
import org.example.home5.task2.model.DataSource;
import org.example.home5.task2.model.domain.User;

import java.util.Collections;
import java.util.Set;

/*
    Dependency inversion
    Классы не тесно связаны, связь идет через интерфейсы. Мы можем подложить любую реализацию DataSource.
    Хоть наш текущий в Runtime-e, хоть в файле, хоть в реальную бд
 */
public class BaseRepositoryImpl implements BaseRepository<User> {

    private final DataSource dataSource;

    public BaseRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User get(String uid) {
        Set<User> users = getUsers();
        return users.stream()
                .filter(user -> user.getLogin().equals(uid))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User with login " + uid + " is not exist!"));
    }

    @Override
    public void save(User user) {
        try {
            User containedUser = get(user.getLogin());
            containedUser.setName(user.getName());
            containedUser.setPassword(user.getPassword());
        } catch (IllegalArgumentException e) {
            dataSource.put(User.class, user);
        }
    }

    private Set<User> getUsers() {
        Set<User> users = dataSource.extract(User.class);
        if (users == null) {
            return Collections.emptySet();
        }
        return users;
    }

}
