package io.file.append;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileCreateReadWrite {
	
	static String fileName="c:/temp/testFile.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		try {
			System.out.println(readLastLine(fileName));
		} catch (Exception e) {
			writeLine("\nTitle");
		}
	   
		writeLine("\nddddddddddddddddddd" + new Date() +"\n");
		System.out.println(readLastLine(fileName));
		delete(fileName);
	}
	public static void writeLine(String line)
	{
		FileWriter out;
		try {
			out = new FileWriter(fileName,true);
			out.write(line);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String readLastLine( String fileName ) throws FileNotFoundException,IOException {
	        java.io.File file = new java.io.File( fileName );
	        java.io.RandomAccessFile fileHandler = new java.io.RandomAccessFile( file, "r" );
	        long fileLength = file.length() - 1;
	        StringBuilder sb = new StringBuilder();
	 
	        for( long filePointer = fileLength; filePointer != -1; filePointer-- ) {
	            fileHandler.seek( filePointer );
	            int readByte = fileHandler.readByte();                
	 
	            if( readByte == 0xA ) {
	                if( filePointer == fileLength ) {
	                    continue;
	                } else {
	                    break;
	                }
	            } else if( readByte == 0xD ) {
	                if( filePointer == fileLength - 1 ) {
	                    continue;
	                } else {
	                    break;
	                }                    
	            }
	 
	            sb.append( ( char ) readByte );
	        }
	 
	        String lastLine = sb.reverse().toString();
	        fileHandler.close();
	        return lastLine;
	}
	public static void delete(String fileName)
	{
		 File bkup = new File(fileName);
		    // Quick, now, delete it immediately:
		    bkup.delete();

	}
}
