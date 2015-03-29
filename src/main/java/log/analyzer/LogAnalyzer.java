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


import sequencediagram.SequenceDiagramUtils;

/**
 * This class generate AWS Sequence Diagram based on leaving and entering logs.
 * 
 * 
 * C:/TEMP/JPMC_LOG/silanis_aix_10docs.log
 * 
 * @author zluo
 * 
 */

public class LogAnalyzer {

	/**
	 * Drop the entry which contain these key words.
	 */
	String[] dropList = { "SetAttributeAction.complete",
			// "AwsSOAPBindingImpl.getDocumentPageImage",
			"DocumentAction.complete",
	// "AwsSOAPBindingImpl.getAutographImage"
	};
	
	String[] findList = {};
	// "AwsSOAPBindingImpl.getDocumentPageImage" };

	Map<String, String> alaisMap = new HashMap<String, String>();
	Map<String, String> DEMap = new HashMap<String, String>();

	Stack<Entry> stack = new Stack<Entry>();
	List<Entry> logs = new LinkedList<Entry>();

	static StringBuilder builder = new StringBuilder();
	static StringBuilder mergedbuilder = new StringBuilder();
	static StringBuilder summarybuilder = new StringBuilder();
	static List<String> summaryList = new ArrayList();
	static StringBuilder csvFilebuilder = new StringBuilder();
	static boolean genDiagramOnline=false;
	static String proxy_url;
	
	private static String inputPath = null;

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		if (args.length < 1) {
			System.out.println("Usage: java [-Ddiagram=(true)|false -Dhttp.proxyHost=url -Dhttp.proxyPort=80] -jar LogAnalyzer.jar log_file");
			System.out.println("  ");
			System.out.println("example 1: Disable Generate Sequence Diagram");
			System.out.println("====================================================================== ");
			System.out.println("  ");
			System.out.println("java -Ddiagram=false -jar LogAnalyzer.jar log_file");
			System.out.println("  ");
			System.out.println("====================================================================== ");
			System.out.println("  ");
			System.out.println("  ");
			System.out.println("example 2: Generate Sequence Diagram by Proxy");
			System.out.println("====================================================================== ");
			System.out.println("  ");
			System.out.println("java  -Dhttp.proxyHost=url -Dhttp.proxyPort=80 -jar LogAnalyzer.jar log_file");
			System.out.println("  ");
			System.out.println("For detail of proxy setting, see http://download.oracle.com/javase/6/docs/technotes/guides/net/properties.html");
			System.out.println("====================================================================== ");
			System.exit(1);
		}
		
		genDiagramOnline = Boolean.valueOf(System.getProperty("diagram","true"));
		proxy_url=System.getProperty("proxy.url", null);
		
		LogAnalyzer analyzer = new LogAnalyzer();
		analyzer.init();
		analyzer.readFiles(args);
		analyzer.find();
//		System.out.println(builder.toString());
		System.out.println("[Log Analyze] Takes total " + (System.currentTimeMillis() - start) + " ms. to analyze log files");

		File file = new File(args[0]);
		inputPath = file.getParent() + "/results" + System.currentTimeMillis();
		new File(inputPath).mkdirs();

		analyzer.getSequenceDiagram(builder.toString(), "detail_diagram",
				"rose");

		analyzer.getSequenceDiagram(mergedbuilder.toString(), "simple_diagram",
				"rose");

		analyzer.getSequenceDiagram(summarybuilder.toString(),
				"summary_diagram", "rose");

		analyzer.writeCSV(getFileName("summary", ".csv"));
		
		
		System.out.println("Takes total " + (System.currentTimeMillis() - start) + " ms.");
		
		if (!genDiagramOnline)
		{
			System.out.println("online generate sequence diagram is disabled. For manully generate diagram, go to http://www.websequencediagrams.com");
		}

	}

	public void init() {
		stack.push(new Entry(0));
		addAlais();
		addDEmaps();
		summaryList.add("Name,Total Time ,DB Time,DE Time, eSEPT Time\n");
	}

	public void addAlais() {
		alaisMap.put("CommandExecutor$GuidLoader", "DB");
		alaisMap.put("CommandExecutor$DefaultStorer", "DB");
		alaisMap.put("loadTX", " ");
		alaisMap.put("storeTX", " ");
		alaisMap.put("complete", " ");
	}

	public void addDEmaps() {
		DEMap.put("CommandExecutor", "DB");
		DEMap.put("CommandExecutor$GuidLoader", "DB");
		DEMap.put("CommandExecutor$DefaultStorer", "DB");
		DEMap.put("RenderAction", "DE");
		DEMap.put("ExtractAction", "DE");
		DEMap.put("CustomizeAction", "DE");
		DEMap.put("BindAction", "DE");
		DEMap.put("FlattenAction", "DE");
		DEMap.put("AwsSOAPBindingImpl", "eSEP");
		DEMap.put("JMS", "eSEP");
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

//		LineIterator it=null;
//		 try {
//	    	 it = FileUtils.lineIterator(new File(fileName), "UTF-8");
//	    	 int line = 1;
//	    	 while (it.hasNext()) {
//		     String strLine = it.nextLine();
//		     logs.add(Entry.build(line++, strLine));
//		   }
//		 } catch (IOException e1) {
//		 } finally {
//		   LineIterator.closeQuietly(it);
//		 }
		// leaving this code for comparison
		
		try {
			// Get the object of DataInputStream
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new DataInputStream(new FileInputStream(fileName))));
			String strLine;
			int line = 1;
			while ((strLine = br.readLine()) != null) {
				logs.add(Entry.build(line++, strLine,1));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void workroundAddingJMSlogs(List<Entry> list)
	{
		if (list.get(0).getMethodName().equalsIgnoreCase("loadTX"))
		{
		  Entry entry = new Entry(0);	
		  entry.setLine(list.get(0).getLine()-1);
          entry.setClassName("JMS");
          entry.setMethodName("postOnline");
          entry.setEnter(true);
          entry.setFullName("JMS.postOnline");
          entry.setThread(list.get(0).getThread());
          entry.setTime(-1);
          
          list.add(0,entry);
          
          
		  Entry entry1 = new Entry(0);	
		  entry1.setLine(list.get(list.size()-1).getLine()+1);
          entry1.setClassName("JMS");
          entry1.setEnter(false);
          entry1.setMethodName("postOnline");
          entry1.setFullName("JMS.postOnline");
          entry1.setThread(list.get(0).getThread());
          entry1.setTime(-1);
          
          list.add(entry1);
          
		}
	}
	
	public void find() {
		List<Entry> previousList = null;
		while (true) {
			String first = findFirstEnteringEntry(logs);
			if (first != null) {
				List<Entry> list = findSequence(first, logs);

				// System.out.println(list.size());
				logs.removeAll(list);
                
				workroundAddingJMSlogs(list);
				
				if (!(list.get(0).getClassName()
						.equalsIgnoreCase("AwsSOAPBindingImpl") ||list.get(0).getClassName()
						.equalsIgnoreCase("JMS")))
					continue;

				filterOut(list);

				generateSequenceText(list, builder);

//				if (list.get(0).getMethodName().equals("getAutographImage")) {
//					System.out.println(list.get(0).getMethodName());
//				}

				if (list.size() == 2) {
					if (previousList == null) {
						previousList = list;
					} else {

						if (!merge(previousList, list)) {
							extracted(previousList);
							previousList = list;
						}
					}
				} else {
					if (previousList != null) {
						extracted(previousList);
						previousList = null;
					}
					merge(list);
					generateSequenceText(list, mergedbuilder);
					// System.out.println(logs.size());

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
			previousList = null;
		}
	}

	/**
	 * 
	 * @param list
	 */

	public void generateCSV(List<Entry> list) {
		if (list.size() == 0)
			return;

		StringBuilder builder = new StringBuilder();
		String method;
		int deTime = 0;
		int dbTime = 0;
		int eSEPTime = 0;
		int total = 0;
		for (Entry entry : list) {
			if (!entry.isEnter() && entry.getClassName().equalsIgnoreCase("DE")) {
				deTime = entry.getTime();
			}

			if (!entry.isEnter() && entry.getClassName().equalsIgnoreCase("DB")) {
				dbTime = entry.getTime();
			}
		}
		method = list.get(list.size() - 1).getMethodName();
		if (list.get(list.size() - 1).getCount() > 1) {
			method = method + " (" + list.get(list.size() - 1).getCount() + ")";
		}
		total = list.get(list.size() - 1).getTime();
		
		if (total !=-1)
		{
		  eSEPTime = total - deTime - dbTime;
		}
		else
		{
		  eSEPTime=-1;
		}
		
		String out = method + "," + total + "," + dbTime + "," + deTime + ","
				+ eSEPTime + "\n";
		summaryList.add(out);
	}

	public void replaceFullName(List<Entry> list) {
		for (Entry entry : list) {
			String newName = DEMap.get(entry.getClassName());
			// System.out.println(entry.getFullName());
			if (newName != null) {
				entry.setClassName(newName);
				entry.setFullName(entry.getClassName() + "."
						+ entry.getMethodName());
			}
		}
	}

	/**
	 * Filter out trival methods
	 * 
	 * @param list
	 */
	private void filterOut(List<Entry> list) {
		for (String fullName : dropList) {
			List list1;
			do {
				list1 = findSequence(fullName, list);
				list.removeAll(list1);
			} while (list1.size() != 0);

		}
	}

	private void merge(List<Entry> list) {
		Set<String> keys = new HashSet<String>();
		for (Entry entry : list) {
			keys.add(entry.getClassName());
		}

		for (String key : keys) {
			List<Entry> enteringList = new LinkedList();
			List<Entry> leavingList = new LinkedList();

			for (Entry entry : list) {
				if (entry.className.equalsIgnoreCase(key)) {
					if (entry.isEnter)
						enteringList.add(entry);
					else
						leavingList.add(entry);
				}
			}

			if (enteringList.size() > 1) {
				enteringList.remove(0);
				list.removeAll(enteringList);
			}

			if (leavingList.size() > 1) {
				int time = sum(leavingList);
				leavingList.get(0).setTime(time);
				leavingList.get(0).setCount(leavingList.size());
				leavingList.remove(0);
				list.removeAll(leavingList);
			}
		}
	}

	private boolean merge(List<Entry> list1, List<Entry> list2) {
		boolean ret = false;
//		if (list1.get(0).getMethodName().contains("getAutographImage")) {
//			System.out.println(list1);
//		}
		if (list1.size() == 2
				&& list2.size() == 2
				&& list1.get(0).getFullName()
						.equalsIgnoreCase(list2.get(1).getFullName())) {

			Entry entry1 = list1.get(1);
			Entry entry2 = list2.get(1);

			entry1.setTime(entry1.getTime() + entry2.getTime());
			entry1.setCount(entry1.getCount() + 1);
			ret = true;
		}
		return ret;
	}

	private int sum(List<Entry> list) {
		int total = 0;
		for (Entry entry : list) {
			total += entry.getTime();
		}
		return total;
	}

	/**
	 * Find out the sequence within the same thread.
	 * 
	 * @param fullName
	 * @param list
	 * @return
	 */

	List<Entry> findSequence(String fullName, List<Entry> list) {
		String start=fullName;
		String end=fullName;
		
		if (start.equalsIgnoreCase("loadTx"))
		{
			end="storeTX";
		}
		
		List<Entry> newList = new LinkedList<Entry>();
		String thread = null;
		for (Entry entry : list) {
			if (entry.getFullName().equalsIgnoreCase(start)
					&& entry.isEnter()) {
				if (thread == null) {
					thread = entry.getThread();
					newList.add(entry);
				}
			} else if (entry.isSameThread(thread)) {
				newList.add(entry);
				if (entry.getFullName().equalsIgnoreCase(end)
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
		Entry lastEnter = null;

		for (Entry entry : list) {
			if (entry.isEnter()) {
				builder.append("\n"
						+ getAlaias(stack.lastElement().getClassName()) + "->"
						+ getAlaias(entry.getClassName()) + ":"
						+ getAlaias(entry.getMethodName()));
				stack.push(entry);
				lastEnter = entry;
			} else {
				stack.pop();
				if (entry.getFullName().equalsIgnoreCase(
						lastEnter.getFullName())) {
					builder.append(" " + entry.getTime() + " ms");
				} else {
					builder.append("\n" + getAlaias(entry.getClassName())
							+ "->" + getAlaias(stack.lastElement().className)
							+ ":" + entry.getTime() + " ms");
				}

				if (entry.getCount() > 1) {
					builder.append(" (" + entry.getCount() + ")");
				}

			}
			// System.out.println(builder.toString());
		}
	}

	private String getAlaias(String key) {
		String value = alaisMap.get(key);
		if (value == null)
			value = key;
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
	public void getSequenceDiagram(String text, String outFile, String style) {
		writeSequence(text, getFileName(outFile, ".txt"));
		
		outFile = getFileName(outFile, ".png");
		if (genDiagramOnline)
		{
          SequenceDiagramUtils.getSequenceDiagram(text, outFile, style);
		}
	
	}

/**
 * Find First entering Entry 
 * @param list
 * @return
 */
	private String findFirstEnteringEntry(List<Entry> list) {
		for (Entry entry : list) {
			if (entry.isEnter()) {
				return entry.getFullName();
			}
		}
		return null;
	}
	

	public void writeCSV(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			for (String string : summaryList) {
				out.write(string);
			}
			out.close();
           System.out.println("Writing file: " + fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeSequence(String content, String fileName) {
		
		FileWriter fstream;
		try {
			fstream = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(content);
			out.close();
            System.out.println("Writing file: " + fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * compose file name,
	 * 
	 * @param name
	 * @param extension
	 * @return
	 */
	private static String getFileName(String name, String extension) {
		return inputPath + "/" + name + extension;
	}
}
