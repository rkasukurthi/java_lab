package arrays;
/**
 * This is class shows why array is a object
 * @author zluo
 *
 */
public class ArrayClass {
	
	public static void main(String[] args)
	{
		// print [java.lang.String
		System.out.println(args.getClass().getName());
		
		int[] ints= {1,2,3};
		
		//print [I, this the runtime array class name
		System.out.println(ints.getClass().getName());
		
	}

}
