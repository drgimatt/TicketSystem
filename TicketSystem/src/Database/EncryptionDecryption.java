package Database;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author Ryoji
 */
public class EncryptionDecryption {

    private static Cipher cipher;
    private static SecretKey secretKey;

    public EncryptionDecryption() {
        try {
            cipher = Cipher.getInstance("AES");
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            secretKey = keyGen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("AES algorithm not available in the environment: " + e.getMessage());
        } catch (NoSuchPaddingException e) {
            System.out.println("An error occurred while initializing the Cipher: " + e.getMessage());
        }
    }

    // byte[] varname = EncryptionDecryption.encrypt(pass);
    public static byte[] encrypt(String text) { 
        byte[] encryptedText = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            encryptedText = cipher.doFinal(text.getBytes());
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            System.out.println("An error occurred while encrypting the text: " + e.getMessage());
        }
        return encryptedText;
    }

    // String varname = EncryptionDecryption.decrypt(pass);
    public static String decrypt(byte[] encryptedText) {
        byte[] decryptedText = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            decryptedText = cipher.doFinal(encryptedText);
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            System.out.println("An error occurred while decrypting the text: " + e.getMessage());
        }
        return new String(decryptedText);
    }
}
