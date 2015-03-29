package concurrency.basic;

public class MainThread {
  public static void main(String[] args)
  {
	  System.out.println("Waiting for LiftOff");
	  for(int i=0; i<5; i++)
	  {
		  new Thread(new LiftOff()).start();
	  }
  }
}
