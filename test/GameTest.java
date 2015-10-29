import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GameTest {
	private static final int MAX_ROLLS = 20;
	private Game game;
	
	@Before
	public void setUp() {
		game = new Game();
	}

	@Test public void
	score_is_zero_if_no_pins_was_hit() {
		rollMany(MAX_ROLLS, 0);
		assertEquals(0, game.score());
	}
	
	@Test public void
	score_is_twenty_if_one_pin_is_hit_for_roll() {
		rollMany(MAX_ROLLS, 1);
		assertEquals(20, game.score());
	}
	
	@Test public void
	adding_bonus_if_spare() {
		// spare
		game.roll(2);
		game.roll(8);
		// bonus
		game.roll(5);
		rollMany(MAX_ROLLS - 3, 0);
		
		assertEquals(20, game.score());
	}

	private void rollMany(int rolls, int pins) {
		for(int i = 0; i < rolls; i++) {
			game.roll(pins);
		}
	}
}
