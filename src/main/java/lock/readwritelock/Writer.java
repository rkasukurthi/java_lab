package lock.readwritelock;

public class Writer extends Thread {

	private Dictionary dictionary=null;
	private boolean runForestRun=true;
	static int count=0;
	public Writer(Dictionary dictionary, String threadName) {
		super();
		this.dictionary = dictionary;
		this.setName(threadName);
	}
	
	public void run() {
		while (this.runForestRun) {
			String [] keys = dictionary.getKeys();
			for(String key: keys) {
				String newValue=getNewValueFromDataStore(key);
				dictionary.set(key,newValue);
			}
			
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void stopWriter()
	{
		this.runForestRun=false;
		this.interrupt();
	}
	
	public String getNewValueFromDataStore(String key) {
		return "newValue" + count++;
	}
}
