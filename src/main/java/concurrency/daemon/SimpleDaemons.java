package concurrency.daemon;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable
{

	public void run() {
		while(true) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			} catch (InterruptedException e) {
                System.out.println("I was sleep");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		for (int i=0; i<5; i++)
		{
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("All daemons started");
		TimeUnit.MILLISECONDS.sleep(1750);
	}
}
