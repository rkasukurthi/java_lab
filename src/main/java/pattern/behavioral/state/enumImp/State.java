package pattern.behavioral.state.enumImp;
/**
 * Demonstrate a state pattern implements using java 1.5 enum
 * 
 * @author zluo
 *
 */
public enum State {
	HIGH("high")
	{
		State transitionState() {
			System.out.println(HIGH.message);
			return LIGHT;
		}
	},
	LOW("low")
	{
		State transitionState() {
          System.out.println(LOW.message);
          return HIGH;
		}
		
	}	,
    LIGHT("light")
    {
		State transitionState() {
			   System.out.println(LIGHT.message);	
			   return OFF;
		}
    },
    OFF("off")
    {
    	State transitionState() {
			 System.out.println(OFF.message);	
			 return LOW;
		}
    	
    };
	
	private String message;
    
	private State(String message) {
		this.message = message;
	}

	/**
	 * Define a abastract method 
	 */
	abstract State transitionState(); 

}
