package concurrency.callable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskWithResult implements Callable {
    
	private int id;
	
	public TaskWithResult(int id) {
		super();
		this.id = id;
	}

	public Object call() throws Exception {
		return "result of TaskWithResult " +id;
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
