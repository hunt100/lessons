package org.example.home5.task2.presenter;

import org.example.home5.task2.presenter.handlers.UserOperationHandler;
import org.example.home5.task2.view.data.enums.FormType;

public interface UserHandlerProvider {

    UserOperationHandler getHandler(FormType formType);
}
