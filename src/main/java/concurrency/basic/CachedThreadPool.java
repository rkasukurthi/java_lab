package concurrency.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executor is the new feature of Java 5
 * 
 * @author zluo
 * 
 */
public class CachedThreadPool {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}
