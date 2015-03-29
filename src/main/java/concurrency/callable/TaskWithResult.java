package concurrency.callable;

import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * In this sample demonstrate Callable and Future Class
 */
public class TaskWithResult implements Callable {
    
	private int id;
	
	public TaskWithResult(int id) {
		super();
		this.id = id;
	}

	public Object call() throws Exception {
		
		long start = System.currentTimeMillis();
		
		Thread.sleep((10 -id)*1000);
		
		return "result of TaskWithResult " +id + "; finished in " + (System.currentTimeMillis()-start) + " ms. at " + new Time(System.currentTimeMillis());
	}

	public static void main(String[] args)
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results= new ArrayList<Future<String>>();
		
		for(int i=0; i<10; i++)
		{
			results.add(exec.submit(new TaskWithResult(i)));
		}
		
		for(Future<String> fs: results)
		{
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally
			{
				exec.shutdown();
			}
		}
	}
}
