package enumaration;

import java.util.EnumSet;

public class EnumExamples {
  
  public static void main(String[] args)	
  {
	  log("Ecercising enumerations....");
	  exerEnumsMiscellaneous();
	  exerEnumRange();
  }
	
  private static void log(Object aText)
  {
	  System.out.println(String.valueOf(aText));
  }
  /**
   * Example 1 - Simple list of enum constants
   * 
   * These are called "enum constants".
   * An enum type has no instances other than those defined by its
   * enum constants.
   * @author zluo
   *
   */
  enum Quark
  {
	  UP,
	  DOWN,
	  CHARM,
	  STRANGE,
	  BOTTOM,
	  TOP
  }
  
  /**
   * Example 2 - adding a constructor to an enum.
   */
  public enum Lepton {
	  
	  ELECTRON (-1,1.0E-31),
	  NEUTRINO(0,0.0);
	  
	private Lepton(int aCharge, double aMass)  
	{
		fCharge = aCharge;
		fMass=aMass;
	}
	
	public int getfCharge() {
		return fCharge;
	}
	public double getfMass() {
		return fMass;
	}

	private final int fCharge;
	private final double fMass;
  }
  
  
  /**
   * Example 3 - adding methods to an enum.
   * implicitly static, final
   */
  
  static public enum Direction
  {
	  NORTH,
	  SOUTH,
	  EAST,
	  WEST; //semicolon needed only when extending behavior
  
  @Override
  /**
   * Either name() or super.toString() may be called here.
   * name() is final, and always returns the exact name as 
   * specified in declaration; toString is not final, and is
   * intended for presentation to the user.
   */
  public String toString()
  {
	  return "Direction: " + name(); 
  }
  
  /**
   *  An added method, only NORTH is cold 
   */

  public boolean isCold()
  {
	  
	  return this==NORTH;
  }
  
  }
  
/**
 * Example 4 - adding a method which changes the state of enum constants.
 * 
 */
  private enum Flavor{
	  CHOCOLATE(100),
	  VANILLA(120),
	  STRAWBERRY(80);
	  
	public int getfCalories() {
		return fCalories;
	}

	public void setfCalories(int fCalories) {
		this.fCalories = fCalories;
	}

	private Flavor(int fCalories) {
		this.fCalories = fCalories;
	}

	private int fCalories;
  }
  
  /**
   * What follows are various methods which exercise the above enums.
   * 
   */
private static void exerEnumsMiscellaneous()
  {
	// toString method by default uses the identifier
	  
	  log ("toString:" + Quark.BOTTOM);
	  
	// equals and == amount to the same thing
	 if (Quark.UP==Quark.valueOf("UP"))
	 {
		 log("Quark.UP==Quark.valueOf(\"UP\")");
	 }
	  
		// equals and == amount to the same thing
	 if (Quark.UP.equals(Quark.valueOf("UP")))
	 {
		 log("Quark.UP==Quark.valueOf(\"UP\")");
	 }
	  
		// equals and == amount to the same thing
	 if (Flavor.CHOCOLATE==Flavor.valueOf("CHOCOLATE"))
	 {
		 log("Flavor.CHOCOLATE==Flavor.CHOCOLATE(\"UP\")");
	 }

	 Flavor ch = Flavor.CHOCOLATE;
	 
	 Flavor.CHOCOLATE.setfCalories(10000);
	 
	 log("Chocolate's caloris: " + ch.getfCalories());
	 
	//compareTo order is defined by order of appearance in the definition of
	//the enum
	if ( Quark.UP.compareTo(Quark.DOWN) < 0 ) {
	//this branch is chosen
	log("UP before DOWN");
	}
	else if ( Quark.UP.compareTo(Quark.DOWN) > 0 ) {
	log("DOWN before UP");
	}
	else {
	log("UP same as DOWN");
	}
	
	//values() returns Quark[], not List<Quark>
	log("Quark values : " + Quark.values());
	//the order of values matches the order of appearance :
	for ( Quark quark : Quark.values() ){
	log("Item in Quark.values() : " + quark);
	}
	 
	
	log("toString : " + Direction.NORTH);
	if ( Direction.EAST.isCold() ){
	log("East is cold");
	}
	else {
	log("East is not cold.");
	}
  }
  
  private static void exerEnumRange()
  {
	  for(Direction direction: EnumSet.range(Direction.NORTH, Direction.SOUTH)) {
		  log("NORTH-SOUTH: " + direction);
	  }
  }
  
  
}
