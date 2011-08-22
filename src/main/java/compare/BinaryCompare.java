package compare;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class compare two binary file,
 * once find difference, print the index of differnce
 * such as 
 * Diff: file1 file2
 * [4] 0x11 0x12
 * @author zluo
 *
 */

public class BinaryCompare {
    private static String file1="c:/temp/image1.png";
    private static String file2="c:/temp/image2.png";
	
	
	public static void main(String[] args)
	{
	  byte[] barr1 = readFile(file1);
	  byte[] barr2 = readFile(file2);
	  
	  if (barr1.length != barr2.length)
	  {
		  System.out.printf("The size of file: %s is %d ", file1,barr1.length);
		  System.out.printf("The size of file: %s is %d ", file2,barr2.length);
	  }
	  else
	  {
		  System.out.printf("The size of two file: is %d\n", barr1.length);
		 
		  for(int i=0; i<barr1.length;i++)
		  {
			  if (barr1[i] != barr2[i])
			  {
				  System.out.printf("[%d]  %x %x\n", i, barr1[i], barr2[i]);
			  }
		  }
	  }
	  
	  
	  
	}

	public static byte[] readFile(String name)
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
	    try {
			FileInputStream in = new FileInputStream(name);
			
			byte[] buffer = new byte[1024];
            for(int n; (n=in.read(buffer))!=-1;)			
            {
            	out.write(buffer,0,n);
            }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out.toByteArray();
	}
}
