package log.analyzer;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.math.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math.stat.descriptive.rank.Percentile;

/**
 * This class generate AWS Sequence Diagram based on 
 * leaving and entering logs. 
 *
 * C:/TEMP/JPMC_LOG/silanis_aix_10docs.log
 * 
 * @author zluo
 * 
 */

public class LogAnalyzer {

//	String[] dropList = {"SetAttributeAction.complete", 
//			"AwsSOAPBindingImpl.getDocumentPageImage",
//			"DocumentAction.complete",
//			"AwsSOAPBindingImpl.getAutographImage"
//			};
	/**
	 * 
	 */
	String[] dropList = {"SetAttributeAction.complete", 
//			"AwsSOAPBindingImpl.getDocumentPageImage",
			"DocumentAction.complete",
//			"AwsSOAPBindingImpl.getAutographImage"
	};
	String[] findList = {};
//			"AwsSOAPBindingImpl.getDocumentPageImage" };
	
	Map<String, String> alaisMap= new HashMap<String,String>();
	Map<String,String> DEMap= new HashMap<String,String>();
	
	Stack<Entry> stack = new Stack<Entry>();
	List<Entry> logs = new LinkedList<Entry>();
	
	static StringBuilder builder= new StringBuilder();
	static StringBuilder mergedbuilder= new StringBuilder();
	static StringBuilder summarybuilder= new StringBuilder();
	static List<String> summaryList= new ArrayList();
	static StringBuilder csvFilebuilder= new StringBuilder();

	private static final String PATH = "c:/temp/perf/";
	private static String inputPath=null;
	private static final String CSV_FILE = "result";

	public static void main(String[] args) {

		if (args.length < 1) {
			System.out.println("Usage: Input log files ");
		}

		LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.init();
		analyzer.readFiles(args);
		analyzer.find();
		System.out.println(builder.toString());
		
		File file = new File(fileName);

		inputPath=file.getParent()+"/results" + System.currentTimeMillis() ;
		new File(inputPath).mkdirs();

		analyzer.getSequenceDiagram(builder.toString(), "detail_diagram","rose");
		
		analyzer.getSequenceDiagram(mergedbuilder.toString(), "simple_diagram", "rose");
		
		analyzer.getSequenceDiagram(summarybuilder.toString(),"summary_diagram", "rose");

		analyzer.writeCSV(getFileName("summary", ".csv"));

	}
	
	public void init()
	{
		stack.push(new Entry(0));
		addAlais();
		addDEmaps();
		summaryList.add("Name,Total Time ,DB Time,DE Time, eSEPT Time\n");
	}
	
	public void addAlais()
	{
		alaisMap.put("CommandExecutor$GuidLoader", "DB");
		alaisMap.put("CommandExecutor$DefaultStorer", "DB");
		alaisMap.put("run", " ");
		alaisMap.put("complete", " ");
	}
	
	public void addDEmaps()
	{
		DEMap.put("CommandExecutor", "DB");
		DEMap.put("CommandExecutor$GuidLoader", "DB");
		DEMap.put("CommandExecutor$DefaultStorer", "DB");
		DEMap.put("RenderAction", "DE");
		DEMap.put("ExtractAction", "DE");
		DEMap.put("CustomizeAction", "DE");
		DEMap.put("BindAction", "DE");
		DEMap.put("FlattenAction", "DE");
		DEMap.put("AwsSOAPBindingImpl", "eSEP");
	}	

	public void readFiles(String... args) {
		for (int i = 0; i < args.length; i++) {
			readFile(args[i]);
		}
	}
	
	
    /** Read log files line by line
     * 
     * @param fileName
     */
	public void readFile(String fileName) {

		try {

			// Get the object of DataInputStream
			BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file))));
			String strLine;
			int line = 1;
			while ((strLine = br.readLine()) != null) {
				logs.add(Entry.build(line++, strLine));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void find() {
		List<Entry> previousList=null;
		while (true) {
			String first = findFirst(logs);
			if (first != null) {
				List<Entry> list = findSequence(first, logs);
//				System.out.println(list.size());
				
				logs.removeAll(list);
				
				if (!list.get(0).getClassName().equalsIgnoreCase("AwsSOAPBindingImpl")) continue;
				
				filter(list);
				
				generateSequenceText(list, builder);
				
				if (list.size()==2)
				{
					if (previousList==null)
					{
						previousList=list;
					}
					else
					{
                         if (!merge(previousList, list))
                         {
							extracted(previousList);
							previousList=null;  
							merge(list);				
							generateSequenceText(list, mergedbuilder);
						//				System.out.println(logs.size());
						
						// Generate Summary Diagram				
						replaceFullName(list);
						merge(list);
						generateSequenceText(list, summarybuilder);
						
						generateCSV(list);
                         }
					}
				}
				else
				{
                   if (previousList !=null)
                   {
					extracted(previousList);
                    previousList=null;   
                   }
                    merge(list);				
					generateSequenceText(list, mergedbuilder);
				//				System.out.println(logs.size());
				
				// Generate Summary Diagram				
				replaceFullName(list);
				merge(list);
				generateSequenceText(list, summarybuilder);
				
				generateCSV(list);
			}
			} else
				break;
		}
	}

	private void extracted(List<Entry> previousList) {
		{
			   generateSequenceText(previousList, mergedbuilder);
			   replaceFullName(previousList);
			   generateSequenceText(previousList, summarybuilder);
			   generateCSV(previousList);
			   previousList=null;
		   }
	}
	
	/**
	 * 
	 * @param list
	 */
			
	public void generateCSV(List<Entry> list)
	{
		if (list.size()==0) return; 
		
		StringBuilder builder= new StringBuilder();
	    String method;
	    int deTime=0;
	    int dbTime=0;
	    int eSEPTime=0;
	    int total=0;
		for(Entry entry:list)	
	    {
	    	if (!entry.isEnter() && entry.getClassName().equalsIgnoreCase("DE"))
	    	{
	    		deTime=entry.getTime();
	    	}

	    	if (!entry.isEnter() && entry.getClassName().equalsIgnoreCase("DB"))
	    	{
	    		dbTime=entry.getTime();
	    	}
	    }
		method=list.get(list.size()-1).getMethodName();
		if (list.get(list.size()-1).getCount()>1)
		{
			method= method + " (" + list.get(list.size()-1).getCount() + ")";
		}
		total=list.get(list.size()-1).getTime();
		eSEPTime=total-deTime-dbTime;
		String  out =method + "," + total + "," + dbTime +"," + deTime + "," + eSEPTime +"\n";
		summaryList.add(out);
	}
	
	public void replaceFullName(List<Entry> list)
	{
		for(Entry entry: list)
		{
			String newName = DEMap.get(entry.getClassName());
//			System.out.println(entry.getFullName());
            if (newName !=null)
            {
            	entry.setClassName(newName);
                entry.setFullName(entry.getClassName()+"."+entry.getMethodName());
            }
		}
	}
	
	/**
	 * Filter out trival methods
	 * @param list
	 */
	private void filter(List<Entry> list) {
		for (String fullName : dropList) {
			 List list1;
		do {
	          list1=findSequence(fullName,list);
	          list.removeAll(list1);
		}while(list1.size()!=0);
 
		}
	}
	
	private void merge(List<Entry> list)
	{
		Set<String> keys= new HashSet<String>();
		for(Entry entry:list)
		{
           keys.add(entry.getClassName());
		}
		
		for(String key: keys)
		{
			List<Entry> enteringList =new LinkedList();
			List<Entry> leavingList =new LinkedList();
			
			for (Entry entry: list)
			{
				if (entry.className.equalsIgnoreCase(key))
				{
					if (entry.isEnter) enteringList.add(entry);
					else leavingList.add(entry);
				}
			}
			
			if (enteringList.size()>1)
			{
				enteringList.remove(0);
				list.removeAll(enteringList);
			}
			
			if (leavingList.size()>1)
			{
				int time = sum(leavingList);
				leavingList.get(0).setTime(time);
				leavingList.get(0).setCount(leavingList.size());
				leavingList.remove(0);
				list.removeAll(leavingList);
			}
		}
	}
	
	private boolean merge(List<Entry> list1, List<Entry> list2)
	{
		boolean ret=false;
		if (list1.size()==2 && list2.size()==2 &&
				list1.get(0).getFullName().equalsIgnoreCase(list2.get(1).getFullName()))
				{
			      Entry entry1=list1.get(1);
			      Entry entry2=list2.get(1);
			      
			      entry1.setTime(entry1.getTime()+ entry2.getTime());
			      entry1.setCount(entry1.getCount()+1);
			      ret=true;
				}
		return ret;
	}
	
	private int sum(List<Entry> list)
	{
		int total=0;
		for(Entry entry: list)
		{
			total +=entry.getTime();
		}
		return total;
	}
	/**
	 * Find out the sequence within the same thread.
	 * @param fullName
	 * @param list
	 * @return
	 */

	List<Entry> findSequence(String fullName, List<Entry> list) {
		List<Entry> newList = new LinkedList<Entry>();
		String thread = null;
		for (Entry entry : list) {
			if (entry.getFullName().equalsIgnoreCase(fullName)
					&& entry.isEnter())
			{
				if (thread==null)
				{
				  thread = entry.getThread();
				  newList.add(entry);
				}
			} 
			else if (entry.isSameThread(thread))
			{
				newList.add(entry);
				if (entry.getFullName().equalsIgnoreCase(fullName)
						&& !entry.isEnter()) {
					break;
				}
			}
		}
		return newList;
	}

	/**
	    * Convert entering-leaving pairs to sequence diagram languages
	    * 
	    * @param list
	    * @return
	    */

		public void generateSequenceText(List<Entry> list, StringBuilder builder) {
			Entry lastEnter=null;
			
			for (Entry entry : list) {
				if (entry.isEnter()) {
					builder.append("\n" + getAlaias(stack.lastElement().getClassName()) + "->" + getAlaias(entry.getClassName()) + ":"
							+ getAlaias(entry.getMethodName()));
					stack.push(entry);
					lastEnter=entry;
				} else {
					stack.pop();
					if (entry.getFullName().equalsIgnoreCase(lastEnter.getFullName()))
					{
						builder.append(" " + entry.getTime() + " ms");
					}
					else
					{
						builder.append("\n" + getAlaias(entry.getClassName()) + "->" + getAlaias(stack.lastElement().className) + ":"
								+ entry.getTime() + " ms");
					}
					
					if (entry.getCount()>1)
					{
						builder.append(" (" + entry.getCount() +")");
					}
					
				}
//	          System.out.println(builder.toString());
			}
		}
		
		private String getAlaias(String key)
		{
			String value= alaisMap.get(key);
			if (value==null) value=key;
			return value;
		}
	/**
	 * Generate sequence Diagram 
	 * 
	 * ClassA->ClassB:method
	 * 
	 * @param text
	 * @param outFile
	 * @param style
	 */
	public  void getSequenceDiagram(String text, String outFile,String style)
	{
		writeSequence(text, getFileName(outFile,".txt"));
		outFile= getFileName(outFile, ".png");
		
		try {
			// Build parameter string
			String data = "style=" + style + "&message="
					+ URLEncoder.encode(text, "UTF-8");

			// Send the request
			URL url = new URL("http://www.websequencediagrams.com");
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(
					conn.getOutputStream());

			// write parameters
			writer.write(data);
			writer.flush();

			// Get the response
			StringBuffer answer = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				answer.append(line);
			}
			writer.close();
			reader.close();

			String json = answer.toString();
			int start = json.indexOf("?img=");
			int end = json.indexOf("\"", start);

			url = new URL("http://www.websequencediagrams.com/"
					+ json.substring(start, end));
            System.out.println("Writing file to " +outFile);
			OutputStream out = new BufferedOutputStream(new FileOutputStream(
					outFile));
			InputStream in = url.openConnection().getInputStream();
			byte[] buffer = new byte[1024];
			int numRead;
			long numWritten = 0;
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				numWritten += numRead;
			}

			in.close();
			out.close();

		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}


	private String findFirst(List<Entry> list) {
		for (Entry entry : list) {
			if (entry.isEnter()) {
				return entry.getFullName();
			}
		}
		return null;
	}
	
	public void writeCSV(String fileName)
	{
			FileWriter fstream;
			try {
				fstream = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(fstream);
            for(String string: summaryList)			
            {
            	out.write(string);
		    }
            out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void writeSequence(String content, String fileName)
	{
			FileWriter fstream;
			try {
				fstream = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(fstream);
            out.write(content);
            out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private static String getFileName(String name, String extension)
	{
		return inputPath + "/" + name + extension;
	}
}
