package concurrency.forkjoin;

public class AvailableProcessors {
	
	public static void main(String[] args)
	{
		int nThreads = Runtime.getRuntime().availableProcessors();
		System.out.println(" Avialable Processors: " + nThreads);
		
	}

}
