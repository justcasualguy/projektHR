package services.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
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
        String generatedPassword = null;
        StringBuilder sb = new StringBuilder();
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();

            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
       return sb.toString();
    }
    }


