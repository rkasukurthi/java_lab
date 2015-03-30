package enumaration;
/**
 * Test Random Enum
 * @author zluo
 *
 */
public class RandomTest {

	enum Activity{
		SITTING,
		LYING,
		STANDING,
		HOPPPING,
		RUNNING,
		DODGING,
		JUMPING,
		FALLING,
		FLYING
	}
	
	public static void main(String[] args)
	{
		for(int i=0; ++i<20;)
		{
			System.out.print(Enums.random(Activity.class) + " ");
		}
	}
	
}
