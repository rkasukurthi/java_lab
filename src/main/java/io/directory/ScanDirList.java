package io.directory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;


public class ScanDirList {
	 public void walk( String path ) {

	        File root = new File( path );
	        File[] list = root.listFiles();

	        for ( File f : list ) {
	            if ( f.isDirectory() ) {
	                walk( f.getAbsolutePath() );
	                System.out.println( "Dir:" + f.getAbsoluteFile() );
	            }
	            else {
	                System.out.println( "File:" + f.getAbsoluteFile()  + " size:=" + f.length());
	            }
	        }
	    }

	    public static void main(String[] args) {
	    	ScanDirList fw = new ScanDirList();
	        fw.walk("c:\\src" );
	    }
}
