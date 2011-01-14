package pattern.template;

/**
 *  <pre>
 *  Template Method Pattern
 *  
 *  1. Standardize the skeleton of an algorithm in a base class's "template" method.
 *  
 *  in this example: 
 *  <li>base class is: <code>Generalization</code> class</li>
 *  <li>template method is: <code>solution</code> method.</li>
 *  
 *  2. Common implementations of individual steps are defined in the base class
 *    
 *    in this example: 
 *      <code>stepOne</code> and <code>stepTwo</code> is the common implementations
 *    
 *  3. Steps requiring peculiar implementations are "placeholders" in base class.
 *      <code>stepThree</code> and <code>stepFour</code> is the abstract method as the placeholder
 *  
 *  
 * @author zluo

 */

public abstract class Generalization 
{
 
	public void solution()
   {
	 stepOne();
	 stepTwo();
	 stepThree();
	 stepFour();
   }
	
	protected void stepOne()
	{
		System.out.println(Generalization.class.getName() + ".setpOne");
	}
	
	abstract protected void stepTwo();
	abstract protected void stepThree();

	protected void stepFour()
	{
		System.out.println(Generalization.class.getName() + ".setpFour");
	}
	
}
