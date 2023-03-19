package com.kshrd.registration.utillity;

import org.springframework.stereotype.Component;
import org.jasypt.util.text.AES256TextEncryptor;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

@Component
public class  GenerateCode {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "QWERTYUIOPasdfghjkl1234567890ZXCVBNM";
    //Id should not have "!@#$%^&*";

    private String generateRandomString(int length){
        StringBuilder value = new StringBuilder(length);
        for(int i=0; i<length; i++){
            value.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(value);
    }
    public String generateUserId(int length){
        return generateRandomString(length);
    }

    public String EncryptPassword(String password)
    {
        AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
        aesEncryptor.setPassword("#KSHRD2022");
        String myEncryptedPassword = aesEncryptor.encrypt(password);
        System.out.println("EncryptPassword: " + myEncryptedPassword );

        String correctToken1 = myEncryptedPassword.substring(0, 2);
        //System.out.println("correctToken1: " + correctToken1 );
        String correctToken2 = myEncryptedPassword.substring(2);
        //System.out.println("correctToken2: " + correctToken2 );
        String finalToken = correctToken1.concat(generateUserId(4)).concat(correctToken2);
        //System.out.println("finalToken: " + finalToken );
        return finalToken;
    }

//        public String EncryptPassword(String password)
//        {
//            AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
//            aesEncryptor.setPassword("#KSHRD2022");
//            String myEncryptedPassword = aesEncryptor.encrypt(password);
//            System.out.println("EncryptPassword: " + myEncryptedPassword );
//        return myEncryptedPassword;
//        }

    public String DecryptPassword(String passwordFromConfigFile)
    {
        String correctToken1 = passwordFromConfigFile.substring(0, 2);
//        System.out.println("correctToken1: " + correctToken1 );
        String correctToken2 = passwordFromConfigFile.substring(6);
//        System.out.println("correctToken2: " + correctToken2 );
        String finalToken = correctToken1.concat(correctToken2);
//        System.out.println("finalToken: " + finalToken );

        AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
        aesEncryptor.setPassword("#KSHRD2022");
        String decryptedPassword = aesEncryptor.decrypt(finalToken);
        System.out.println("DecryptPassword: " + decryptedPassword );
        return decryptedPassword;
    }

//    public String DecryptPassword(String passwordFromConfigFile)
//    {
//        AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
//        aesEncryptor.setPassword("#KSHRD2022");
//        String decryptedPassword = aesEncryptor.decrypt(passwordFromConfigFile);
//        System.out.println("DecryptPassword: " + decryptedPassword );
//        return decryptedPassword;
//    }

    public static String encodeBase64(String message) {
        String code = Base64.getEncoder().encodeToString(message.getBytes());
        System.out.println("encodeBase64: " + code);
        return code;
    }

    public static String decodeBase64(String encodedMessage) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedMessage);
        String decodedString = new String(decodedBytes);
        System.out.println("decodeBase64: " + decodedString);
        return decodedString;
    }
}
