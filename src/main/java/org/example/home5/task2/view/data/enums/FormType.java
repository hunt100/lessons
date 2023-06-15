package org.example.home5.task2.view.data.enums;

import java.util.List;

public enum FormType {

    WELCOME,
    USER_REGISTRATION,
    USER_REGISTRATION_COMPLETE,
    USER_LOGIN,
    LOGIN_SUCCESS,
    CHANGE_PASSWORD,
    CHANGE_PASSWORD_COMPLETE;

    private static final List<FormType> INPUT_FORMS = List.of(USER_REGISTRATION, USER_LOGIN, CHANGE_PASSWORD);

    public static FormType getFormType(int input) {
        return INPUT_FORMS.get(--input);
    }

    public static FormType getSuccessForm(FormType formType) {
        return values()[formType.ordinal() + 1];
    }
}
