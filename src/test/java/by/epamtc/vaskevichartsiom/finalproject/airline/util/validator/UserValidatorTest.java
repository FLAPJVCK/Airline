package by.epamtc.vaskevichartsiom.finalproject.airline.util.validator;

import by.epamtc.vaskevichartsiom.finalproject.airline.util.validator.impl.UserValidatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserValidatorTest {
    private static final UserValidator userValidator = new UserValidatorImpl();

    @Test
    public void validateNameTest_True() {
        String name = "Stepan";
        boolean actual = userValidator.isNameValid(name);
        Assertions.assertTrue(actual);
    }

    @Test
    public void validateNameTest_False() {
        String name = "Stepan21";
        boolean actual = userValidator.isNameValid(name);
        Assertions.assertFalse(actual);
    }

    @Test
    public void validateUsernameTest_True() {
        String username = "step1234";
        boolean actual = userValidator.isUsernameValid(username);
        Assertions.assertTrue(actual);
    }

    @Test
    public void validateUsernameTest_False() {
        String username = "step1234$";
        boolean actual = userValidator.isUsernameValid(username);
        Assertions.assertFalse(actual);
    }

    @Test
    public void validateEmailTest_True() {
        String email = "step@mail.ru";
        boolean actual = userValidator.isEmailValid(email);
        Assertions.assertTrue(actual);
    }

    @Test
    public void validateEmailTest_False() {
        String email = "step@mail.";
        boolean actual = userValidator.isEmailValid(email);
        Assertions.assertFalse(actual);
    }
}
