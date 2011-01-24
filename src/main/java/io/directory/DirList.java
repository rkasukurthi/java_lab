package io.directory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;


public class DirList {
	public static void main(String[] args)
	{
		File path= new File("c:/src");
		String[] list;
		String[] list1;
		
		if (args.length==0)
		{
			list=path.list();
		}
		else
		{
			list=path.list(new DirFilter(args[0]));
			list1=path.list(filter(args[0]));
		}
		
		for(String dirItem:list)
		{
			System.out.println(dirItem);
		}
	}
	
/*
 * Anomynous inner class implement example
 * inner class inside the method
 */
	private static FilenameFilter filter(final String regex)
	{
		return new FilenameFilter()
		{
            private Pattern pattern = Pattern.compile(regex);
			public boolean accept(File dir, String name)
			{
				return pattern.matcher(name).matches();
			}
		};
	}
}

/**
 * The DirFilter implements FilenameFilter, the sole resaon for existence is to provide the <code>accept()</code> method to the 
 * list() method so that <code>list()</code> can "call back" accept() to determine which file names should be included in the 
 * list. More specifically, this is a example of <b>Strategy<b/> design pattern.
 * 
 * @author zluo
 */
class DirFilter implements FilenameFilter
{
	private Pattern pattern;
	
	public DirFilter(String regex) {
		this.pattern = Pattern.compile(regex);
	}

	public boolean accept(File dir, String name)
	{
		return pattern.matcher(name).matches();
	}
}
