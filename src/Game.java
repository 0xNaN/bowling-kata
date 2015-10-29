
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
		for(int indexFrame = 0; indexFrame < 20; indexFrame++) {
			if(rolls[indexFrame] == 10) {
				//strike
				score += 10 + rolls[indexFrame + 1] + rolls[indexFrame + 2];
			} else if(isSpare(indexFrame)) {
				score += 10 + spareBonus(indexFrame);
				indexFrame++;
			} else {
				score += frameValue(indexFrame);
				indexFrame++;
			}
		}
		return score;
	}

	private int frameValue(int indexFrame) {
		return rolls[indexFrame] + rolls[indexFrame + 1];
	}

	private int spareBonus(int indexFrame) {
		return rolls[indexFrame + 2];
	}

	private boolean isSpare(int indexFrame) {
		return frameValue(indexFrame) == 10;
	}

}
