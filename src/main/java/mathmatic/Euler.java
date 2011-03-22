package mathmatic;

public class Euler {
	/**
	 * Emuler 
	 * e =(1 + 1/n) power n
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		
            double i=1.0e10;		
			double e=1.0;
			double base = 1 + 1.0/i;
            	e=Math.pow(base, i);
            System.out.println("[i= " + i +"], [e = " + e +"]" );
	}

}
