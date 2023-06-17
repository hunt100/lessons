package org.example.home5.task2.view;

import org.example.home5.task2.view.data.enums.FormType;
import org.example.home5.task2.view.data.pojo.ConsoleMessage;

public interface UserView {

    void showForm(FormType type);

    void showError(FormType type);

    int getOperationInput();

    ConsoleMessage getForm(FormType formType);

}
