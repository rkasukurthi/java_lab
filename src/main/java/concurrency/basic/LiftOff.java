package concurrency.basic;
/**
 *  
 * @author zluo
 *
 */
public class LiftOff implements Runnable {
    protected int countDown =10; //Default
    private static int taskCount =0;
    private final int id=taskCount++;

    public LiftOff() {}
    
    
    
	public LiftOff(int countDown) {
		super();
		this.countDown = countDown;
	}
     
	/**
	 * Liftoff! the rocket is rising from its launcing site under its own power.
	 * @return
	 */
    public String status()
    {
    	return "#" + id + "(" + (countDown >0 ? countDown : "Liftoff!") + ").";
    }
    /**
     * Thread.yield() is a suggestion to the thread scheduler that says
     *  "I’ve done the important parts of my cycle and this would be
     *  a good time to switch to another task for a while."
     */
	public void run() {
		while(countDown-- >0)
		{
			System.out.print(status());
			Thread.yield();
		}
	}
}
