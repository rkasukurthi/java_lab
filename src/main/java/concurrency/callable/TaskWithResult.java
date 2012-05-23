package concurrency.callable;

import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 
 * In this sample demonstrate Callable and Future Class
 * 
 * 
 * @author zluo
 *
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
//		ExecutorService exec
		
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results= new ArrayList<Future<String>>();
		
		for(int i=0; i<10; i++)
		{
			results.add(exec.submit(new TaskWithResult(i)));
		}
		
		for(Future<String> fs: results)
		{
			//get() blocks untils completion:
			
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally
			{
				exec.shutdown();
			}
			
		}
	}
	
}
