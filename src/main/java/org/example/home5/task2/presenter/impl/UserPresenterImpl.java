package org.example.home5.task2.presenter.impl;

import org.example.home5.task2.model.domain.User;
import org.example.home5.task2.presenter.UserHandlerProvider;
import org.example.home5.task2.presenter.UserPresenter;
import org.example.home5.task2.view.UserView;
import org.example.home5.task2.view.data.MessageInput;
import org.example.home5.task2.view.data.enums.FormType;

public class UserPresenterImpl implements UserPresenter {

    private final UserView view;
    private final UserHandlerProvider userHandlerFactory;

    /*
        Dependency inversion
        Классы не тесно связаны, связь идет через интерфейсы. И мы не завязываемся на определенные классовые реализации
        При желании мы можем легко заменить реализацию UserHandlerProvider, а Presenter даже не узнает об этом
     */
    public UserPresenterImpl(UserView view,
                             UserHandlerProvider userHandlerFactory) {
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
                User userDTO;
                if (FormType.containsFormType(formType)) {
                    userDTO = ((MessageInput)view.getForm(formType)).getUserFields();
                } else {
                    throw new UnsupportedOperationException("Not supported operation");
                }
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
