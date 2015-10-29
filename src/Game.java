
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
		int indexFrame = 0;
		for(int frame = 0; frame < 10; frame++) {
			if(isStrike(indexFrame)) {
				score += MAX_PINS + strikeBonus(indexFrame);
				indexFrame++;
			} else if(isSpare(indexFrame)) {
				score += MAX_PINS + spareBonus(indexFrame);
				indexFrame += 2;
			} else {
				score += frameValue(indexFrame);
				indexFrame += 2;
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
	
	private int strikeBonus(int indexFrame) {
		return rolls[indexFrame + 1] + rolls[indexFrame + 2];
	}

	private boolean isSpare(int indexFrame) {
		return frameValue(indexFrame) == 10;
	}

}
