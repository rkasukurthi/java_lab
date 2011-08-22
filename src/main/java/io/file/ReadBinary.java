package io.file;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadBinary {
	
	public static byte[] readBinaryFile(String fileName)
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			InputStream in = new FileInputStream(fileName);
            byte[] buffer = new byte[1024];		
            for(int n; (n=in.read(buffer)) != -1;)
            {
            	out.write(buffer,0,n);
            }
            
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out.toByteArray();
	}
}
