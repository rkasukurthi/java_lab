package enumaration;
/**
 * This class uses an enum to create a little state machine.
 * enum can directly using switch
 * adding duration
 * @author zluo
 *
 */
enum Signal{
	
	GREEN(20),
	YELLOW(2),
	RED(15);
	

  public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

private Signal(int duration) {
	this.duration = duration;
}

private int duration;
}

public class TrafficLight {
	
	//define the enum type as the states
	
 Signal color= Signal.RED;
 
 public void change()
 {
	 switch(color)
	 {
	 case RED:
		 color=Signal.GREEN;
		 break;
	 case GREEN:
		 color=Signal.YELLOW;
		 break;
	 case YELLOW:
		 color=Signal.RED;
		 break;
	 }
 }

 public String toString()
 {
	 return "The traffic light is " + color + " lasting " + color.getDuration() + "s" ;
 }
 
 public static void main(String[] args)
 {
	 TrafficLight t = new TrafficLight();
	 
	 for(int i=0;i<7;i++)
	 {
		 System.out.println(t);
		 t.change();
		 
	 }
 }
 
 
}
