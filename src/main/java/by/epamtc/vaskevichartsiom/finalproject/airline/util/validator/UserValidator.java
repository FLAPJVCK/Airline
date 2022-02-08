package by.epamtc.vaskevichartsiom.finalproject.airline.util.validator;

public interface UserValidator {

    boolean isNameValid(String name);

    boolean isUsernameValid(String username);

    boolean isEmailValid(String email);

    boolean isPasswordValid(String password);
}
