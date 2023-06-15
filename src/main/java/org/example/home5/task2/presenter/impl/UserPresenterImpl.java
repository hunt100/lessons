package org.example.home5.task2.presenter.impl;

import org.example.home5.task2.model.domain.User;
import org.example.home5.task2.presenter.UserHandlerFactory;
import org.example.home5.task2.presenter.UserPresenter;
import org.example.home5.task2.view.UserView;
import org.example.home5.task2.view.data.enums.FormType;

public class UserPresenterImpl implements UserPresenter {

    private final UserView view;
    private final UserHandlerFactory userHandlerFactory;

    public UserPresenterImpl(UserView view,
                             UserHandlerFactory userHandlerFactory) {
        this.view = view;
        this.userHandlerFactory = userHandlerFactory;
    }

    @Override
    public void perform() {
        for (; ; ) {
            try {
                view.showForm(FormType.WELCOME);
                int input = view.getOperationInput();
                FormType formType = FormType.getFormType(input);
                view.showForm(formType);
                User userDTO = view.getUserFields(formType);
                boolean result = userHandlerFactory.getHandler(formType).handle(userDTO);
                if (result) {
                    view.showForm(FormType.getSuccessForm(formType));
                } else {
                    throw new RuntimeException("Failed to handle an operation");
                }
            } catch (Exception e) {
                e.printStackTrace();
                view.showError(FormType.WELCOME);
            }
        }
    }
}
