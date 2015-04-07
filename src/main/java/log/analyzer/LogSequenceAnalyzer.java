package log.analyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.math.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math.stat.descriptive.rank.Percentile;

/**
 * This class used to generate log sequence.
 * filter out unnecessary entrys.
 * generate sequence 
 * @author zluo
 * 
 */

public class LogSequenceAnalyzer {
	
	Date startDate;
	Date endDate;
	private final String AWS_AUTHENTICATION_SUCCEEDED="AWS_AUTHENTICATION_SUCCEEDED";
	private final String AWS_TRANSACTION_COMPLETED="AWS_TRANSACTION_COMPLETED";
	
	private static final String file="c:/temp/farmer/user_enter_leaving.csv";
	private static final String CSV_FILE="result";
	private Set<String> keys = new TreeSet();
    Map<String,Interval> map = new TreeMap<String,Interval>();

	public static void main(String[] args) {
		LogSequenceAnalyzer logComparer= new LogSequenceAnalyzer();
		logComparer.compareResult(args);
          
	
	}
	
   public void compareResult(String ... args )
   {
    	   readFile(file);
		writeResults();
   }

	public void readFile(String fileName) {

		try {
			// File inputStream
			File file = new File(fileName);
			String key = file.getName();
			key= key.substring(0, key.length()-4);
			
			FileInputStream fis = new FileInputStream(file);
			
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				
				String[] arr = strLine.split(",");
				addItem(arr[0],arr[1],arr[2]);
				System.out.println(strLine);
			}
			br.close();
//			System.out.println(key +" :" + maps.get(key).size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			
		}
	}
	
	private void addItem(String activity, String time, String guid)
	{
		if (map.get(guid)==null) map.put(guid, new Interval());
        
		Interval interval= map.get(guid);
		
		System.out.println(time);
		Date date=new Date(time);
		addTimeRange(date);
		
		if (activity.equalsIgnoreCase(AWS_AUTHENTICATION_SUCCEEDED))
		{
		  if (interval.getStart()==null)
		  {
			  interval.setStart(date);	
		  }
		  else
		  {
			  if (interval.getStart().before(date))
			  {
				  interval.setStart(date);
			  }
		  }
		}
		else if (activity.equalsIgnoreCase(AWS_TRANSACTION_COMPLETED))
		{
			if (interval.getEnd()==null )
			  {
				  interval.setEnd(date);	
			  }
			  else
			  {
				  if (interval.getEnd().before(date))
				  {
					  interval.setEnd(date);
				  }
			  }
		}
	
	}
	
	private void addTimeRange(Date date)
	{
		if (startDate==null) startDate= date;
		if (endDate==null) endDate= date;
		
		if (startDate.after(date)) startDate=date;
		if (endDate.before(date)) endDate=date;
	}
	
	private void addResult(Map<String, ArrayList<Integer>> map, String result)
	{
		String[] results = result.split(" ");
		String key = results[1].intern();
		keys.add(key);
		String value = results[2];
//	    System.out.format("key: %s  value: %s\n", key, value);	
//		System.out.println(map); 
		if(map.get(key)==null)
		{
			map.put(key, new ArrayList<Integer>());
		}
		map.get(key).add(Integer.valueOf(value));
		
//		System.out.println(getResult1());
		
	}

	public void writeResults()
	{
		
//		try {
//			FileWriter fstream = new FileWriter("C:/TEMP/" + CSV_FILE + "_" + System.currentTimeMillis() + ".csv");
//			BufferedWriter out = new BufferedWriter(fstream);
//			
//			StringBuilder builder = new StringBuilder(",");
//			for(String key1: map.keySet())
//        	{
//				builder.append(key1 +", , , ,");
//				builder.append(",");
//        	}
//			builder.append("\n");
//			System.out.print(builder.toString());
//			out.write(builder.toString());
//
//			
//			builder = new StringBuilder(",");
//			for(String key1: map.keySet())
//        	{
//				builder.append("P(95),Mean,Min,Max,Dev");
//				builder.append(",");
//        	}
//			builder.append("\n");
//			System.out.print(builder.toString());
//			out.write(builder.toString());
//
//			for(String key:keys)
//			{
//				builder = new StringBuilder();
//                builder.append(key);
//                builder.append(",");
//                builder.append("\n");
//				System.out.print(builder.toString());
//				out.write(builder.toString());
//		}
//			  out.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally
//		{
//		}    
	}
	
	public double average(ArrayList<Integer> list)
	{
	   if (list==null) return -1;
	   
		int sum=0;
		for(Integer i: list)
	   {
		   sum +=i;
	   }
		return sum /list.size();
	}
	
	private double[] toDoubleArray(ArrayList<Integer> list)
	{
		double[] arr = new double[list.size()];
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=list.get(i).doubleValue();
		}		
		
		return arr;
	}
	

	public double max(ArrayList<Integer> list)
	{
		if (list==null) return 0.0;
		return (double) Collections.max(list);
	}
	public double min(ArrayList<Integer> list)
	{
		if (list==null) return 0.0;
		
		return (double) Collections.min(list);
	}
}
