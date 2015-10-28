import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BowlingGameTest {
	private Game game;
	
	@Before
	public void setUp() {
		game = new Game();
	}
	
	@Test
	public void testGutterGame() {
		for(int i = 0; i < 20; i++) {
			game.roll(0);
		}
		assertEquals(0, game.score());
	}
	
	@Test
	public void testAllOnes() {
		for(int i = 0; i < 20; i++) {
			game.roll(1);
		}
		assertEquals(20, game.score());
	}
}
