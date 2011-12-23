package log.analyzer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This Utils trying to find the maximum time interval between two lines of logs
 * 
 * @author zluo
 *
 */

public class LogTimeIntervalAnalazyer {
	
	static long timeStamp;
	static long timeStamp1;
//	static final String rex = "^\\[.*?\\]"; //[12/5/11 15:44:36:678 EST]
	static final String rex = "\\d*:\\d*:\\d*:\\d*"; //15:44:36:678
	static long max =0; //15:44:36:678
	static int maxLine =0; //15:44:36:678
	static String maxLineContent =""; //15:44:36:678
	static Pattern pattern; 
	static DateFormat df;
	public static void main(String[] args)
	{
		System.out.println("--------------Log Time Interval--------------");
		LogTimeIntervalAnalazyer timeAnalazyer= new  LogTimeIntervalAnalazyer();
		pattern=Pattern.compile(rex);
		df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
		timeAnalazyer.readFiles(args);
	}
	public void readFiles(String... args) {
		for (int i = 0; i < args.length; i++) {
			readFile(args[i]);
		}
	}

	/**
	 * Read log files line by line
	 * 
	 * @param fileName
	 */
	public void readFile(String fileName) {

		try {
			// Get the object of DataInputStream
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new DataInputStream(new FileInputStream(fileName))));
			String strLine;
			int line = 1;
			String date;
			String previosLine="";
			while ((strLine = br.readLine()) != null) {
				date=extractString(strLine);
				if (date !=null)
				{
//					System.out.println(date + " " + convertToLong(date));
					if (timeStamp==0)
					{
						timeStamp=convertToLong(date);
						previosLine=strLine;
					}
					else 
					{
						timeStamp1=convertToLong(date);
						long delta= timeStamp1-timeStamp;
						
						if(delta >100 && delta <5000)
						{
							System.out.println("[" + line +"]" + delta + " " + previosLine);
							System.out.println("[" + line +"]" + delta + " " + strLine);
							System.out.println("-----------------------------------------");
						}
						
						if (delta>max)
						{
							max=delta;
							maxLine=line;
							maxLineContent=strLine;
						}
						timeStamp=timeStamp1;
						previosLine=strLine;
					}
				}
		         //		logs.add(Entry.build(line++, strLine,1));
				line++;
			
			}
			System.out.println("Max [" + maxLine +"]" + max + " " + maxLineContent);

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String extractString(String str)
	{
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
//			System.out.print("Start index: " + matcher.start());
//			System.out.print(" End index: " + matcher.end() + " ");
//			System.out.println(matcher.group());
			return str.substring(matcher.start(),matcher.end());
		}
		return null;
	}
	
	public long convertToLong(String str)
	{
		String times[]=str.split(":");
		return (Integer.valueOf(times[0])*3600 + Integer.valueOf(times[1])*60 + Integer.valueOf(times[2]))*1000 +Integer.valueOf(times[3]) ;
	}

}
