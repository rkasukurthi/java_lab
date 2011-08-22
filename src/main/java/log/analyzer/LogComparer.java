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
 * This class used to compare the same method time cost of two log files
 * 
 * 
 * 
 * @author zluo
 * 
 */

public class LogComparer {
	
	private static final String PATH="c:/temp/perf/";
	private static final String CSV_FILE="result";
	Percentile percentile = new Percentile(95);
	StandardDeviation sd = new StandardDeviation();
	private String titles;
	private Set<String> keys = new TreeSet();
    Map<String,Map<String, ArrayList<Integer>>> maps = new TreeMap<String,Map<String, ArrayList<Integer>>>();
	Pattern p;

	/**
	 * Three args log file list, seperated by ',' log file list, seperated by
	 * ','
	 * 
	 * expression
	 * 
	 * for example
	 * 
	 * leaving Class.method 15 ms.
	 * 
	 * key is 'Class.method'
	 * 
	 * value is 15 ms.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// Three args
		if (args.length < 3) {
			System.out.println("Usage: \n");
			System.out.println("arg[0]: extract expression \n");
			System.out.println("arg[1] to arg[n]: log file list1  \n");
			System.exit(1);
		}
		else
		{
		   for(String arg: args)
		   {
			   System.out.printf("Expression: %s\n",arg);	
		   }
		}
		
		LogComparer logComparer = new LogComparer();
        logComparer.compareResult(args);
          
	
	}
	
   public void compareResult(String ... args )
   {
	   p=Pattern.compile(args[0]);
		
       for (int i=1;i < args.length; i++)
       {
    	   readFile(args[i]);
       }
		writeResults();
   }

	public void readFile(String fileName) {

		try {
			// File inputStream
			File file = new File(fileName);
			String key = file.getName();
			key= key.substring(0, key.length()-4);
			
			FileInputStream fis = new FileInputStream(file);
			
			if (maps.get(key)==null)
			{
			  maps.put(key, new HashMap<String, ArrayList<Integer>>());
			}
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
//                System.out.println(strLine);
				filter(strLine, maps.get(key));
			}
			br.close();
			System.out.println(key +" :" + maps.get(key).size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			
		}
	}
	
	public void filter(String strLine, Map<String, ArrayList<Integer>> result)
	{
		Matcher m=p.matcher(strLine);
		 boolean isFind = m.find();

		 while(isFind) {
             addResult(result,m.group());
             isFind = m.find();
         }
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
		try {
			FileWriter fstream = new FileWriter(PATH + CSV_FILE + "_" + System.currentTimeMillis() + ".csv");
			BufferedWriter out = new BufferedWriter(fstream);
			
			StringBuilder builder = new StringBuilder(",");
			for(String key1: maps.keySet())
        	{
				builder.append(key1 +", , , ,");
				builder.append(",");
        	}
			builder.append("\n");
			System.out.print(builder.toString());
			out.write(builder.toString());

			
			builder = new StringBuilder(",");
			for(String key1: maps.keySet())
        	{
				builder.append("P(95),Mean,Min,Max,Dev");
				builder.append(",");
        	}
			builder.append("\n");
			System.out.print(builder.toString());
			out.write(builder.toString());

			for(String key:keys)
			{
				builder = new StringBuilder();
                builder.append(key);
                builder.append(",");
                for(String key1: maps.keySet())
            	{
                	Map<String, ArrayList<Integer>> map=maps.get(key1);
                	ArrayList<Integer> list = map.get(key);
                	builder.append(String.format("%.2f,%.2f(%d),%.2f,%.2f,%.2f,", percentile(list),average(list), (list!=null)?list.size():0, min(list), max(list),dev(list)));
            	}
                builder.append("\n");
				System.out.print(builder.toString());
				out.write(builder.toString());
		}
			  out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		}    
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
	
	public double percentile(ArrayList<Integer> list)
	{
		if (list==null) return 0.0;
		double[] arr = toDoubleArray(list);
		return percentile.evaluate(arr);
	}

	public double max(ArrayList<Integer> list)
	{
		if (list==null) return 0.0;
		return Collections.max(list);
	}
	public double min(ArrayList<Integer> list)
	{
		if (list==null) return 0.0;
		
		return Collections.min(list);
	}
	public double dev(ArrayList<Integer> list)
	{
		if (list==null) return 0.0;
		double[] arr = toDoubleArray(list);
		return sd.evaluate(arr);
	}
}
