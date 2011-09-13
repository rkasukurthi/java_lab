package log.analyzer;

public class Entry {
  int line;
  boolean isEnter=false;
  String thread;
  String className="Client";
  String methodName="Client";
  String fullName="Client";
  int time;
  int count=1;
  
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public Entry(int line) {
	super();
	this.line = line;
}
public int getLine() {
	return line;
}
public void setLine(int line) {
	this.line = line;
}
public boolean isEnter() {
	return isEnter;
}
public void setEnter(boolean isEnter) {
	this.isEnter = isEnter;
}
public String getThread() {
	return thread;
}
public void setThread(String thread) {
	this.thread = thread;
}
public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
public String getMethodName() {
	return methodName;
}
public void setMethodName(String methodName) {
	this.methodName = methodName;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}


public int getTime() {
	return time;
}
public void setTime(int time) {
	this.time = time;
}

public boolean isSameThread(String thread)
{
	return this.thread.equals(thread);
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + line;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Entry other = (Entry) obj;
	if (line != other.line)
		return false;
	return true;
}


@Override
public String toString() {
	return "Entry [line=" + line + ", isEnter=" + isEnter + ", thread="
			+ thread + ", className=" + className + ", methodName="
			+ methodName + ", fullName=" + fullName + ", time=" + time + "]";
}
/**
 * Build the log Entry
 * All logs assume follow this format
 * entering ProcessUtil.handleDeferred
 * leaving ProcessUtil.calculateChecksum: 1 ms
 * 
 * @param line
 * @param str
 * @return
 */
static Entry build(int line, String str) 
{
	Entry entry= new Entry(line);
//	System.out.println(str);
	String[] arr=str.split(" ");
	entry.setThread(arr[1]);
	entry.setEnter(arr[2].equalsIgnoreCase("entering"));
    if (!entry.isEnter())
    {
    	entry.setFullName(arr[3].substring(0,arr[3].length()-1));
    }
    else
    {
    	entry.setFullName(arr[3]);
    }
    String[] arr1=entry.getFullName().split("\\.");
    if (arr1.length<2) System.out.println("-------------" + entry.getFullName());
    entry.setClassName(arr1[0]);	
    entry.setMethodName(arr1[1]);
    if (!entry.isEnter()) entry.setTime(Integer.parseInt(arr[4]));   
	return entry;
}
  
}
