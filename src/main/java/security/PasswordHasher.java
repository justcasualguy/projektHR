package security;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

public class PasswordHasher {

    private  static final String salt = generateSalt();

    static private String generateSalt(){
        SecureRandom RAND = new SecureRandom();

        byte[] salt = new byte[100];
        RAND.nextBytes(salt);

        return Optional.of(Base64.getEncoder().encodeToString(salt)).get();
    }

    public static String hashPassword (String password) {
        final int ITERATIONS = 65536;
        final int KEY_LENGTH = 512;
        final String ALGORITHM = "PBKDF2WithHmacSHA512";

        char[] chars = password.toCharArray();
        byte[] bytes = salt.getBytes();

        PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

        Arrays.fill(chars, Character.MIN_VALUE);

        try {
            SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] securePassword = fac.generateSecret(spec).getEncoded();
            return Optional.of(Base64.getEncoder().encodeToString(securePassword)).get();

        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.err.println("Exception encountered in hashPassword()");
            return null;
        } finally {
            spec.clearPassword();
        }
    }

}
