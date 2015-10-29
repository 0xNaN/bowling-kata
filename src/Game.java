
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
		for(int indexFrame = 0; indexFrame < 10; indexFrame++) {
			if(rolls[indexFrame] + rolls[indexFrame + 1] == 10) {
				//spare
				score += 10 + rolls[indexFrame + 2]; //spareBonus
				indexFrame++;
			} else {
				score += rolls[indexFrame] + rolls[indexFrame + 1];
			}
		}
		return score;
	}

}
