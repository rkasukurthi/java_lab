package lock.readwritelock;

public class Reader extends Thread {

	private Dictionary dictionary=null;
	private boolean runForestRun=true;
	
	public Reader(Dictionary dictionary, String threadName) {
		super();
		this.dictionary = dictionary;
		this.setName(threadName);
	}
	
	public void run() {
		while (this.runForestRun) {
			String [] keys = dictionary.getKeys();
			for(String key: keys) {
			    //reading from dictionary with READ LOCK
				String value= dictionary.get(key);
			    
				//make what ever you want with the value
				System.out.println(key + ":" + value);
			
			}
			
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void stopReader()
	{
		this.runForestRun=false;
		this.interrupt();
	}
}
