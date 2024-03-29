package cryption;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/*
 * Add state handling! Don't allow same key/iv for encrypting different cipher text!
 */
public class AES {

    private static Charset PLAIN_TEXT_ENCODING = Charset.forName("UTF-8"); 
    private static String CIPHER_TRANSFORMATION = "AES/CTR/NoPadding";
    private static String KEY_TYPE = "AES";
    // 192 and 256 bits may not be available
    private static int KEY_SIZE_BITS = 128;

    private Cipher cipher;
    private SecretKey key;
    private IvParameterSpec iv;

    static {
        // only needed if the platform does not contain CTR encryption by default
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            // only needed for some platforms I presume
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        }
    }

    public AES() throws NoSuchAlgorithmException, NoSuchPaddingException,
            NoSuchProviderException {
        // not much use without a getter
//      final KeyGenerator kgen = KeyGenerator.getInstance(KEY_TYPE);
//      kgen.init(KEY_SIZE_BITS);
//      key = kgen.generateKey();
        cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
    }


     public void setKeyHex(String keyText) {

        byte[] bText = hexStringToByteArray(keyText);
        if (bText.length * Byte.SIZE != KEY_SIZE_BITS) {
            throw new IllegalArgumentException(
                    "Wrong key size, expecting " + KEY_SIZE_BITS / Byte.SIZE + " bytes in hex");
        }
        key = new SecretKeySpec(bText, KEY_TYPE);
    }

    public void setIVHex(String ivText) {
        byte[] bText = hexStringToByteArray(ivText);
        if (bText.length != cipher.getBlockSize()) {
            throw new IllegalArgumentException(
                    "Wrong IV size, expecting " + cipher.getBlockSize() + " bytes in hex");
        }
        iv = new IvParameterSpec(bText);
    }

    public String encrypt(String message) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException,
            InvalidAlgorithmParameterException {
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encrypted = cipher.doFinal(message.getBytes(PLAIN_TEXT_ENCODING));
        return byteArrayToHexString(encrypted);
    }

    public String decrypt(String hexCiphertext)
            throws IllegalBlockSizeException, BadPaddingException,
            InvalidKeyException, InvalidAlgorithmParameterException,
            UnsupportedEncodingException {
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] dec = hexStringToByteArray(hexCiphertext);
        byte[] decrypted = cipher.doFinal(dec);
        return new String(decrypted, PLAIN_TEXT_ENCODING);
    }

    private static String byteArrayToHexString(byte[] raw) {
        StringBuilder sb = new StringBuilder(2 + raw.length * 2);
        sb.append("0x");
        for (int i = 0; i < raw.length; i++) {
            sb.append(String.format("%02X", Integer.valueOf(raw[i] & 0xFF)));
        }
        return sb.toString();
    }

    // better add some input validation
    private static byte[] hexStringToByteArray(String hex) {
        Pattern replace = Pattern.compile("^0x");
        String s = replace.matcher(hex).replaceAll("");

        byte[] b = new byte[s.length() / 2];
        for (int i = 0; i < b.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(s.substring(index, index + 2), 16);
            b[i] = (byte) v;
        }
        return b;
    }

    public static void main(String[] args) {
        try {
            String key = "0x000102030405060708090A0B0C0D0E0F";
            String iv = "0x000102030405060708090A0B0C0D0E0F";

            String text = "Owlsteads answer";
            AES aes = new AES();
            aes.setKeyHex(key);
            aes.setIVHex(iv);
            String cipherHex = aes.encrypt(text);
            System.out.println(cipherHex);
            String deciphered = aes.decrypt(cipherHex);
            System.out.println(deciphered);
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("Something is rotten in the state of Denmark", e);
        } catch (UnsupportedEncodingException e) {
            // not always thrown even if decryption fails, add integrity check such as MAC
            throw new IllegalStateException("Decryption and/or decoding plain text message failed", e);
        }
    }
}