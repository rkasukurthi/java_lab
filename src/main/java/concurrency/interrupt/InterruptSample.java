package concurrency.interrupt;
/**
 * 
 * This class demontrate how sleep are interrupted.
 * by explicitly call thread.interrupt();
 * @author zluo
 *
 */
public class InterruptSample implements Runnable {

	public void run() {
	   int i=0;
	   while (true)
	   {
       System.out.println("I am sleeping daemon");
       while(!Thread.interrupted())
       {
    	   try {
    		   System.out.println("Hibernating " + i++);
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			System.out.println(" I was interrupted, I can sleep again");
			Thread.currentThread().interrupt();
		}
       }
       
       System.out.println("Finish my job ...");
	   }
       
	}
	
	
	public static void main(String[] args) throws InterruptedException
	{
		Thread thread = new Thread(new InterruptSample());
//		thread.setDaemon(true);
		thread.start();
		
		Thread.sleep(2500);
		thread.interrupt();
		Thread.sleep(2500);
		thread.interrupt();
		Thread.sleep(2500);
		thread.interrupt();
	} 

}
