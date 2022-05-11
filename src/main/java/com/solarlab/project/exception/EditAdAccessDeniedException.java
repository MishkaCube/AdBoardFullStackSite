package com.solarlab.project.exception;


import javax.validation.ValidationException;

public class EditAdAccessDeniedException extends ValidationException {

    private static final String errorMessage = "Текущий пользователь не может редактировать объявления";

    public EditAdAccessDeniedException() {
        super(errorMessage);
    }

}
