package by.epamtc.vaskevichartsiom.finalproject.airline.util.validator.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.util.validator.UserValidator;

public final class UserValidatorImpl implements UserValidator {

    public static final String REGEXP_NAME = "(?=^.{3,20}$)^([A-Za-z]+)";
    public static final String REGEXP_USERNAME = "(?=^.{5,20}$)^([A-Za-z0-9]+)$";
    public static final String REGEXP_EMAIL = "(?=^.{3,32}$)^([A-Za-z0-9]+@[A-Za-z0-9]+.[A-Za-z]+)$";
    public static final String REGEXP_PASSWORD = "^.{6,30}$";

    @Override
    public boolean isNameValid(String name) {
        return (name != null && name.matches(REGEXP_NAME));
    }

    @Override
    public boolean isUsernameValid(String username) {
        return (username != null && username.matches(REGEXP_USERNAME));
    }

    @Override
    public boolean isEmailValid(String email) {
        return (email != null && email.matches(REGEXP_EMAIL));
    }

    @Override
    public boolean isPasswordValid(String password) {
        return (password != null && password.matches(REGEXP_PASSWORD));
    }
}
