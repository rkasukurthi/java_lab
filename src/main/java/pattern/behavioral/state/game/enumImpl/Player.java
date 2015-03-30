package pattern.behavioral.state.game.enumImpl;
/**
 * Demonstrate a state pattern implements using java 1.5 enum
 * 
 * @author zluo
 *
 */
public enum Player {
	WHITE("white played, black's turn")
	{
		Player play() {
			System.out.println(WHITE.message);
			return BLACK;
		}
	},
	BLACK("black palyed, white's turn")
	{
		Player play() {
          System.out.println(BLACK.message);
          return WHITE;
		}
		
	};
	
    // definitions
    
	private String message;
    
	private Player(String message) {
		this.message = message;
	}

	/**
	 * Define a abastract method 
	 */
	abstract Player play(); 

}
