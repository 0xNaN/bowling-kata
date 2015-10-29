
public class Game {
	private static final int MAX_PINS = 10;
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
			if(isStrike(indexFrame)) {
				score += MAX_PINS + frameValue(indexFrame + 1);
			} else if(isSpare(indexFrame)) {
				score += MAX_PINS + spareBonus(indexFrame);
				indexFrame++;
			} else {
				score += frameValue(indexFrame);
				indexFrame++;
			}
		}
		return score;
	}

	private boolean isStrike(int indexFrame) {
		return rolls[indexFrame] == 10;
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
