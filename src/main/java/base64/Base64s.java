package base64;

import java.io.IOException;
import java.util.Vector;
/**
* A class providing a static function for encoding
* binary data using the Base64 algorithm.
* <P>
* The details of Base64 encoding can be found in RFC 1521,
* section 5.2.  The basic idea is this:
* <P>
* <PRE>
* ---------------|---------------|---------------|
* 0 1 2 3 4 5 6 7 0 1 2 3 4 5 6 7 0 1 2 3 4 5 6 7
* -----------|-----------|-----------|-----------|
* </PRE>
* <UL>
* <LI>Split each three bytes of input into four 6-bit
* integers
* <LI>Use each integer as an index into a table of
* printable characters
* <LI>Output the four characters thus selected.
* </UL>
* <P>
* If the number of bytes of input is not evenly
* divisible by three, use zero bits on the right
* to flush any remaining input, then pad the output
* with "=" characters as follows:
* <PRE>
* Input Length
*    Mod 3
*      0          No padding
*      1          Pad with two "="
*      2          Pad with one "="
* </PRE>
* The translation table consists of the uppercase
* alphabetic characters, followed by the lowercase
* alphabetic characters, followed by the digits 0
* through 9, and finally "+" and "/":
* <PRE>
*  0 A        16 Q        32 g        48 w
*  1 B        17 R        33 h        49 x
*  2 C        18 S        34 i        50 y
*  3 D        19 T        35 j        51 z
*  4 E        20 U        36 k        52 0
*  5 F        21 V        37 l        53 1
*  6 G        22 W        38 m        54 2
*  7 H        23 X        39 n        55 3
*  8 I        24 Y        40 o        56 4
*  9 J        25 Z        41 p        57 5
* 10 K        26 a        42 q        58 6
* 11 L        27 b        43 r        59 7
* 12 M        28 c        44 s        60 8
* 13 N        29 d        45 t        61 9
* 14 O        30 e        46 u        62 +
* 15 P        31 f        47 v        63 /
* </PRE>
*/
public class Base64s {

	   /**
	   * The translation table
	   */
	   public static final String base64Table =
	      "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
	      "abcdefghijklmnopqrstuvwxyz" +
	      "0123456789" +
	      "+/";

	   /**
	   * Encodes the given byte buffer
	   * @param buffer the byte buffer
	   * @return the encoded string
	   */
	   public static String encode(byte[] buffer)
	   {
	      StringBuffer result = new StringBuffer();
	      int state = 0;
	      int n = buffer.length;
	      int index = 0;

	      for (int i = 0; i < n; i++) {
	         int c = buffer[i] & 0xFF;

	         // Take three bytes of input = 24 bits
	         // Split it into 4 chunks of six bits each
	         // Treat these chunks as indices into the
	         // base64 table above.

	         switch (state) {

	            case 0:
	               index = (c >> 2) & 0x3F;
	               result.append(base64Table.charAt(index));
	               index = (c << 4) & 0x30;
	               break;

	            case 1:
	               index |= (c >> 4) & 0x0F;
	               result.append(base64Table.charAt(index));
	               index = (c << 2) & 0x3C;
	               break;

	            case 2:
	               index |= (c >> 6) & 0x03;
	               result.append(base64Table.charAt(index));
	               index = c & 0x3F;
	               result.append(base64Table.charAt(index));
	               break;
	         }
	         state = (state + 1) % 3;
	      }

	      // Complete the string with zero bits
	      // and pad with "=" characters as necessary

	      switch (state) {
	         case 0:
	            // No padding necessary
	            break;
	         case 1:
	            result.append(base64Table.charAt(index));
	            result.append('=');
	            result.append('=');
	            break;
	         case 2:
	            result.append(base64Table.charAt(index));
	            result.append('=');
	            break;
	      }

	      return result.toString();
	   }
	   
	   

    /**
     * Decodes the given string buffer
     * @param buffer the string to be decoded
     * @return the decoded byte array
     * @exception java.io.IOException if the buffer
     * contains invalid data
     */
    public static byte[] decode(String _buffer)
    throws IOException {
        String buffer = stripString(_buffer);
        if ((buffer.length() % 4) != 0) {
            throw new IOException("not multiple of 4");
        }
        
        int state = 0;
        int ch = 0;
        Vector result = new Vector();
        for (int i = 0; i < buffer.length(); i++) {
            int b = buffer.charAt(i);
            int p = base64Table.indexOf(b);
            if (p == -1)
                if (b == '=')
                    p = 0;
                else
                    throw new IOException
                    ("Invalid character in input");
            
            switch (state) {
                
                case 0:
                    ch = (p << 2) & 0xFC;
                    break;
                    
                case 1:
                    ch |= ((p >> 4) & 0x03);
                    result.addElement(new Integer(ch));
                    ch = (p << 4) & 0xF0;
                    break;
                    
                case 2:
                    ch |= ((p >> 2) & 0x0F);
                    result.addElement(new Integer(ch));
                    ch = (p << 6) & 0xC0;
                    break;
                    
                case 3:
                    ch |= (p & 0x3F);
                    result.addElement(new Integer(ch));
                    break;
            }
            state = (state + 1) % 4;
        }
        
        // Remove the trailing nulls
        
        int nPad = 0;
        for (int i = buffer.length()-1; i >= 0; i--) {
            char c = buffer.charAt(i);
            if (c == '=')
                nPad++;
            else break;
        }
        int n = result.size() - nPad;
        if (n < 0)
            n = 0;
        
        // Return the byte array
        
        byte[] bytes = new byte[n];
        for (int i = 0; i < n; i++)
            bytes[i] =
            ((Integer) result.elementAt(i)).byteValue();
        
        return bytes;
    }
/**
 * This method used for removing white space, such as \n \t
 * @param s
 * @return
 */
    private static String stripString(String s) {
    	StringBuffer sb = new StringBuffer();
    	java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(s);
    	
    	while (tokenizer.hasMoreTokens()) {
    		sb.append(tokenizer.nextToken());
    	}
    	
    	return sb.toString();
    }
}
