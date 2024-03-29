package inventorysystem;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class Utils {

    private final Random RANDOM= new SecureRandom();
    private final String ALPHABET="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final String ALPHABETNOCAPITAL="0123456789abcdefghijklmnopqrstuvwxyz";
    private final int ITERATIONS= 10000;
    private final int KEY_LENGTH=256;
    private final int  OBJECTIDLENGHT=64;

    public String generateObjectId(int key_length){
        return generateRandomString(key_length);
    }
    public String generateRandomString(int key_length){
        StringBuilder returnValue = new StringBuilder(key_length);

        for (int i=0; i<key_length;i++){
            returnValue.append(ALPHABETNOCAPITAL.charAt(RANDOM.nextInt(ALPHABETNOCAPITAL.length())));
        }
        return new String(returnValue);
    }

}