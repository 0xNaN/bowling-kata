
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
			if(isStrike(indexFrame)) {
				score += 10 + strikeBonus(indexFrame);
				indexFrame += 1;
			} else if(isSpare(indexFrame)) {
				score += 10 + spareBonus(indexFrame);
				indexFrame += 2;
			} else {
				score += sumOfBallsInFrame(indexFrame);
				indexFrame += 2;
			}
		}
		return score;
	}
	
	private int sumOfBallsInFrame(int indexFrame) {
		return rolls[indexFrame] + rolls[indexFrame + 1];
	}
	
	private int spareBonus(int indexFrame) {
		return rolls[indexFrame + 2];
	}
	
	private int strikeBonus(int indexFrame) {
		return rolls[indexFrame + 1] + rolls[indexFrame + 2];
	}
	
	private boolean isStrike(int indexFrame) {
		return rolls[indexFrame] == 10;
	}

	private boolean isSpare(int indexFrame) {
		return rolls[indexFrame] + rolls[indexFrame + 1] == 10;
	}

}
