package concurrency.interrupt;

public class InterruptSample implements Runnable {

	public void run() {
	   int i=0;
       System.out.println("I am sleeping daemon");
       while(!Thread.interrupted())
       {
    	   try {
			Thread.sleep(1000);
			System.out.println("sleeping " + i++);
		} catch (InterruptedException e) {
			System.out.println(" I was interrupted, I can sleep again");
			Thread.currentThread().interrupt();
		}
       }
	}
	
	
	public static void main(String[] args) throws InterruptedException
	{
		Thread thread = new Thread(new InterruptSample());
//		thread.setDaemon(true);
		thread.start();
		
		Thread.sleep(2500);
		thread.interrupt();
	} 

}
