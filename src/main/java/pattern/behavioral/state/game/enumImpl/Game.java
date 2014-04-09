package pattern.behavioral.state.game.enumImpl;


/**
 * This example demonstrate State Pattern using 
 * The State pattern is a solution to the problem 
 * of how to make behavior depend on state.
 * <p>
 * <img src='StateContext.png'/>
 * </p>
 * 
 * <li>Define a "context" class to present a single interface to the outside world.
 * <li>Define a State abstract base class. In this example, using enum define the abstract base class.
 * <li>Represent the different "states" of the state machine as derived classes of the State base class.
 * <li>Define state-specific behavior in the appropriate State derived classes.
 * <li> Maintain a pointer to the current "state" in the "context" class.
 * <li>To change the state of the state machine, change the current "state" pointer.
 * <pre>Note</pre>
 * The State pattern does not specify where the state transitions will be defined. 
 * The choices are two: the "context" object, or each individual State derived class. 
 * 
 * <li>The advantage of the latter option is ease of adding new State derived classes. 
 * <li>The disadvantage is each State derived class has knowledge of (coupling to) its siblings,
 *  which introduces dependencies between subclasses. [GoF, p308]
 * 
 * @author zluo
 *
 */

public class Game {
  private Player state=Player.WHITE;
  
  /**
   * Changing states 
   */
  public void play()
  {
	  state=state.play();
  }
  
  public static void main(String[] args)
  {
	  Game game = new Game();
	  game.play();
	  game.play();
	  game.play();
	  game.play();
	  
  }
}
