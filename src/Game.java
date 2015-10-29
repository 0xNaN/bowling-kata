
public class Game {
	private static final int MAX_NUMBER_OF_ROLLS = 20;
	private int rolls[] = new int[MAX_NUMBER_OF_ROLLS + 1];
	private int currentRoll = 0;
	
	public void roll(int pins) {
		rolls[currentRoll] = pins;
		currentRoll++;
	}

	public int score() {
		int score = 0;
		for(int roll = 0; roll < rolls.length; roll++) {
			score += rolls[roll];
		}
		return score;
	}

}
