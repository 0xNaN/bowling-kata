import static org.junit.Assert.*;

import org.junit.Test;


public class GameTest {

	@Test public void
	score_is_zero_if_no_pins_was_hit() {
		Game game = new Game();
		for(int i = 0; i < 20; i++) {
			game.roll(0);
		}
		assertEquals(0, game.score());
	}
	
	@Test public void
	score_is_twenty_if_one_pin_is_hit_for_roll() {
		Game game = new Game();
		for(int i = 0; i < 20; i++) {
			game.roll(1);
		}
		assertEquals(20, game.score());
	}
}
