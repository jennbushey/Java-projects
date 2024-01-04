 /*
 * Course: ENSF 607 – Fall 2023 
 * Lab #: Lab 2
 * Instructor: Tim Reimer 
 * Student Name: Jenn Bushey, Mehreen Akmal
 * Submission Date: October 6, 2023
 */ 
public class SmartPlayer extends BlockingPlayer {

	public SmartPlayer(String name, char mark) {
		super(name, mark);
	}

	@Override
	protected void makeMove() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				// test if blocking
				if (board.getMark(row, col) == SPACE_CHAR) {
					if (testForWinning(row, col)) {
						System.out.println();
						board.addMark(row, col, mark);
						return;
					}
				}
			}
		}
		super.makeMove();
	}

	protected boolean testForWinning(int row, int col) {
		// return true if there is a situation that can be won immediately.
		int result = 0;
		// check horizontal  // works
		if (result == 0) {
			for (int i = 0; i < 3; i++) {
				if (board.getMark(row, i) == mark) {
					result++;
				}
			}
			if (result == 2) {
				return true;
			}
			result = 0;
		}

		// check vertical  // works
		if (result == 0) {
			for (int i = 0; i < 3; i++) {
				if (board.getMark(i, col) == mark) {
					result++;
				}
			}
			if (result == 2) {
				return true;
			}
			result = 0;
		}

		// check RHF
		if (result == 0 && row == col) {
			for (int i = 0; i < 3; i++) {
				if (board.getMark(i, i) == mark) {
					result++;
				}
			}
			if (result == 2) {
				return true;
			}
			result = 0;
		}

		// check LHF
		if (result == 0 && col == (3 - 1 - row)) {
			for (int i = 0; i < 3; i++) {
				if (board.getMark(i, 3 - 1 - i) == mark) {
					result++;
				}
			}
			if (result == 2) {
				return true;
			}
		}
		return false;
	}

}
