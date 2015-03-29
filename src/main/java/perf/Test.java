package perf;

public class Test {
	
	public static void main(String[] args)
	{
		int z[] = new int[20000000];
		int y=-100;
		int x=5;
		
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < z.length; i++)
			z[i] = x * Math.abs(y);
		
		long end =System.currentTimeMillis()-start;
		
		System.out.format("\nFirst Loop take %d ms", end);
		
		start=System.currentTimeMillis();
		int t1 = x * Math.abs(y);
		for (int i = 0; i < z.length; i++)
		z[i] = t1;
		end =System.currentTimeMillis()-start;
		
		System.out.format("\nSecond Loop take %d ms", end);

	}

}
