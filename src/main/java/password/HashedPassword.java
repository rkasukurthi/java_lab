package password;

	import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import base64.Base64s;

	/**
	 * This class contains methods to handle version 2 hashed passwords.
	 * 
	 * <p/>
	 * 
	 * Version 2 hashes passwords with <code>SHA-256</code>.  It has the
	 * following form:
	 * 
	 * <pre>
	 *   "2." meta-hash "." salt "." hashed-password
	 * </pre>
	 * 
	 * where <code>salt</code> is an 8 byte random value encoded as base-64
	 * and <code>hashed-password</code> is the base-64 encoded <code>SHA-256</code>
	 * hash of the salt and the password.  The <code>meta-hash</code> exists only
	 * to distinguish this encoding from a cleartext password (see below).  It is
	 * the first 8 bytes of the <code>SHA-256</code> hash over the version (as a
	 * byte), the raw salt and the raw hashed password.  Here <i>raw</i> means
	 * prior to base-64 encoding.
	 * 
	 * Early versions of some system (e.g. AWS) stored cleartext passwords for
	 * authentication purposes.  Since we may still encounter such systems, we need
	 * a way to distinguish our encoded hashes from arbitrary cleartext passwords.
	 * The <code>meta-hash</code> field serves this purpose, as it is <i>extremely</i>
	 * unlikely that a cleartext password would have the necessary structure to
	 * create a valid <code>meta-hash</code>.
	 * 
	 */
	public class HashedPassword {
	    static final String VERSION = "2";
	    private static final int META_LEN = 8;
	    private static final int SALT_LEN = 8;
	    private static final String HASH_ALG = "SHA-256";
	    private static final String DOT_B64 = "\\.((?:\\p{Alnum}|\\+|/|=)+)";
	    private static final Pattern RE_ENC_HASH = Pattern.compile(VERSION + DOT_B64 + DOT_B64 + DOT_B64);
	    
	    private HashedPassword() { /* static class */ }
	    
	    private static byte[][] decodeAndSplit(String encodedHash) throws Exception
	    {
	        try {
	            Matcher matcher = RE_ENC_HASH.matcher(encodedHash);
	            if ( ! matcher.matches()) {
	                throw new Exception("invalid encoded hash format '" + encodedHash + "'");
	            }
	            byte[] meta = Base64s.decode(matcher.group(1));
	            if (meta.length != META_LEN) {
	                throw new Exception("meta-hash has wrong size: " + meta.length + " != " + META_LEN);
	            }
	            byte[] salt = Base64s.decode(matcher.group(2));
	            if (salt.length != SALT_LEN) {
	                throw new Exception("salt has wrong size: " + salt.length + " != " + SALT_LEN);
	            }
	            byte[] hash = Base64s.decode(matcher.group(3));
	            byte[] calcMeta = meta(VERSION.getBytes(), salt, hash);
	            if ( ! Arrays.equals(meta, calcMeta)) {
	                throw new Exception("meta-hashes don't match");
	            }
	            return new byte[][] { salt, hash };
	        } catch (IOException e) {
	            throw new Exception("error decrypting password", e);
	        }
	    }
	    
	    /*
	     * Return the hash over the salt and the password.
	     */
	    private static byte[] hash(byte[] salt, char[] clearPassword) throws Exception
	    {
	        byte[] clearPassBytes = null;
	        try {
	            clearPassBytes = PasswordUtil.toByteArray(clearPassword);
	            MessageDigest md = MessageDigest.getInstance(HASH_ALG);
	            md.update(salt);
	            return md.digest(clearPassBytes);
	        } catch (GeneralSecurityException e) {
	            throw new Exception("error encrypting password", e);
	        } catch (IOException e) {
	            throw new Exception("error encrypting password", e);
	        } finally {
	            if (clearPassBytes != null) { Arrays.fill(clearPassBytes, (byte) 0); }
	        }
	    }
	    
	    private static byte[] meta(byte[] version, byte[] salt, byte[] passHash) throws Exception
	    {
	        MessageDigest md;
	        try {
	            md = MessageDigest.getInstance(HASH_ALG);
	        } catch (NoSuchAlgorithmException e) {
	            throw new Exception("error creating meta-hash: " + e.getMessage(), e);
	        }
	        md.update(version);
	        md.update(salt);
	        byte[] h = md.digest(passHash);
	        byte[] metaHash = new byte[META_LEN];
	        System.arraycopy(h, 0, metaHash, 0, metaHash.length);
	        return metaHash;
	    }
	    
	    static String encodeHash(char[] clearPassword) throws Exception
	    {
	        byte[] salt = PasswordUtil.setRandomBytes(new byte[SALT_LEN]);
	        byte[] hash = hash(salt, clearPassword);
	        byte[] meta = meta(VERSION.getBytes(), salt, hash);
	        return VERSION + "." + Base64s.encode(meta) + "." + Base64s.encode(salt) + "." + Base64s.encode(hash);
	    }

	    /**
	     * Indicate whether the password is consistent with the encoded hash.
	     * 
	     * @param clearPassword the cleartext password.
	     * @param encodedHash the encoded hash.
	     * @return true if the password is consistent, otherwise false.
	     * @throws PasswordException if an error occurs while attempting to decode the
	     * encoded hash.
	     */
	    static boolean passwordMatchesHash(char[] clearPassword, String encodedHash) throws Exception
	    {
	        byte[][] saltAndHash = decodeAndSplit(encodedHash);
	        byte[] passwdHash = hash(saltAndHash[0], clearPassword);
	        return Arrays.equals(saltAndHash[1], passwdHash);
	    }
	}
