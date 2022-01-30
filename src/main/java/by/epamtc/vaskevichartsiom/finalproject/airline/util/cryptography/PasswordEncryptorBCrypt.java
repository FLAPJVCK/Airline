package by.epamtc.vaskevichartsiom.finalproject.airline.util.cryptography;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryptorBCrypt{
    private static final PasswordEncryptorBCrypt INSTANCE = new PasswordEncryptorBCrypt();

    public PasswordEncryptorBCrypt() {
    }

    public static PasswordEncryptorBCrypt getInstance() {
        return INSTANCE;
    }

    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }


    public boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
