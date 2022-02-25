package by.epamtc.vaskevichartsiom.finalproject.airline.util.validator;

/**
 * The interface User validator.
 */
public interface UserValidator {

    /**
     * Validate name and surname.
     *
     * @param name the name.
     * @return the boolean
     */
    boolean isNameValid(String name);

    /**
     * Validate username.
     *
     * @param username the username.
     * @return the boolean
     */
    boolean isUsernameValid(String username);

    /**
     * Validate email.
     *
     * @param email the email.
     * @return the boolean
     */
    boolean isEmailValid(String email);

    /**
     * Validate password.
     *
     * @param password the password.
     * @return the boolean
     */
    boolean isPasswordValid(String password);
}
