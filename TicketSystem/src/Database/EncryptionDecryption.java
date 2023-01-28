package Database;

//import java.security.InvalidKeyException;
//import java.security.Key;
//import java.security.NoSuchAlgorithmException;
//import java.util.Base64;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.KeyGenerator;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;




import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;



/**
 *
 * @author Ryoji
 */
public class EncryptionDecryption {

//    private static Cipher cipher;
//    private static SecretKey secretKey;

//    public EncryptionDecryption() {
//        try {
//            cipher = Cipher.getInstance("AES");
//            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
//            keyGen.init(128);
//            secretKey = keyGen.generateKey();
//            String convertkey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
//            System.out.println(convertkey);
//        } catch (NoSuchAlgorithmException e) {
//            System.out.println("AES algorithm not available in the environment: " + e.getMessage());
//        } catch (NoSuchPaddingException e) {
//            System.out.println("An error occurred while initializing the Cipher: " + e.getMessage());
//        }
//    }
//
//    // byte[] varname = EncryptionDecryption.encrypt(pass);
//    public static byte[] encrypt(String text) { 
//        byte[] encryptedText = null;
//        
//        byte[] encoded = Base64.getDecoder().decode("CcNFRQWP3Kj60/isGU4E/A==");
//        SecretKey key = new SecretKeySpec (encoded, 0, encoded.length, "AES");
//        try {
//            cipher = Cipher.getInstance("AES");
//            cipher.init(Cipher.ENCRYPT_MODE, key);
//            encryptedText = cipher.doFinal(text.getBytes());
//        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
//            System.out.println("An error occurred while encrypting the text: " + e.getMessage());
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(EncryptionDecryption.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NoSuchPaddingException ex) {
//            Logger.getLogger(EncryptionDecryption.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return encryptedText;
//    }
//
//    // String varname = EncryptionDecryption.decrypt(pass);
//    public static String decrypt(byte[] encryptedText) {
//        byte[] decryptedText = null;
//        byte[] encoded = Base64.getDecoder().decode("CcNFRQWP3Kj60/isGU4E/A==");
//        SecretKey key = new SecretKeySpec (encoded, 0, encoded.length, "AES");        
//        try {
//            cipher = Cipher.getInstance("AES");
//            cipher.init(Cipher.DECRYPT_MODE, key);
//            decryptedText = cipher.doFinal(encryptedText);
//        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
//            System.out.println("An error occurred while decrypting the text: " + e.getMessage());
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(EncryptionDecryption.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NoSuchPaddingException ex) {
//            Logger.getLogger(EncryptionDecryption.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return new String(decryptedText);
//    }
//

    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private Cipher cipher;
    byte[] arrayBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    SecretKey key;

    public EncryptionDecryption() throws Exception {
        myEncryptionKey = "CcNFRQWP3Kj60/isGU4E/A==";
        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        ks = new DESedeKeySpec(arrayBytes);
        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = skf.generateSecret(ks);
    }
    public String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }    
    public String decrypt(String encryptedString) {
        String decryptedText=null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText= new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }    
}
