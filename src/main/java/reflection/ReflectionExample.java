package reflection;

public class ReflectionExample implements IServices {

	
	public void calcuate(int p1, int p2)
	{
		System.out.println("Class name: ") ;
		System.out.println("Class name: " + this.getClass().getName());
		
		/**Understanding enclosingMethod means I'm inside which method, or to which method called me 
		* the immediately enclosing method of the underlying class, if
	    * that class is a local or anonymous class; otherwise <tt>null</tt>.
	    */
		System.out.println("Method name: " + new Object(){}.getClass().getEnclosingMethod().getName());
		
	}

	public static void main(String[] args)
	{
		ReflectionExample example = new ReflectionExample();
		example.calcuate(1, 2);
	}
	
}


interface IServices
{
	void calcuate(int pa1, int pa2);
}
