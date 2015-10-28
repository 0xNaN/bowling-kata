
public class Game {
	private int[] rolls = new int[21];
	private int currentRoll = 0;
	
	public void roll(int pins) {
		this.rolls[currentRoll++] = pins;
	}

	public int score() {
		int score = 0;
		int indexFrame = 0;
		for(int frame = 0; frame < 10; frame++) {
			if(isSpare(indexFrame)) {
				score += 10 + rolls[indexFrame + 2];
				indexFrame += 2;
			} else {
				score += rolls[indexFrame] + rolls[indexFrame + 1];
				indexFrame += 2;
			}
		}
		return score;
	}

	private boolean isSpare(int indexFrame) {
		return rolls[indexFrame] + rolls[indexFrame + 1] == 10;
	}

}
