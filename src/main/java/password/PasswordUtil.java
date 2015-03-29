package password;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.SecretKeyFactory;

/**
 * This is a static class containing utility methods for dealing
 * with passwords.
 * 
 */
class PasswordUtil
{
    private static final String CHAR_ENC = "UTF-8";
    private static final String RAND_ALG = "SHA1PRNG";
    private static final SecureRandom rand = getSecureRandom(RAND_ALG);
    
    private PasswordUtil() { /* static class */ }
    
    /*
     * Create a secure random number generation instance using the given algorithm.
     * This is a convenience method to avoid writing a try/catch in a static block.
     */
    private static SecureRandom getSecureRandom(String alg)
    {
        try {
            return SecureRandom.getInstance(alg);
        } catch (NoSuchAlgorithmException e) {
            IllegalArgumentException ex = new IllegalArgumentException("invalid secure random algorithm: " + e.getMessage());
            ex.initCause(e);
            throw ex;
        }
    }
    
    /**
     * Create a secret key factory using the given algorithm.  This is a
     * convenience method to avoid writing a try/catch in a static block.
     * 
     * @param alg the secret key algorithm.
     * @return the secret key factory.
     * @throws IllegalArgumentException if the secret key algorithm is invalid.
     */
    static SecretKeyFactory getSecretKeyFactory(String alg)
    {
        try {
            return SecretKeyFactory.getInstance(alg);
        } catch (NoSuchAlgorithmException e) {
            IllegalArgumentException ex = new IllegalArgumentException("invalid secret key factory algorithm '" + alg + "': " + e.getMessage());
            ex.initCause(e);
            throw ex;
        }
    }
    
    /**
     * Fill an existing array with random bytes.  The array is returned.
     * 
     * @param bytes the array to fill.
     * @return the array argument.
     */
    static byte[] setRandomBytes(byte[] bytes)
    {
        rand.nextBytes(bytes);
        return bytes;
    }
    
   
    /**
     * Create a byte array from the array of characters.  Use the system's default
     * character encoding.
     * 
     * @param chars the characters to convert.
     * @return the characters as bytes.
     * @throws IOException if an error occurs converting the characters to bytes.
     */
    static byte[] toByteArray(char[] chars) throws IOException
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OutputStreamWriter wr = new OutputStreamWriter(out, CHAR_ENC);
        wr.write(chars);
        wr.flush();
        return out.toByteArray();
    }
    
    /**
     * Create a character array from the array of bytes.  The only purpose
     * of this method is to avoid the string created by:
     *
     * <pre>
     *      new String(bytes).toCharArray()
     * </pre>
     *   
     * @param bytes the bytes to convert.
     * @return the bytes as characters.
     * @throws IOException if an error occurs converting the bytes to characters.
     */
    static char[] toCharArray(byte[] bytes) throws IOException
    {
        CharArrayWriter out = new CharArrayWriter();
        InputStreamReader rd = new InputStreamReader(new ByteArrayInputStream(bytes), CHAR_ENC);
        for (int n = 0; (n = rd.read()) != -1;) {
            out.write(n);
        }
        out.flush();
        return out.toCharArray();
    }
    /**
     * 
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception
    {
      System.out.println(HashedPassword.encodeHash("password".toCharArray()));
    }
}
