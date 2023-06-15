package org.example.home5.task2.view;

import org.example.home5.task2.model.domain.User;
import org.example.home5.task2.view.data.enums.FormType;

public interface UserView {

    void showForm(FormType type);

    void showError(FormType type);

    User getUserFields(FormType type);

    int getOperationInput();

    <T> void showResult(T result);

}
